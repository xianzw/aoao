package com.xianzw.aoao.controller.user;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
@RequestMapping("/user/user")
public class UserController {
	
	@Autowired
	IUserService userService;
	
	@RequestMapping("helloWorld")
	public String helloWorld() {
		List<User> list = userService.list();
		return list.toString();
	}
	
	
}

