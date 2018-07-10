package com.example.demo.thread.singleton;

import com.example.demo.annoations.ThreadSafe;
import com.example.demo.annoations.UnRecommend;

/**
 * Created by zhaoqicheng on 10/7/18.
 *
 * 通过懒汉模式来实现单例  线程不安全写法
 */

@ThreadSafe
@UnRecommend
public class SingletonExample3 {

    private SingletonExample3(){

    }

    private static SingletonExample3 instance = null;

    public static synchronized SingletonExample3 getInstance(){
        if(instance == null){
            instance = new SingletonExample3();
        }
        return instance;
    }
}
