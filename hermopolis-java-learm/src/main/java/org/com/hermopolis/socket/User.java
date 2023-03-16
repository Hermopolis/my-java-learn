package org.com.hermopolis.socket;

import lombok.Data;

import java.io.PrintWriter;

@Data
public class User {
    private String uid;
    private PrintWriter out;
   static  {


    }

    public User(String uid, PrintWriter out) {
        this.uid = uid;
        this.out = out;
    }

    {


    }
    public static void main(String[] args) {
        String s = new String("sss").intern();
        String s1 = new String("ss").intern();
        s1.intern();
        System.out.println(s == s1);
        String s3 = s1.intern();
        String s4 = s.intern();
        System.out.println(s3 == s4);
        System.out.println(s3.hashCode());
        System.out.println(s.hashCode());
        System.out.println(s1.hashCode());
    }
}
