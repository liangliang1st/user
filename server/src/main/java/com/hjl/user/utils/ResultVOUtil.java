package com.hjl.user.utils;


import com.hjl.user.VO.ResultVO;
import com.hjl.user.enums.ResultEnum;

/**
 * @ClassName ResultVOUtil
 * @AUthor hanjialiang
 * @Date 2019-04-10 14:35
 * @Version 1.0
 * @Description
 */
public class ResultVOUtil {

    public static ResultVO success(Object o){
        ResultVO resultVO=new ResultVO();
        resultVO.setCode(0);
        resultVO.setMsg("成功");
        resultVO.setData(o);
        return resultVO;
    }
    public static ResultVO success(){
        ResultVO resultVO=new ResultVO();
        resultVO.setCode(0);
        resultVO.setMsg("成功");
        return resultVO;
    }

    public static ResultVO error(ResultEnum resultEnum){
        ResultVO resultVO=new ResultVO();
        resultVO.setCode(resultEnum.getCode());
        resultVO.setMsg(resultEnum.getMsg());
        return resultVO;
    }
}
