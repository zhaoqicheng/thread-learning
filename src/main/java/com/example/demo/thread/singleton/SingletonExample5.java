package com.example.demo.thread.singleton;

import com.example.demo.annoations.ThreadSafe;

/**
 * Created by zhaoqicheng on 10/7/18.
 * <p>
 * 通过懒汉模式来实现单例  线程不安全写法
 * <p>
 * 双重同步锁单例模式
 * <p>
 * 线程并不安全，即使采用了锁机制，由于jvm和cpu的本事优化会让jvm发生指令重排
 * 限制其不让发生指令重排
 *
 * volatile + 双重同步锁
 */

@ThreadSafe
public class SingletonExample5 {

    private SingletonExample5() {

    }

    // volatile
    private volatile static SingletonExample5 instance = null;

    public static SingletonExample5 getInstance() {
        if (instance == null) {
            synchronized (SingletonExample5.class) {
                if (instance == null) {
                    instance = new SingletonExample5();
                }
            }
        }
        return instance;
    }
}
