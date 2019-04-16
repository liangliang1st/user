package com.hjl.user.enums;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum RoleEnum {
    BUYER(1,"买家"),
    SELLER(2,"卖家");

    private Integer code;
    private String message;
}
