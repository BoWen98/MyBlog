package com.bowen.myblog.vo;

import lombok.Data;

/**
 * @ProjectName: MyBlog
 * @Package: com.bowen.myblog.vo
 * @ClassName: BlogQuery
 * @Author: Bowen
 * @Description: 查询封装实体类
 * @Date: 2019/7/27 11:11
 * @Version: 1.0.0
 */
@Data
public class BlogQuery {
    private String title;
    private Long typeId;
    private boolean recommend;
}
