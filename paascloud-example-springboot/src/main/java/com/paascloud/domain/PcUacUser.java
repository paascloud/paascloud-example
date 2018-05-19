package com.paascloud.domain;

import lombok.Data;

import java.util.Date;

/**
 * The type Pc uac user.
 *
 * @author liuzhaoming
 */
@Data
public class PcUacUser {
    /**
     * pc_uac_user.id;ID
     */
    private Long id;

    /**
     * pc_uac_user.version;版本号
     */
    private Integer version;

    /**
     * pc_uac_user.login_name;登录名
     */
    private String loginName;

    /**
     * pc_uac_user.login_pwd;登录密码
     */
    private String loginPwd;

    /**
     * pc_uac_user.salt;盐,用于shiro加密, 字段停用
     */
    private String salt;

    /**
     * pc_uac_user.user_code;工号
     */
    private String userCode;

    /**
     * pc_uac_user.user_name;姓名
     */
    private String userName;

    /**
     * pc_uac_user.mobile_no;手机号
     */
    private String mobileNo;

    /**
     * pc_uac_user.email;邮件地址
     */
    private String email;

    /**
     * pc_uac_user.status;状态
     */
    private String status;

    /**
     * pc_uac_user.user_source;用户来源
     */
    private String userSource;

    /**
     * pc_uac_user.type;操作员类型
     */
    private String type;

    /**
     * pc_uac_user.last_login_ip;最后登录IP地址
     */
    private String lastLoginIp;

    /**
     * pc_uac_user.last_login_location;最后登录位置
     */
    private String lastLoginLocation;

    /**
     * pc_uac_user.remark;描述
     */
    private String remark;

    /**
     * pc_uac_user.last_login_time;最后登录时间
     */
    private Date lastLoginTime;

    /**
     * pc_uac_user.is_changed_pwd;是否更改过密码
     */
    private Short isChangedPwd;

    /**
     * pc_uac_user.pwd_error_count;连续输错密码次数（连续5次输错就冻结帐号）
     */
    private Short pwdErrorCount;

    /**
     * pc_uac_user.pwd_error_time;最后输错密码时间
     */
    private Date pwdErrorTime;

    /**
     * pc_uac_user.creator;创建人
     */
    private String creator;

    /**
     * pc_uac_user.creator_id;创建人ID
     */
    private Long creatorId;

    /**
     * pc_uac_user.created_time;创建时间
     */
    private Date createdTime;

    /**
     * pc_uac_user.last_operator;最近操作人
     */
    private String lastOperator;

    /**
     * pc_uac_user.last_operator_id;最后操作人ID
     */
    private Long lastOperatorId;

    /**
     * pc_uac_user.update_time;更新时间
     */
    private Date updateTime;
}