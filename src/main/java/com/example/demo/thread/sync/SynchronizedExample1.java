package com.example.demo.thread.sync;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by zhaoqicheng on 9/7/18.
 */
@Slf4j
@SuppressWarnings(value = "all")
public class SynchronizedExample1 {

    /*synchronized 修饰代码块*/
    public void test1(int j) {
        synchronized (this) {
            for (int i = 0; i < 10; i++) {
                log.info("{}:test1:{}",j , i);
            }
        }
    }

    /*synchronized 修饰方法*/
    public synchronized void test2() {
        for (int i = 0; i < 10; i++) {
            log.info("test2:{}", i);
        }
    }

    public static void main(String[] args) {
        SynchronizedExample1 example1 = new SynchronizedExample1();
        SynchronizedExample1 example2 = new SynchronizedExample1();
        ExecutorService executorService = Executors.newCachedThreadPool();

        executorService.execute(()->{
            example1.test1(1);
        });

        executorService.execute(()->{
            example2.test1(2);
        });
    }
}
