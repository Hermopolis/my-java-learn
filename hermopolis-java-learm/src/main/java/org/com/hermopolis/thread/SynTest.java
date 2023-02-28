package org.com.hermopolis.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SynTest {
    public synchronized void run() {
/**
 * 58、线程的 sleep()方法和 yield()方法有什么区别？（1） sleep()方法给其他线程运行机会时不考虑线程的优先级
 * ，因此会给低优先级的线程以运行的机会；yield()方法只会给相同优先级或更高优先级的线程以运行的机会；
 * （2） 线程执行 sleep()方法后转入阻塞（blocked）状态，而执行 yield()方法后转入就绪（ready）
 * 状态；（3）sleep()方法声明抛出 InterruptedException，而 yield()方法没有声明任何异常；
 * （4）sleep()方法比 yield()方法（跟操作系统 CPU 调度相关）具有更好的可移植性。
 *
 *
 * 当一个线程进入一个对象的 synchronized 方法 A 之后，其它线程是否可进入此对象的 synchronized 方法 B？
 * 不能。其它线程只能访问该对象的非同步方法，同步方法则不能进入。因为非静态方法上的 synchronized
 * 修饰符要求执行方法时要获得对象的锁，如果已经进入A 方法说明对象锁已经被取走，
 * 那么试图进入 B 方法的线程就只能在等锁池（注意不是等待池哦）中等待对象的锁。
 *

 */
        while (true) {
            try {
                Thread.sleep(1000);
                System.out.println("a");
                this.notifyAll(); //一定要先执行否则会出现大家都在待唤醒队列
                this.wait();//释放锁交出cpu执行时间，进入等待队列
                Thread.yield();//yield()方法只会给相同优先级或更高优先级的线程以运行的机会 实际上不能实现交替输出
            } catch (InterruptedException e) {
                e.printStackTrace();
            }


        }


    }

    public synchronized void run2() {
        while (true) {
            try {
                Thread.sleep(1000);//锁依然还是我的，但是我让出cpu的执行时间
                System.out.println("b");
                this.notifyAll();//唤醒其他线程
                this.wait();//进入对象的等待池（wait pool）等待被另外一个线程唤醒，否则不会执行
            } catch (InterruptedException e) {
                e.printStackTrace();
            }


        }
    }

    public void run3() {
        while (true) {
            try {
                Thread.sleep(1000);

            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println("c");

        }
    }

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(6);
        SynTest synTest = new SynTest();
        executorService.execute(() -> synTest.run2());
        executorService.execute(() -> synTest.run());

        // executorService.execute(() -> synTest.run3());
    }
}
