package com.example.demo.thread.example;

import com.example.demo.annoations.UnThreadSafe;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * Created by zhaoqicheng on 9/7/18.
 *
 */
@Slf4j
@UnThreadSafe
@SuppressWarnings(value = "all")
public class ConcurrencyTest3 {

    /*模拟并发的数量*/
    public static int clientTotal = 5000;


    /*模拟线程数量*/
    public static int threadTotal = 200;


    /*计数器*/
    public static volatile int count = 0;


    public static void main(String[] args) throws InterruptedException {
        /*线程池*/
        ExecutorService executorService = Executors.newCachedThreadPool();

        /**
         * Semaphore是计数信号量。Semaphore管理一系列许可证。每个acquire方法阻塞，直到有一个许可证可以获得然后拿走一个许可证；
         * 每个release方法增加一个许可证，这可能会释放一个阻塞的acquire方法。
         * 然而，其实并没有实际的许可证这个对象，Semaphore只是维持了一个可获得许可证的数量。
         */
        final Semaphore semaphore = new Semaphore(threadTotal);

        /**
         * CountDownLatch是一个同步工具类，用来协调多个线程之间的同步，或者说起到线程之间的通信（而不是用作互斥的作用）
         */
        final CountDownLatch countDownLatch = new CountDownLatch(clientTotal);
        for (int i = 0; i < clientTotal; i++) {
            executorService.execute(() -> {
                try {
                    semaphore.acquire();
                    add();
                    semaphore.release();
                } catch (InterruptedException e) {
                    log.error("exception:", e);
                }
                countDownLatch.countDown();
            });

        }

        countDownLatch.await();
        executorService.shutdown();
        log.info("count:{}", count);
    }

    private synchronized static void add() {
        count++;
    }
}
