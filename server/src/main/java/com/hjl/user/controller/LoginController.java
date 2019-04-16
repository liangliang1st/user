package com.hjl.user.controller;

import com.hjl.user.VO.ResultVO;
import com.hjl.user.constant.CookieConstant;
import com.hjl.user.constant.RedisConstant;
import com.hjl.user.dataobject.UserInfo;
import com.hjl.user.enums.ResultEnum;
import com.hjl.user.enums.RoleEnum;
import com.hjl.user.service.UserService;
import com.hjl.user.utils.CookieUtil;
import com.hjl.user.utils.ResultVOUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

/**
 * @ClassName LoginController
 * @AUthor hanjialiang
 * @Date 2019-04-16 13:21
 * @Version 1.0
 * @Description
 */
@RestController
@RequestMapping("/login")
public class LoginController {
    @Autowired
    private UserService userService;
    @Autowired
    private StringRedisTemplate redisTemplate;

    /**
     * 买家登录
     * @param openid
     * @param response
     * @return
     */
    @GetMapping("/buyer")
    private ResultVO buyer(@RequestParam("openid") String openid, HttpServletResponse response){
        //1、opinid 和数据库里的数据匹配
        UserInfo userInfo = userService.findByOpenid(openid);
        if(userInfo==null){
            return ResultVOUtil.error(ResultEnum.LOGIN_FAIL);
        }
        //2、判断角色
        if(RoleEnum.BUYER.getCode()!=userInfo.getRole()){
            return ResultVOUtil.error(ResultEnum.ROLE_ERROR);
        }
        //3、cookie里设置opinid=abc
        CookieUtil.set(response, CookieConstant.OPENID,openid,CookieConstant.expire);
        return ResultVOUtil.success();
    }

    @GetMapping("/seller")
    private ResultVO seller (@RequestParam("openid") String openid, HttpServletRequest request,HttpServletResponse response){
        //0、判断是否已登陆
        Cookie cookie = CookieUtil.get(request, CookieConstant.TOKEN);
        if(cookie!=null &&
                !StringUtils.isEmpty(redisTemplate.opsForValue().get(String.format(RedisConstant.TOKEN_TEMPLATE,cookie.getValue())))
                ){
            return ResultVOUtil.success();
        }

        //1、opinid 和数据库里的数据匹配
        UserInfo userInfo = userService.findByOpenid(openid);
        if(userInfo==null){
            return ResultVOUtil.error(ResultEnum.LOGIN_FAIL);
        }
        //2、判断角色
        if(RoleEnum.SELLER.getCode()!=userInfo.getRole()){
            return ResultVOUtil.error(ResultEnum.ROLE_ERROR);
        }
        //2.5、存入redis key=uuid，value=xyz
        String token= UUID.randomUUID().toString();
        Integer expire=CookieConstant.expire;
        redisTemplate.opsForValue().set(String.format(RedisConstant.TOKEN_TEMPLATE,token),
                openid,expire, TimeUnit.SECONDS);
        //3、cookie里设置opinid=abc
        CookieUtil.set(response, CookieConstant.TOKEN,token,CookieConstant.expire);
        return ResultVOUtil.success();
    }
}
