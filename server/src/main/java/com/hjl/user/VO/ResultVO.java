package com.hjl.user.VO;

import lombok.Data;

/**
 * @ClassName ResultVO
 * @AUthor hanjialiang
 * @Date 2019-04-10 13:45
 * @Version 1.0
 * @Description
 */
@Data
public class ResultVO<T> {
    private Integer code;
    private String msg;
    private T data;
}
