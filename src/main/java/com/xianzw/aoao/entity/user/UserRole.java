package com.xianzw.aoao.entity.user;

import com.baomidou.mybatisplus.annotation.TableName;
import com.xianzw.aoao.entity.common.BaseEntity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 用户角色关联表
 * </p>
 *
 * @author xianzw
 * @since 2020-05-08
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@TableName("t_user_role")
public class UserRole extends BaseEntity {

    private static final long serialVersionUID=1L;

    /**
     * roleId
     */
    private String roleId;

    private String userId;


}
