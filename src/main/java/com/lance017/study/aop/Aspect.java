package com.lance017.study.aop;


import com.lance017.study.aop.log.Log;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import com.lance017.study.util.IPUtils;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;

/**
 * @author lance
 * @date Created by on 2018/10/25.上午9:56
 */

@org.aspectj.lang.annotation.Aspect
@Component
public class Aspect {

    @Pointcut("@annotation(com.lance017.study.aop.log.Log)")
    public void logPointCut() {

    }

    @Before("logPointCut()")
    public void saveLog(JoinPoint joinPoint) {

        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        Method method = signature.getMethod();

        Log log = method.getAnnotation(Log.class);
        if (log != null) {
            // 注解上的描述
            System.out.println(log.value());
        }

        //请求的方法名
        String className = joinPoint.getTarget().getClass().getName();
        String methodName = signature.getName();
        System.out.println(className + "." + methodName + "()");

        //请求的参数
        Object[] args = joinPoint.getArgs();
        if (args != null && args.length > 0) {
            System.out.println("value: " + args[0]);
            //        String params = JSON.toJSONString(args[0]);
        }

//        获取 request, IP
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        if (request != null) {
            System.out.println(IPUtils.getIpAddr(request));
        }
    }

}
