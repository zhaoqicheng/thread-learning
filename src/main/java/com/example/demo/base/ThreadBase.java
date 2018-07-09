package com.example.demo.base;

/**
 * Created by zhaoqicheng on 2/4/18.
 * <p>
 * 线程实现方式
 *  1.继承Thread类
 *  2.实现Runnable接口
 *       实现接口的方式比继承类的方式更灵活，也能减少程序之间的耦合度，面向接口编程也是设计模式6大原则的核心。

 实现Runnable接口比继承Thread类所具有的优势：

 1）：适合多个相同的程序代码的线程去处理同一个资源

 2）：可以避免java中的单继承的限制

 3）：增加程序的健壮性，代码可以被多个线程共享，代码和数据独立

 4）：线程池只能放入实现Runable或callable类线程，不能直接放入继承Thread的类

 */


import lombok.extern.slf4j.Slf4j;

import static java.lang.Thread.sleep;

/**
 * Runnable接口中的run()方法的返回值是void，它做的事情只是纯粹地去执行run()方法中的代码而已；
 * Callable接口中的call()方法是有返回值的，是一个泛型，和Future、FutureTask配合可以用来获取异步执行的结果。
 * 这其实是很有用的一个特性，因为多线程相比单线程更难、更复杂的一个重要原因就是因为多线程充满着未知性。
 * 某条线程是否执行了？某条线程执行了多久？某条线程执行的时候我们期望的数据是否已经赋值完毕？
 * 无法得知，我们能做的只是等待这条多线程的任务执行完毕而已。
 * 而Callable+Future/FutureTask却可以获取多线程运行的结果，可以在等待时间太长没获取到需要的数据的情况下取消该线程的任务，真的是非常有用。
 */
@Slf4j
public class ThreadBase implements Runnable {

    private String name;

    public ThreadBase(String name) {
        this.name = name;
    }

    /**
     * 只有调用了start()方法，才会表现出多线程的特性，不同线程的run()方法里面的代码交替执行。
     * 如果只是调用run()方法，那么代码还是同步执行的，必须等待一个线程的run()方法里面的代码全部执行完毕之后，
     * 另外一个线程才可以执行其run()方法里面的代码。
     */
    @Override
    public void run() {

        for (int i = 0; i < 5; i++) {
            System.out.println(name + "运行  :  " + i);
            try {
                /*  sleep(long millis): 在指定的毫秒数内让当前正在执行的线程休眠（暂停执行） */
                sleep((int) Math.random() * 10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }

    public static void main(String[] args){
        System.out.println(Thread.currentThread().getName()+"主线程运行开始!");
        new Thread(new ThreadBase("A")).start();
        new Thread(new ThreadBase("B")).start();
        new Thread(new ThreadBase("C")).start();
        System.out.println(Thread.currentThread().getName()+"主线程运行结束!");
    }
}
