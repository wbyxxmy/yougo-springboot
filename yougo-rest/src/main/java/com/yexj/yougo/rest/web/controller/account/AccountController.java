package com.yexj.yougo.rest.web.controller.account;

import com.yexj.yougo.api.interfaces.IAccountService;
import com.yexj.yougo.rest.web.depency.vo.UserVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

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

    @RequestMapping(value = "", method = RequestMethod.GET)
    public String Login(UserVO userVO) {
        return "index.jsp";
    }
}
