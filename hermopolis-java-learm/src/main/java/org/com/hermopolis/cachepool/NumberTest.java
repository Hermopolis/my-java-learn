package org.com.hermopolis.cachepool;

public class NumberTest {
    public static void main(String[] args) {
        byte s0 = 0b0000_0000;//0  0b貌似表示是bit 没深入研究
        System.out.println(s0);//0
        byte s1 = 0b0000_0001;
        System.out.println(s1);//1
        byte s124 = 0b0111_1111;
        System.out.println(s124);//127 最大值  至于为啥第一位不能是1？因为第一位表示正负数

        long l0 = 1L;
        System.out.println("0"+Long.toBinaryString(Long.MAX_VALUE));
        System.out.println(Long.toBinaryString(Long.MIN_VALUE));
        System.out.println(Long.toBinaryString(-Long.MIN_VALUE));
        System.out.println(Long.toBinaryString(Long.MIN_VALUE-1));
    }
}
