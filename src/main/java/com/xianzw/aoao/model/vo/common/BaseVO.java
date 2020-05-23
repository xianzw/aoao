package com.xianzw.aoao.model.vo.common;

import java.io.Serializable;
import java.time.LocalDate;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.Version;

import lombok.Getter;
import lombok.Setter;

/**
 * 基础VO
 * @author xianzw
 * @date 2020年5月23日下午8:49:02
 */
@Getter
@Setter
public class BaseVO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 7023647084919585006L;

	//id
	@TableId(type=IdType.ASSIGN_UUID)
	private String id;
	
	//新增时间
	private LocalDate createDate;
	
	//更新时间
	private LocalDate updateDate;
	
	//创建人
	private String createby;
	
	//创建部门Id
	private String createCompanyDepartmentId;
	
	//创建企业Id
	private String createCompanyId;
	
	//直属机构id 个人用户：个人id，企业用户：有部门为部门id，无部门为公司id
	private String createOrganizationId;
	
	//0:有效 1:无效
	private Integer deleted = 0;
	
	//锁0:无锁 1:已锁定
	@Version
	private Integer version = 0;
	
}
