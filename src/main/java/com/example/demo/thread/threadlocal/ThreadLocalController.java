package com.example.demo.thread.threadlocal;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by zhaoqicheng on 10/7/18.
 */
@RestController
@RequestMapping(value = "threadlocal")
@SuppressWarnings(value = "all")
public class ThreadLocalController {


    @RequestMapping(value = "test")
    @ResponseBody
    public Long test(){
        return RequestHolder.get();
    }
}
