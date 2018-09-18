package org.learning.grammar;

/**
 * java基础知识
 *
 * @Auther: bjchuwenqiang
 * @Date: 2018/9/18
 */
public class Base {

    /**
     * java8种基础数据类型
     */
    public class BasisDataTypes {
        /**
         * 整形，4byte 32bit
         * 显式的写Integer i = 1;时会进行自动装箱，隐式的调用了Integer.valueOf(i)
         * valueOf() 里面会进行缓存获取，在-128--127之间的数值会直接从缓存中获取，不在new新的类了
         * 所以在比较的时候注意下
         */
        public int intVal = 0;

        /**
         * 字符，2byte 16bit
         * 其包装类型为 Character
         */
        public char charVal = 'a';

        /**
         * 短整型，2byte 16bit
         * 它比int表示的返回正好小一倍
         */
        public short shortVal = 1;

        /**
         * 字节类型，1byte  8bit
         */
        public byte byteVal = 1;

        /**
         * 长整形， 8byte 64bit
         * 它比int正好多一倍的范围
         * 和int一样，也存在缓存现象, 在-128-127范围内会从缓存中取值
         */
        public long longVal = 1L;

        /**
         * 单精度浮点类型  4byte 32bit
         */
        public float floatVal = 0f;

        /**
         * 双精度浮点类型 8byte 64bit
         */
        public double doubleVal = 0d;

        /**
         * 布尔类型
         */
        public boolean booleanVal = false;
    }
}
