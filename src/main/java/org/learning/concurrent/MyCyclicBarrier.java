package org.learning.concurrent;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * @ClassName: MyCyclicBarrier
 * @Description: 障碍器--分解线程，管理多个线程执行完成
 * @author carlos.chu
 * @date 2016年4月5日 下午3:13:58
 *
 */
public class MyCyclicBarrier {

	public static void main(String[] args) {
		CyclicBarrier cb = new CyclicBarrier(4, new MainTask());
		new SubTask("1", cb).start();
		new SubTask("2", cb).start();
		new SubTask("3", cb).start();
		new SubTask("4", cb).start();
	}
}

/**
 * 主任务
 */
class MainTask implements Runnable {
	public void run() {
		System.out.println(">>>>主任务执行了！<<<<");
	}
}

class SubTask extends Thread {
	private String name;
	private CyclicBarrier cb;

	SubTask(String name, CyclicBarrier cb) {
		this.name = name;
		this.cb = cb;
	}

	@Override
	public void run() {
		System.out.println("[子任务" + name + "]开始执行了！");
		for (int i = 0; i < 999999; i++)
			; // 模拟耗时的任务
		System.out.println("[子任务" + name + "]开始执行完成了，并通知障碍器已经完成！");

		try {
			cb.await();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (BrokenBarrierException e) {
			e.printStackTrace();
		}
	}

}