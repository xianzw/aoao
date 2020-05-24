package com.xianzw.aoao.config.shiro;

import com.alibaba.fastjson.JSONObject;
import com.xianzw.aoao.controller.common.HttpResult;
import com.xianzw.aoao.controller.common.ResultCode;

import org.apache.shiro.web.filter.authc.FormAuthenticationFilter;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;

public class CORSAuthenticationFilter extends FormAuthenticationFilter {

	
	 /**
     * 直接过滤可以访问的请求类型
     */
    private static final String REQUET_TYPE = "OPTIONS";


    public CORSAuthenticationFilter() {
        super();
    }


    @Override
    public boolean isAccessAllowed(ServletRequest request, ServletResponse response, Object mappedValue) {
        if (((HttpServletRequest) request).getMethod().toUpperCase().equals(REQUET_TYPE)) {
            return true;
        }
        return super.isAccessAllowed(request, response, mappedValue);
    }


    @Override
    protected boolean onAccessDenied(ServletRequest request, ServletResponse response) throws Exception {
        HttpServletResponse res = (HttpServletResponse)response;
        res.setHeader("Access-Control-Allow-Origin", "*");
        res.setStatus(HttpServletResponse.SC_OK);
        res.setCharacterEncoding("UTF-8");
        PrintWriter writer = res.getWriter();
        
        HttpResult httpResult = new HttpResult();
        httpResult.setResultCode(ResultCode.RESULT_CODE_NOT_LOGGED_IN);
        httpResult.setResultMessage("请先登录系统!");
        writer.write(JSONObject.toJSONString(httpResult));
        writer.close();
        return false;
    }
	
}
