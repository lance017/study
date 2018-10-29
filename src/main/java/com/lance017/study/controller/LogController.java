package com.lance017.study.controller;

import com.lance017.study.aop.log.Log;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author lance
 * @date Created by on 2018/10/29.下午8:45
 */

@RestController
public class LogController {

    @Log("log日志")
    @RequestMapping("/log")
    public String log(String name) {
        return name;
    }

}
