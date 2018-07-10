package com.example.demo.thread.singleton;

import com.example.demo.annoations.UnThreadSafe;

/**
 * Created by zhaoqicheng on 10/7/18.
 *
 * 通过懒汉模式来实现单例  线程不安全写法
 */

@UnThreadSafe
public class SingletonExample {

    private SingletonExample(){

    }

    private static SingletonExample instance = null;

    public static SingletonExample getInstance(){
        if(instance == null){
            instance = new SingletonExample();
        }
        return instance;
    }
}
