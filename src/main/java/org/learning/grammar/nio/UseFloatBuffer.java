package org.learning.grammar.nio;

import java.nio.*;

/**
 * @ClassName: UseFloatBuffer
 * @Description: 类型化缓冲区用法
 * @author carlos.chu
 * @date 2016年3月30日 下午3:13:28
 *
 */
public class UseFloatBuffer {
    public static void main(String args[]) throws Exception {
        //
        FloatBuffer buffer = FloatBuffer.allocate(10);

        for (int i = 0; i < buffer.capacity(); ++i) {
            float f = (float) Math.sin((((float) i) / 10) * (2 * Math.PI));
            buffer.put(f);
        }

        buffer.flip();

        while (buffer.hasRemaining()) {
            float f = buffer.get();
            System.out.println(f);
        }
    }
}
