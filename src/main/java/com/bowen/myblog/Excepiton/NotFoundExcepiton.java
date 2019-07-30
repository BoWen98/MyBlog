package com.bowen.myblog.Excepiton;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @ProjectName: MyBlog
 * @Package: com.bowen.myblog
 * @ClassName: NotFoundExcepiton
 * @Author: Bowen
 * @Description: NotFoundExcepiton异常处理
 * @Date: 2019/7/25 18:54
 * @Version: 1.0.0
 */
@ResponseStatus(HttpStatus.NOT_FOUND)
public class NotFoundExcepiton extends RuntimeException {

    public NotFoundExcepiton() {
    }

    public NotFoundExcepiton(String message) {
        super(message);
    }

    public NotFoundExcepiton(String message, Throwable cause) {
        super(message, cause);
    }
}
