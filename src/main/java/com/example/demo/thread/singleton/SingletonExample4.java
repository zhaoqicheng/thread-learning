package com.example.demo.thread.singleton;

import com.example.demo.annoations.UnThreadSafe;

/**
 * Created by zhaoqicheng on 10/7/18.
 * <p>
 * 通过懒汉模式来实现单例  线程不安全写法
 * <p>
 * 双重同步锁单例模式
 * <p>
 * 线程并不安全，即使采用了锁机制，由于jvm和cpu的本事优化会让jvm发生指令重排
 */

@UnThreadSafe
public class SingletonExample4 {

    private SingletonExample4() {

    }

    private static SingletonExample4 instance = null;

    public static SingletonExample4 getInstance() {
        if (instance == null) {
            synchronized (SingletonExample4.class) {
                if (instance == null) {
                    instance = new SingletonExample4();
                }
            }
        }
        return instance;
    }
}
