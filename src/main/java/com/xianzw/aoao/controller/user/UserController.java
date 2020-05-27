package com.xianzw.aoao.controller.user;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.xianzw.aoao.common.ServiceException;
import com.xianzw.aoao.controller.common.BaseController;
import com.xianzw.aoao.controller.common.HttpResult;
import com.xianzw.aoao.entity.user.User;
import com.xianzw.aoao.service.login.ILoginService;
import com.xianzw.aoao.service.user.IUserService;

import lombok.extern.log4j.Log4j2;

/**
 * <p>
 * 用户表 前端控制器
 * </p>
 *
 * @author xianzw
 * @since 2020-05-08
 */
@RestController
@RequestMapping("/user")
@Log4j2
public class UserController extends BaseController{
	
	@Autowired
	IUserService userService;
	
	@Autowired
	ILoginService loginService;
	
	@RequestMapping("/helloWorld")
	public HttpResult<?> helloWorld() {
		return responseSuccess(loginService.getLoginUser());
	}
	
	@RequestMapping("/getUserById")
	public HttpResult<User> getUserById(String id) throws ServiceException {
		User user = userService.getUserById(id);
		return responseSuccess(user);
	}
	
	
}

