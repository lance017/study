package com.lance017.study.controller;

import com.lance017.study.advice.MyException;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author lance
 * @date Created by on 2018/10/29.下午8:02
 */

@RestController
public class ExceptionController {

    /**
     * 全局异常
     * @return
     * @throws Exception
     */
    @RequestMapping("/exception")
    public String exception() throws Exception {
        throw new Exception("全局异常捕获");
    }

    /**
     * 自定义异常
     * @throws MyException
     */
    @RequestMapping("/myException")
    public void myException() throws MyException {
        throw new MyException("10", "捕获全局自定义异常");
    }

}
