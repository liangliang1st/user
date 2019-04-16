package com.hjl.user.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ResultEnum {

    SUCCESS(0,"成功"),
    LOGIN_FAIL(1,"登录失败"),
    ROLE_ERROR(2,"权限有误"),
    ;

    private Integer code;
    private String msg;


}
