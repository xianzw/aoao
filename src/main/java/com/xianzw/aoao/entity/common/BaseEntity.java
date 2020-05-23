package com.xianzw.aoao.entity.common;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
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
	public static final String CREATE_DATE = "create_date";
	public static final String UPDATE_DATE = "update_date";
	public static final String DELETED = "deleted";
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 4560331540586236532L;

	//id
	@TableId(type=IdType.ASSIGN_UUID)
	private String id;
	
	//新增时间
	private LocalDateTime createDate;
	
	//更新时间
	private LocalDateTime updateDate;
	
	//创建人
	private String createby;
	
	//更新人
	private String updateby;
	
	//0:有效 1:无效
	private Integer deleted = 0;
	
	//锁0:无锁 1:已锁定
	@Version
	private Integer version = 0;
}
