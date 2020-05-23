package com.xianzw.aoao.entity.user;

import com.baomidou.mybatisplus.annotation.TableName;
import com.xianzw.aoao.entity.common.BaseEntity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 角色表
 * </p>
 *
 * @author xianzw
 * @since 2020-05-08
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@TableName("u_role")
public class Role extends BaseEntity {

    private static final long serialVersionUID=1L;

    /**
     * 角色名称
     */
    private String roleName;

    /**
     * 排序
     */
    private Integer sort;

    /**
     * 是否启用
     */
    private Integer enable = 0;

}
