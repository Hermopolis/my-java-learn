package org.com.hermopolis.cachepool;

public class ObjectTest {
    public static void main(String[] args) {
        Object o1 = new Object();
        Object o2 = new Object();
        System.out.println(o1.hashCode());
        System.out.println(o2.hashCode());
        String s1 = new String("aaa");
        String s2 = new String("aaa");
        System.out.println(s1.hashCode());
        System.out.println(s2.hashCode());
        System.out.println(s1 == s2);           // false
        String s3 = s1.intern();
        String s4 = s2.intern();
        System.out.println(s3.hashCode());
        System.out.println(s4.hashCode());
        System.out.println(s3 == s4);           // true
        if(("a" + "b" + "c").intern()=="abc"){
            System.out.println(true);
        };
    }
}
