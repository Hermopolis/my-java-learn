package org.com.hermopolis.cachepool;

public class CachePool {
    public static void main(String[] args) {
        Integer x = new Integer(123);
        Integer y = new Integer(123);
        System.out.println(x == y);    // false
        Integer z = Integer.valueOf(123);
        Integer k = Integer.valueOf(123);
        System.out.println(z == k);
        char a = '\u0001';
        System.out.println(a);
        // The number 26, in decimal
        int decVal = 26;
//  The number 26, in hexadecimal
        int hexVal = 0x1a;
// The number 26, in binary
        int binVal = 0b11010;
        //转成2进制
        System.out.println(Integer.toBinaryString(-1));
        byte sb = 0b1111;
        System.out.println(sb);
        short ss = 0b1111111_11111111;
        System.out.println(ss);
        int st = 0b1111111_11111111_11111111_11111111;
        System.out.println(st);
        long smin = 0x8000000000000000L;
        long sMax = 0x7fffffffffffffffL;
        System.out.println(smin);
        System.out.println(sMax);

        //111111111111111111111111111111111111111111111111111111111111111
        System.out.println(Long.toBinaryString(Long.MAX_VALUE));
        //
        System.out.println(Long.MAX_VALUE + 1);//-9223372036854775808

        //1000000000000000000000000000000000000000000000000000000000000000
        System.out.println(Long.toBinaryString(Long.MAX_VALUE + 1));
        //1000000000000000000000000000000000000000000000000000000000000000
        System.out.println(Long.toBinaryString(Long.MIN_VALUE));
        System.out.println((Long.MAX_VALUE + 1) == Long.MIN_VALUE);//true

        Integer aa1 = 127;
        Integer aa2 = 127;
        System.out.println(aa1 == aa2);
        Integer aa3 = 128;
        Integer aa4 = 128;
        System.out.println(aa3 == aa4);
/*
        Using Underscore Characters in Numeric Literals
        In Java SE 7 and later, any number of underscore characters (_) can appear anywhere between digits in a numerical literal. This feature enables you, for example. to separate groups of digits in numeric literals, which can improve the readability of your code.

                For instance, if your code contains numbers with many digits, you can use an underscore character to separate digits in groups of three, similar to how you would use a punctuation mark like a comma, or a space, as a separator.

        The following example shows other ways you can use the underscore in numeric literals:
*/

        long creditCardNumber = 1234_5678_9012_3456L;
        long socialSecurityNumber = 999_99_9999L;
        float pi = 3.14_15F;
        long hexBytes = 0xFF_EC_DE_5E;
        long hexWords = 0xCAFE_BABE;
        long maxLong = 0x7fff_ffff_ffff_ffffL;
        byte nybbles = 0b0010_0101;
        long bytes = 0b11010010_01101001_10010100_10010010;
    }
}
