package com.xianzw.aoao.controller.login;

import java.io.Serializable;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.xianzw.aoao.config.jwt.JwtUtil;
import com.xianzw.aoao.config.redis.JedisUtil;
import com.xianzw.aoao.controller.common.BaseController;
import com.xianzw.aoao.controller.common.HttpResult;
import com.xianzw.aoao.entity.user.User;
import com.xianzw.aoao.model.constant.Constant;
import com.xianzw.aoao.model.vo.login.UserVO;
import com.xianzw.aoao.service.IUserService;

/**
 * 登录
 * @author xianz
 *
 */
@RestController
@PropertySource("classpath:config.properties")
public class LoginController extends BaseController{
	
    /**
     * RefreshToken过期时间
     */
    @Value("${refreshTokenExpireTime}")
    private String refreshTokenExpireTime;

	@Autowired
	IUserService userService;
	
	/**
     * 用户登录
     * @param username 用户名
     * @param password 用户密码
     * @return
     */
    @RequestMapping(value = "/login")
    public HttpResult login(@RequestBody UserVO userVO, HttpServletRequest request,HttpServletResponse response){

        //TODO 验证码验证
        UsernamePasswordToken token = new UsernamePasswordToken(userVO.getUsername(), userVO.getPassword());
        SecurityUtils.getSubject().login(token);


        //设置session时间
        SecurityUtils.getSubject().getSession().setTimeout(1000*60*30);

        String currentTimeMillis = String.valueOf(System.currentTimeMillis());
        JedisUtil.setObject(Constant.PREFIX_SHIRO_REFRESH_TOKEN + userVO.getUsername(), currentTimeMillis, Integer.parseInt(refreshTokenExpireTime));
        String tokenId = JwtUtil.sign(userVO.getUsername(), currentTimeMillis);
        response.setHeader("Authorization", tokenId);
        response.setHeader("Access-Control-Expose-Headers", "Authorization");
        
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
