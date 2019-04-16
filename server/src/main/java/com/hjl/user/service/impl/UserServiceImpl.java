package com.hjl.user.service.impl;

import com.hjl.user.dataobject.UserInfo;
import com.hjl.user.repository.UserRepository;
import com.hjl.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @ClassName UserServiceImpl
 * @AUthor hanjialiang
 * @Date 2019-04-16 13:19
 * @Version 1.0
 * @Description
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;
    @Override
    public UserInfo findByOpenid(String openid) {
        return userRepository.findByOpenid(openid);
    }
}
