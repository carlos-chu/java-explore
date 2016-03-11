package org.learning.jvm.oom;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @ClassName: JVMRuntimeConstantPoolOOM
 * @Description: 虚拟机运行时常量池溢出
 * @author carlos.chu
 * @date 2016年3月10日 下午4:40:22
 *
 */
public class JVMRuntimeConstantPoolOOM {

    public static void main(String[] args) {
        List<String> list = new ArrayList<String>();
        int i = 0;
        while (true) {
            list.add(String.valueOf(i++).intern());
        }
    }
}
