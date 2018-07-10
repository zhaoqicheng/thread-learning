package com.example.demo.thread.aqs;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * Created by zhaoqicheng on 10/7/18.
 * <p>
 * 演示FutureTask
 */

@Slf4j
@SuppressWarnings(value = "all")
public class FutureTaskExample {


    public static void main(String[] args) throws ExecutionException, InterruptedException {
        FutureTask<String> stringFutureTask = new FutureTask<>(new Callable<String>() {
            @Override
            public String call() throws Exception {
                log.info("do something in MyCallable");
                    /*休眠5秒*/
                Thread.sleep(5000);
                return "Down";
            }
        });

        new Thread(stringFutureTask).start();
        log.info("do something in main");
        Thread.sleep(1000);
        log.info("resule:{}", stringFutureTask.get());

    }

}
