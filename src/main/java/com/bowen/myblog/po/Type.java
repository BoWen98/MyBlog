package com.bowen.myblog.po;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.ArrayList;
import java.util.List;

/**
 * @ProjectName: MyBlog
 * @Package: com.bowen.myblog.po
 * @ClassName: Type
 * @Author: Bowen
 * @Description: 分类实体类
 * @Date: 2019/7/25 21:25
 * @Version: 1.0.0
 */
@Entity
@Data
@Table(name = "t_type")
public class Type {

    @Id
    @GeneratedValue
    private Long id;

    @NotBlank(message = "分类名称不能为空")
    private String name;

    @OneToMany(mappedBy = "type")
    private List<Blog> blogs = new ArrayList<>();
}
