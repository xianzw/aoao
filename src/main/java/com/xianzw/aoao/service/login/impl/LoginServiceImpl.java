package com.xianzw.aoao.service.login.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xianzw.aoao.common.UserContext;
import com.xianzw.aoao.entity.user.User;
import com.xianzw.aoao.mapper.user.UserMapper;
import com.xianzw.aoao.model.dto.login.LoginUserDTO;
import com.xianzw.aoao.service.login.ILoginService;
import com.xianzw.aoao.service.user.IUserService;
import com.xianzw.aoao.utils.BeanUtil;

/**
 * 当前登录用户
 * @author xianzw
 * @date 2020年5月27日上午9:24:49
 *
 */
@Service
public class LoginServiceImpl extends ServiceImpl<UserMapper, User> implements ILoginService {

	@Autowired
	IUserService userServcie;
	
	/**
	 * 获取当前登录用户
	 */
	@Override
	public LoginUserDTO getLoginUser() {
		User user = userServcie.getUserByUsername(UserContext.getCurrentUser());
		LoginUserDTO loginUserDTO = new LoginUserDTO();
		BeanUtil.copyProperties(user, loginUserDTO);
		return loginUserDTO;
	}

}
