package org.com.hermopolis.thread;


import java.util.concurrent.CyclicBarrier;

public class CyclicBarrierDemo {
    //指定必须有6个运动员到达才行
    private static CyclicBarrier barrier = new CyclicBarrier(6, () -> {
        System.out.println("所有运动员入场，裁判员一声令下！！！！！");
    });

public  void s(){
    main(null);
}
    public static void main(String[] args) {
        System.out.println(ClassLoader.class.getClassLoader());
        String t="ssss";
        Integer f1 = 100, f2 = 100, f3 = 150, f4 = 150;
        System.out.println(f1 == f2);
        System.out.println(f3 == f4);
        ok:

        for (int i = 0; i < 10; i++) {

            for (int j = 0; j < 10; j++) {

                http:
// System.out.println("i=" + i + ",j=" + j);

                if (j == 5) {
                    break ok;
                }

            }

        }


        int a = 2;

        int b = a << 3;
        System.out.println(b);
     /*   ExecutorService service = Executors.newFixedThreadPool(6);
        for (int i = 0; i <= 6; i++) {
            service.execute(() -> {
                try {
                    System.out.println(Thread.currentThread().getName() + " 运动员，进场");
                    barrier.await();
                    System.out.println(Thread.currentThread().getName() + "  运动员出发");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }
            });
        }
        System.out.println(barrier.getParties());*/
        ;

        return;
    }


}

