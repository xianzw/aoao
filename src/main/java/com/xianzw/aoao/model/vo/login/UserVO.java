package com.xianzw.aoao.model.vo.login;

import com.xianzw.aoao.entity.user.User;
import com.xianzw.aoao.model.vo.common.BaseVO;
import com.xianzw.aoao.utils.BeanUtil;

import lombok.Getter;
import lombok.Setter;

/**
 * 用户VO
 * @author xianzw
 * @date 2020年5月23日下午8:50:30
 */
@Getter
@Setter
public class UserVO extends BaseVO{

	/**
	 * 
	 */
	private static final long serialVersionUID = -1860235130338563355L;

	/**
     * 名称
     */
    private String name;

    /**
     * 用户名
     */
    private String username;

    /**
     * 密码
     */
    private String password;

    /**
     * BaseVO转换user
     * @param userVO
     * @return
     */
	public static User convert(UserVO userVO) {
		User user = new User();
		BeanUtil.copyProperties(userVO, user);
		return user;
	}
}
