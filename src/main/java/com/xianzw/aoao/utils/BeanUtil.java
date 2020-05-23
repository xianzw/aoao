package com.xianzw.aoao.utils;

import java.time.LocalDateTime;

import com.xianzw.aoao.entity.common.BaseEntity;
import com.xianzw.aoao.entity.user.User;

/**
 * BeanUtil
 * @author xianzw
 * @date 2020年5月23日下午8:56:22
 */
public class BeanUtil extends cn.hutool.core.bean.BeanUtil{

	/**
	 * 设置实体Base信息
	 * @Description:   
	 * @param: @param obj
	 * @param: @param user      
	 * @return: void      
	 * @throws
	 */
	public static void setBean(BaseEntity obj, User user) {
	    if (ObjectUtil.isNull(obj.getId())) {
	    	//为空则新增
	    	obj.setCreateDate(LocalDateTime.now());
	    	obj.setCreateby(user.getId());
        }else {
        	//更新
        	obj.setUpdateDate(LocalDateTime.now());
        	obj.setUpdateby(user.getId());
        }
	}  
	
}
