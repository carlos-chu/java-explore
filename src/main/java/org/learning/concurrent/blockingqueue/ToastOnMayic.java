package org.learning.concurrent.blockingqueue;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.TimeUnit;

/**
 * @ClassName: ToastOnMayic
 * @Description: 演示阻塞队列，三个任务，一个生产吐司，一个给吐司上黄油，一个上果酱
 * @author carlos.chu
 * @date 2016年3月18日 上午10:17:02
 */
public class ToastOnMayic {
    public static void main(String[] args) throws InterruptedException {
        ToastQueue dryQueue = new ToastQueue();
        ToastQueue butteredQueue = new ToastQueue();
        ToastQueue finishedQueue = new ToastQueue();
        ExecutorService exec = Executors.newCachedThreadPool();
        exec.execute(new Toaster(dryQueue));
        exec.execute(new Butterer(dryQueue, butteredQueue));
        exec.execute(new Jammer(butteredQueue, finishedQueue));
        exec.execute(new Eater(finishedQueue));
        TimeUnit.SECONDS.sleep(10);
        exec.shutdownNow();
    }
}

class Toast {
    public enum Status {
        DRY, BUTTERED, JAMMED
    }

    private Status status = Status.DRY;
    private final int id;

    public Toast(int idn) {
        id = idn;
    }

    public void butter() {
        System.out.println("上黄油中...：" + id);
        status = Status.BUTTERED;
    }

    public void jam() {
        System.out.println("上果酱中...:" + id);
        status = Status.JAMMED;
    }

    public Status getStatus() {
        return status;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "吐司 " + id + ": " + status;
    }
}

class ToastQueue extends LinkedBlockingDeque<Toast> {
}

// 做吐司，做好的吐司放到阻塞队列里
class Toaster implements Runnable {

    private ToastQueue toastQueue;
    private int count = 0;
    private Random rand = new Random(47);

    public Toaster(ToastQueue tq) {
        toastQueue = tq;
    }

    @Override
    public void run() {
        try {
            while (!Thread.interrupted()) {
                TimeUnit.MILLISECONDS.sleep(1000 + rand.nextInt(500));
                // 做吐司
                Toast t = new Toast(count++);
                System.out.println("做好的吐司：" + t);
                toastQueue.put(t);
            }
        } catch (Exception e) {
            System.out.println("做吐司任务被打断");
        }
        System.out.println("做吐司任务完成");
    }

}

class Butterer implements Runnable {

    private ToastQueue dryQueue, butteredQueue;

    public Butterer(ToastQueue dry, ToastQueue buttered) {
        this.dryQueue = dry;
        this.butteredQueue = buttered;
    }

    @Override
    public void run() {
        try {
            while (!Thread.interrupted()) {
                Toast t = dryQueue.take();
                TimeUnit.MILLISECONDS.sleep(2000);
                t.butter();
                System.out.println("上好了黄油：" + t);
                butteredQueue.push(t);
            }
        } catch (Exception e) {
            System.out.println("上黄油任务呗打断");
        }
        System.out.println("上黄油结束");
    }
}

// Apply jam to buttered toast:
class Jammer implements Runnable {
    private ToastQueue butteredQueue, finishedQueue;

    public Jammer(ToastQueue buttered, ToastQueue finished) {
        butteredQueue = buttered;
        finishedQueue = finished;
    }

    public void run() {
        try {
            while (!Thread.interrupted()) {
                // Blocks until next piece of toast is available:
                Toast t = butteredQueue.take();
                TimeUnit.MILLISECONDS.sleep(2000);
                t.jam();
                System.out.println("上好了果酱：" + t);
                finishedQueue.put(t);
            }
        } catch (InterruptedException e) {
            System.out.println("Jammer interrupted");
        }
        System.out.println("Jammer off");
    }
}

// Consume the toast:
class Eater implements Runnable {
    private ToastQueue finishedQueue;
    private int counter = 0;

    public Eater(ToastQueue finished) {
        finishedQueue = finished;
    }

    public void run() {
        try {
            while (!Thread.interrupted()) {
                // Blocks until next piece of toast is available:
                Toast t = finishedQueue.take();
                // Verify that the toast is coming in order,
                // and that all pieces are getting jammed:
                if (t.getId() != counter++ || t.getStatus() != Toast.Status.JAMMED) {
                    System.out.println(">>>> Error: " + t);
                    System.exit(1);
                } else
                    System.out.println("Chomp! " + t);
            }
        } catch (InterruptedException e) {
            System.out.println("Eater interrupted");
        }
        System.out.println("Eater off");
    }
}
