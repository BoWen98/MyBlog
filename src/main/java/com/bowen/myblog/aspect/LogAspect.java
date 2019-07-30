package com.bowen.myblog.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;

/**
 * @ProjectName: MyBlog
 * @Package: com.bowen.myblog.aspect
 * @ClassName: LogAspect
 * @Author: Bowen
 * @Description: 记录日志
 * @Date: 2019/7/25 20:07
 * @Version: 1.0.0
 */
@Slf4j
@Aspect
@Component
public class LogAspect {

    /**
     * 定义切面,拦截的类
     */
    @Pointcut("execution(* com.bowen.myblog.web.*.*(..))")
    public void log() {
    }

    @Before("log()")
    public void doBefore(JoinPoint joinPoint) {
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        //获取路径
        String url = request.getRequestURL().toString();
        //获取IP地址
        String remoteAddr = request.getRemoteAddr();
        //获取类名,方法名
        String classMethod = joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName();
        //获取参数
        Object[] args = joinPoint.getArgs();
        ReqeustLog reqeustLog = new ReqeustLog(url, remoteAddr, classMethod, args);
        log.info("Rquest  ----- {}",reqeustLog);
    }


    @After("log()")
    public void doAfter() {
        //logger.info("---------- After----------");
    }

    @AfterReturning(returning = "result", pointcut = "log()")
    public void doAtfertRturning(Object result) {
        log.info("Result : {}" + result);
    }

    private class ReqeustLog {
        private String url;
        private String ip;
        private String classMethod;
        private Object[] args;

        public ReqeustLog(String url, String ip, String classMethod, Object[] args) {
            this.url = url;
            this.ip = ip;
            this.classMethod = classMethod;
            this.args = args;
        }

        @Override
        public String toString() {
            return "ReqeustLog{" +
                    "url='" + url + '\'' +
                    ", ip='" + ip + '\'' +
                    ", classMethod='" + classMethod + '\'' +
                    ", args=" + Arrays.toString(args) +
                    '}';
        }
    }
}
