package com.xianzw.aoao.entity.common;

import java.io.Serializable;
import java.time.LocalDate;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.Version;

import lombok.Data;

/**
 * 实体超类
 * @Description 
 * @author xianw
 * @time 2019年2月25日下午2:05:17
 * @version v1.0
 */
@Data
public class BaseEntity implements Serializable {
	
	public static final String ID = "id";
	public static final String CREATEBY = "createby";
	public static final String CREATE_COMPANY_ID = "create_company_id";
	public static final String CREATE_COMPANY_DEPARTMENT_ID = "create_company_department_id";
	public static final String CREATE_ORGANIZATION_ID = "create_organization_id";
	public static final String CREATE_DATE = "create_date";
	public static final String CREATE_DATE_UTC = "create_date_u_t_c";
	public static final String DEL_FLAG = "del_flag";
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 4560331540586236532L;

	@TableId(type=IdType.UUID)
	private String id;//id
	
	private LocalDate createDate;//新增时间
	
	private LocalDate updateDate;//更新时间
	
	private String createby;//创建人
	
	private String createCompanyDepartmentId;//创建部门Id
	
	private String createCompanyId;//创建企业Id
	
	private String createOrganizationId;//直属机构id 个人用户：个人id，企业用户：有部门为部门id，无部门为公司id
	
	@TableLogic
	private Integer delFlag = 0;//0:有效 1:无效
	
	@Version
	private Integer version = 0;//锁
}
