package com.seatig.quanaxy.admin.entity;

import java.math.BigDecimal;
import com.baomidou.mybatisplus.annotation.TableName;
import com.xianzw.aoao.entity.common.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 用户表
 * </p>
 *
 * @author xianzw
 * @since 2020-05-08
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@TableName("t_user")
public class User extends BaseEntity {

    private static final long serialVersionUID=1L;

    /**
     * 企业id
     */
    private String companyId;

    /**
     * 名称
     */
    private String name;

    /**
     * 用户名
     */
    private String username;

    /**
     * 密码
     */
    private String password;

    /**
     * Q链密码
     */
    private String qxPassword;

    /**
     * 加密盐
     */
    private String salt;

    /**
     * 锁定
     */
    private Boolean locked;

    /**
     * 企业名称
     */
    private String companyName;

    /**
     * logoId
     */
    private String logoId;

    /**
     * 节点名称
     */
    private String nodeName;

    /**
     * 激活状态
     */
    private Integer activation;

    /**
     * 邮箱
     */
    private String email;

    /**
     * 电话
     */
    private String phone;

    /**
     * 区号
     */
    private String area;

    /**
     * 区号+手机
     */
    private String areaPhone;

    /**
     * 身份标识
     */
    private String identificationNumber;

    /**
     * 部门id
     */
    private String companyDepartmentId;

    /**
     * 直属机构
     */
    private String organizationId;

    /**
     * 所在地区国家
     */
    private String country;

    /**
     * 证件正面id
     */
    private String positiveLogoId;

    /**
     * 证件反面id
     */
    private String reverseLogoId;

    /**
     * 详细地址
     */
    private String detailedAddress;

    /**
     * 联系人
     */
    private String contacts;

    /**
     * 联系人电话
     */
    private String contactsPhone;

    /**
     * 与联系人关系
     */
    private String contactsRelation;

    /**
     * 实名状态
     */
    private Integer realNameStatus;

    /**
     * 用户类型
     */
    private Integer userType;

    /**
     * 证件类型
     */
    private Integer certificatesType;

    /**
     * 企业类型
     */
    private Integer companyType;

    /**
     * 省、州
     */
    private String state;

    /**
     * 市
     */
    private String city;

    /**
     * 联系人区号
     */
    private String contactsArea;

    private String companyKey;

    /**
     * 是否新注册公司
     */
    private Boolean newCompany;

    /**
     * 是否修改密码
     */
    private Boolean isChangePassword;

    /**
     * 邮编
     */
    private String zip;

    /**
     * 用户节点安装状态
     */
    private Boolean isNodeStatus;

    /**
     * 是否启用
     */
    private Boolean isEnabled;

    /**
     * 时区
     */
    private BigDecimal timeZone;

    /**
     * 时区名称
     */
    private String timeZoneName;


}
