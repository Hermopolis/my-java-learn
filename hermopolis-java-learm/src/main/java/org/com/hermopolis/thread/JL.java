package org.com.hermopolis.thread;

public class JL {


    public static void main(String[] args) {

        ok:
        for (int i = 0; i < 100; i++) {
            if (i > 90) {
                break ok;
            }
            okj:
            for (int j = 0; j < 200; j++) {
                if (j>20){
                    break okj;
                }
            }
        }
        System.out.println(1);
    }
}
