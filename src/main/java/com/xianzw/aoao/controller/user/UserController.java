package com.xianzw.aoao.controller.user;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.xianzw.aoao.common.ServiceException;
import com.xianzw.aoao.controller.common.BaseController;
import com.xianzw.aoao.controller.common.HttpResult;
import com.xianzw.aoao.entity.user.User;
import com.xianzw.aoao.service.IUserService;

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
public class UserController extends BaseController{
	
	@Autowired
	IUserService userService;
	
	@RequestMapping("/helloWorld")
	public HttpResult<List<User>> helloWorld() {
		List<User> list = userService.list();
		return responseSuccess(list);
	}
	
	@RequestMapping("/getUserById")
	public HttpResult<User> getUserById(String id) throws ServiceException {
		User user = userService.getUserById(id);
		return responseSuccess(user);
	}
	
	
}

