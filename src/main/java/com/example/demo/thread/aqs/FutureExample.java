package com.example.demo.thread.aqs;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.*;

/**
 * Created by zhaoqicheng on 10/7/18.
 *
 * 演示Future
 */

@Slf4j
public class FutureExample {

    static class MyCallable implements Callable<String>{

        @Override
        public String call() throws Exception {
            log.info("do something in MyCallable");

            /*休眠5秒*/
            Thread.sleep(5000);
            return "Down";
        }

    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newCachedThreadPool();
        Future<String> submit = executorService.submit(new MyCallable());
        log.info("do something in main");

        Thread.sleep(1000);
        String result = submit.get();
        log.info("result:{}",result);
    }

}
