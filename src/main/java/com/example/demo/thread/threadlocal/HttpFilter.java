package com.example.demo.thread.threadlocal;


import lombok.extern.slf4j.Slf4j;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * Created by zhaoqicheng on 10/7/18.
 */
@Slf4j
@SuppressWarnings(value = "all")
public class HttpFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        RequestHolder.add(Thread.currentThread().getId());
        log.info("doFilter， 线程ID为：{}, 请求路径为：{}",Thread.currentThread().getId(), ((HttpServletRequest) request).getServletPath());
        chain.doFilter(request , response);
    }

    @Override
    public void destroy() {

    }
}
