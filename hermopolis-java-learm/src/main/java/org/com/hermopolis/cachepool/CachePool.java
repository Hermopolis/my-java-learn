package org.com.hermopolis.cachepool;

public class CachePool {
    public static void main(String[] args) {
        Integer x = new Integer(123);
        Integer y = new Integer(123);
        System.out.println(x == y);    // false
        Integer z = Integer.valueOf(123);
        Integer k = Integer.valueOf(123);
        System.out.println(z == k);
        char a='\u0001';
        System.out.println(a);
        // The number 26, in decimal
        int decVal = 26;
//  The number 26, in hexadecimal
        int hexVal = 0x1a;
// The number 26, in binary
        int binVal = 0b11010;
        //转成2进制
        System.out.println(Integer.toBinaryString(-1));
        byte sb=0b1111;
        System.out.println(sb);
        short ss=0b1111111_11111111;
        System.out.println(ss);
        int st=0b1111111_11111111_11111111_11111111;
        System.out.println(st);
        long smin= 0x8000000000000000L;
        long sMax= 0x7fffffffffffffffL;
        System.out.println(smin);
        System.out.println(sMax);

        //111111111111111111111111111111111111111111111111111111111111111
        System.out.println(Long.toBinaryString(Long.MAX_VALUE));
        //
        System.out.println(Long.MAX_VALUE+1);//-9223372036854775808

        //1000000000000000000000000000000000000000000000000000000000000000
        System.out.println(Long.toBinaryString(Long.MAX_VALUE+1));
        //1000000000000000000000000000000000000000000000000000000000000000
        System.out.println(Long.toBinaryString(Long.MIN_VALUE));
        System.out.println((Long.MAX_VALUE+1)==Long.MIN_VALUE);//true

        Integer aa1=127;
        Integer aa2=127;
        System.out.println(aa1==aa2);
        Integer aa3=128;
        Integer aa4=128;
        System.out.println(aa3==aa4);
    }
}
