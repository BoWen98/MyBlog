package com.bowen.myblog.service.Impl;

import com.bowen.myblog.dao.UserRepository;
import com.bowen.myblog.po.User;
import com.bowen.myblog.service.UserService;
import com.bowen.myblog.utils.MD5Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @ProjectName: MyBlog
 * @Package: com.bowen.myblog.service.Impl
 * @ClassName: UserServiceImpl
 * @Author: Bowen
 * @Description: 用户实现类
 * @Date: 2019/7/26 9:30
 * @Version: 1.0.0
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Override
    public User userLogin(String username, String password) {
        User usernameAndPassword = userRepository.findByUsernameAndPassword(username, MD5Utils.code(password));
        return usernameAndPassword;
    }
}
