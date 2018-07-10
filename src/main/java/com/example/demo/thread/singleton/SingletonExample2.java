package com.example.demo.thread.singleton;

import com.example.demo.annoations.ThreadSafe;

/**
 * Created by zhaoqicheng on 10/7/18.
 * <p>
 * 通过饿汉模式来实现单例
 */

@ThreadSafe
public class SingletonExample2 {

    private SingletonExample2() {

    }

    private static SingletonExample2 getInstance(){
        return new SingletonExample2();
    }
}
