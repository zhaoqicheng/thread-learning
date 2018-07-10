package com.example.demo.thread.threadlocal;

/**
 * Created by zhaoqicheng on 10/7/18.
 *
 * ThreadLocal
 */
@SuppressWarnings(value = "all")
public class RequestHolder {

    private final static ThreadLocal<Long> requestHolder = new ThreadLocal();

    /*向ThreadLocal中添加内容*/
    public static void add(Long id){
        requestHolder.set(id);
    }

    /*从ThreadLocal中获取内容*/
    public static Long get(){
        return requestHolder.get();
    }

    /*从ThreadLocal中移除（重要，不然可能会导致内存溢出）*/
    public static void remove(){
        requestHolder.remove();
    }
}
