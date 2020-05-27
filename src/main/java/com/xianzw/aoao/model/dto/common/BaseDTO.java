package com.xianzw.aoao.model.dto.common;

import java.io.Serializable;
import java.time.LocalDateTime;

import com.baomidou.mybatisplus.annotation.Version;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * 基础DTO
 * @author xianzw
 * @date 2020年5月23日下午8:49:02
 */
@Data
@Accessors(chain = true)
public class BaseDTO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 7023647084919585006L;

	//id
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
