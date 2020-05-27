package com.xianzw.aoao.service.login;

import com.baomidou.mybatisplus.extension.service.IService;
import com.xianzw.aoao.entity.user.User;
import com.xianzw.aoao.model.dto.login.LoginUserDTO;

public interface ILoginService extends IService<User>{

	/**
	 * 获取当前登录游湖
	 * @return
	 */
	LoginUserDTO getLoginUser();
	
}
