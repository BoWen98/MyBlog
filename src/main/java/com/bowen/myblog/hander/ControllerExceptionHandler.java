package com.bowen.myblog.hander;

import lombok.extern.slf4j.Slf4j;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

/**
 * @ProjectName: MyBlog
 * @Package: com.bowen.myblog.hander
 * @ClassName: ControllerExceptionHandler
 * @Author: Bowen
 * @Description: 全局异常捕获
 * @Date: 2019/7/25 14:32
 * @Version: 1.0.0
 */
@ControllerAdvice
@Slf4j
public class ControllerExceptionHandler {

    @ExceptionHandler({Exception.class})
    public ModelAndView handleException(HttpServletRequest request, Exception e) throws Exception {
        log.error("Request URL : {} , Exception : {}", request.getRequestURL(), e);


        if (AnnotationUtils.findAnnotation(e.getClass(), ResponseStatus.class) != null) {
            throw e;
        }
        ModelAndView mav = new ModelAndView();
        mav.addObject("url", request.getRequestURL());
        mav.addObject("exception", e);
        mav.setViewName("error/error");
        return mav;
    }
}
