package org.learning.jvm.oom;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @ClassName: JVMHeapOOM
 * @Description: jvm堆溢出示例
 * @author carlos.chu
 * @date 2016年3月10日 下午3:42:06
 *
 */
public class JVMHeapOOM {

    static class OOMObject {
    	String s = "xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx";
    }

    /**
     * 在JVM堆上一直创建对象，导致堆空间不足，抛出OutOfMemoryError异常，如果不设置-Xms和-Xmx参数 则JVM会自动调节堆的大小，导致很长时间不出现异常，需要设置其参数为小值，不让它自动调节堆空间大小
     * 
     * @param args
     */
    public static void main(String[] args) {
        List<OOMObject> list = new ArrayList<JVMHeapOOM.OOMObject>();
        while (true) {
            list.add(new OOMObject());
        }
    }
}
