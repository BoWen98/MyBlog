package com.bowen.myblog.po;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @ProjectName: MyBlog
 * @Package: com.bowen.myblog.po
 * @ClassName: Tag
 * @Author: Bowen
 * @Description: 实体类
 * @Date: 2019/7/25 21:29
 * @Version: 1.0.0
 */
@Entity
@Data
@Table(name = "t_tag")
public class Tag {
    @Id
    @GeneratedValue
    private Long id;
    private String name;

    @ManyToMany(mappedBy = "tags")
    private List<Blog> blogs = new ArrayList<>();
}
