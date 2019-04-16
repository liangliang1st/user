package com.hjl.user.service;

import com.hjl.user.dataobject.UserInfo;

/**
 * @ClassName UserService
 * @AUthor hanjialiang
 * @Date 2019-04-16 13:19
 * @Version 1.0
 * @Description
 */
public interface UserService {

    UserInfo findByOpenid(String openid);
}
