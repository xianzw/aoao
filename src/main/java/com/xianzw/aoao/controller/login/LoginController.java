package com.xianzw.aoao.controller.login;

import java.io.Serializable;

import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.xianzw.aoao.controller.common.BaseController;
import com.xianzw.aoao.controller.common.HttpResult;
import com.xianzw.aoao.entity.user.User;
import com.xianzw.aoao.model.vo.login.UserVO;
import com.xianzw.aoao.service.IUserService;

/**
 * 登录
 * @author xianz
 *
 */
@RestController
public class LoginController extends BaseController{

	@Autowired
	IUserService userService;
	
	/**
     * 用户登录
     * @param username 用户名
     * @param password 用户密码
     * @return
     */
    @RequestMapping(value = "/login")
    public HttpResult login(@RequestBody UserVO userVO, HttpServletRequest request){

        //TODO 验证码验证
        UsernamePasswordToken token = new UsernamePasswordToken(userVO.getUsername(), userVO.getPassword());
        SecurityUtils.getSubject().login(token);


        //设置session时间
        SecurityUtils.getSubject().getSession().setTimeout(1000*60*30);

        //token信息
        Subject subject = SecurityUtils.getSubject();
        Serializable tokenId = subject.getSession().getId();
        return loginSuccess(tokenId);
    }
	
    /**
     * 用户注册
     * @param userVO
     * @return
     */
    @RequestMapping("/signup")
    public HttpResult<User> signup(@RequestBody UserVO userVO) {
    	User user = userService.signup(UserVO.convert(userVO));
		return responseSuccess(user);
    }
    
}
