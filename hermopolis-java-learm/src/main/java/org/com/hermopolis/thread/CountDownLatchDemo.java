package org.com.hermopolis.thread;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CountDownLatchDemo {
    /**
     * 为了能够理解 CountDownLatch，举一个很通俗的例子，运动员进行跑步比赛时，假设有 6 个运动员参与比赛，
     * 裁判员在终点会为这 6 个运动员分别计时，可以想象没当一个运动员到达终点的时候，对于裁判员来说就少了一个计时任务。
     * 直到所有运动员都到达终点了，裁判员的任务也才完成。这 6 个运动员可以类比成 6 个线程，
     * 当线程调用 CountDownLatch.countDown 方法时就会对计数器的值减一，直到计数器的值为 0 的时候，
     * 裁判员（调用 await 方法的线程）才能继续往下执行。
     *
     * 作者：你听___
     * 链接：https://juejin.cn/post/6844903602461343752
     * 来源：稀土掘金
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    private static CountDownLatch startSignal = new CountDownLatch(1);
    //用来表示裁判员需要维护的是6个运动员
    private static CountDownLatch endSignal = new CountDownLatch(6);


    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(6);
        for (int i = 0; i < 6; i++) {
            executorService.execute(() -> {
                try {
                    System.out.println(Thread.currentThread().getName() + " 运动员等待裁判员响哨！！！");
                    startSignal.await();
                    System.out.println(Thread.currentThread().getName() + "正在全力冲刺");
                    endSignal.countDown();
                    System.out.println(Thread.currentThread().getName() + "  到达终点");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }
        System.out.println("裁判员发号施令啦！！！");
        startSignal.countDown();
        endSignal.await();
        System.out.println("所有运动员到达终点，比赛结束！");
        executorService.shutdown();
    }
}


