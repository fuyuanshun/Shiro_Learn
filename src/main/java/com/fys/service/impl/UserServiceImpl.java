package com.fys.service.impl;

import com.fys.mapper.UserMapper;
import com.fys.pojo.User;
import com.fys.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired UserMapper userMapper;

    public String getPassword(String username){
        User user = userMapper.getUserByName(username);
        if(user == null)
            return null;
        return user.getPassword();
    }
}
