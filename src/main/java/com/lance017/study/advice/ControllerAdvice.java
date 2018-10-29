package com.lance017.study.advice;

import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

/**
 * @author lance
 * @date Created by on 2018/10/29.下午8:22
 */

@org.springframework.web.bind.annotation.ControllerAdvice
public class ControllerAdvice {

    /**
     * 初始化数据绑定器
     * @param webDataBinder
     */
    @InitBinder
    public void initBinder(WebDataBinder webDataBinder) {

    }

    /**
     * 全局捕获异常
     * @param e
     * @return
     */
    @ResponseBody
    @ExceptionHandler(value = {Exception.class})
    public Map<String, Object> errorHandler(Exception e) {
        e.printStackTrace();
        Map map = new HashMap();
        map.put("code", 100);
        map.put("msg", e.getMessage());
        return map;
    }

    /**
     * 全局捕获自定义异常
     * @param e
     * @return
     */
    @ResponseBody
    @ExceptionHandler(value = {MyException.class})
    public Map<String, Object> errorHandler(MyException e) {
        e.printStackTrace();
        Map map = new HashMap();
        map.put("code", e.getCode());
        map.put("msg", e.getMsg());
        return map;
    }


}
