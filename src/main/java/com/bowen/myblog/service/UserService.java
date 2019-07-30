package com.bowen.myblog.service;

import com.bowen.myblog.po.User;

public interface UserService {

    User userLogin(String username, String password);
}
