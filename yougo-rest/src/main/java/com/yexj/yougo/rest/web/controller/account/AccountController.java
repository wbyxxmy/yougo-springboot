package com.yexj.yougo.rest.web.controller.account;

import com.yexj.yougo.api.dto.account.UserCheckDTO;
import com.yexj.yougo.api.dto.account.UserResultDTO;
import com.yexj.yougo.api.enums.ResultCode;
import com.yexj.yougo.api.interfaces.IAccountService;
import com.yexj.yougo.api.result.Result;
import com.yexj.yougo.common.util.CopyUtil;
import com.yexj.yougo.rest.web.depency.vo.UserVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;

/**
 * Created by xinjian.ye on 2017/8/18.
 */
@RestController
@RequestMapping("/")
public class AccountController {
    public static final Logger LOGGER = LoggerFactory.getLogger(AccountController.class);
    @Resource
    private IAccountService accountService;

    @RequestMapping(value = "index", method = RequestMethod.GET)
    public ModelAndView login() {
        ModelAndView modelAndView = new ModelAndView("/index");
        return modelAndView;
    }

    @RequestMapping(value = "checkAccount", method = RequestMethod.POST)
    public ModelAndView checkAccount(@RequestBody @Validated UserVO userVO){
        UserCheckDTO userCheckDTO = new UserCheckDTO();
        CopyUtil.copy(userVO, userCheckDTO);
        Result<UserResultDTO> result = accountService.checkUser(userCheckDTO);
        //用户名或密码错误
        if(ResultCode.ACCOUNT_LOGIN_FAIL.getCode().equals(result.getCode())) {
            return new ModelAndView("/index");
        }
        //系统异常
        else if(ResultCode.FAIL.getCode().equals(result.getCode())) {
            return new ModelAndView("/err");
        }
        else {
            ModelAndView ret = new ModelAndView("welcome");
            ret.addObject(result.getData());
            return ret;
        }
    }
}
