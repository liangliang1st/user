package com.hjl.user.repository;

import com.hjl.user.dataobject.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @ClassName UserRepository
 * @AUthor hanjialiang
 * @Date 2019-04-16 13:17
 * @Version 1.0
 * @Description
 */
public interface UserRepository extends JpaRepository<UserInfo,String> {

    UserInfo findByOpenid(String openid);
}
