package com.hjl.user.dataobject;

import lombok.Data;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * @ClassName UserInfo
 * @AUthor hanjialiang
 * @Date 2019-04-16 13:13
 * @Version 1.0
 * @Description
 */
@Data
@Entity
public class UserInfo {
    @Id
    private String id;
    private String username;
    private String password;
    private String openid;
    private Integer role;
  /*  private Timestamp createTime;
    private Timestamp updateTime;*/
}
