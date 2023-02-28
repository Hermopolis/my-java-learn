package org.com.hermopolis.thread;

public class Test {
    static  class A {
        static {
            System.out.print("1");
        }
        public A() {
            System.out.print("2");
        }
    }
    static class B extends A{
        static {
            System.out.print("a");
        }
        public B() {
           
            System.out.print("b");
        }
    }
    public static void main(String[] args) {
        A ab = new B();
      //  ab = new B();

        ///  1a2b2b
    }


}
