package org.learning.jvm.oom;

/**
 * 
 * @ClassName: JVMStackSOF
 * @Description: 虚拟机栈和本地方法栈OOM
 * @author carlos.chu
 * @date 2016年3月10日 下午3:56:42
 *
 */
public class JVMStackSOF {

    private int stackLength = 1;

    public void stackLeak() {
        stackLength++;
        stackLeak();
    }

    /**
     * 栈深度过大导致的stackOverflow，是由于操作数和returnAddress过多到这栈的长度不够
     * 
     * @param args
     * @throws Throwable
     */
    public static void main(String[] args) throws Throwable {
        JVMStackSOF oom = new JVMStackSOF();
        try {
            oom.stackLeak();
        } catch (Throwable e) {
            System.out.println(oom.stackLength);
            throw e;
        }
    }
}
