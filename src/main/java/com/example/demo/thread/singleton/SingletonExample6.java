package com.example.demo.thread.singleton;

import com.example.demo.annoations.Recommend;
import com.example.demo.annoations.ThreadSafe;

/**
 * Created by zhaoqicheng on 10/7/18.
 * <p>
 * 通过枚举的方式来实现单例模式
 */

@ThreadSafe
@Recommend
@SuppressWarnings(value = "all")
public class SingletonExample6 {

    private SingletonExample6() {

    }

    public static SingletonExample6 getInstance() {
        return Singleton.INSTANCE.getInstance();
    }

    private enum Singleton {
        INSTANCE;

        private SingletonExample6 singleton;

        /*jvm 保证这个方法只会调用一次*/
        Singleton() {
            singleton = new SingletonExample6();
        }

        public SingletonExample6 getInstance() {
            return singleton;
        }
    }
}
