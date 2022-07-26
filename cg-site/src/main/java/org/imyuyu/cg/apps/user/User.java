package org.imyuyu.cg.apps.user;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;
import org.imyuyu.cg.common.po.BasePO;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Index;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;

@Getter
@Setter
@Table(name = "cg_user", indexes = {@Index(name = "idx_user_username_unq", columnList = "username", unique = true)})
@Entity
public class User extends BasePO {
    /**
     * 账号
     */
    @Schema(description = "账号")
    @NotEmpty(message = "账号不能为空")
    @Size(max = 30, message = "账号长度不能超过30")
    @Column(name = "username", nullable = false, unique = true)
    private String username;

    /**
     * 密码
     */
    @Schema(description = "密码")
    @NotEmpty(message = "密码不能为空")
    @Size(max = 64, message = "密码长度不能超过64")
    @Column(name = "password")
    private String password;
    /**
     * 姓名
     */
    @Schema(description = "姓名")
    @NotEmpty(message = "姓名不能为空")
    @Size(max = 50, message = "姓名长度不能超过50")
    @Column(name = "name")
    private String name;

    /**
     * 内置
     */
    @Schema(description = "内置")
    @NotNull(message = "内置不能为空")
    @Column(name = "readonly")
    private Boolean readonly;

    /**
     * 邮箱
     */
    @Schema(description = "邮箱")
    @Size(max = 255, message = "邮箱长度不能超过255")
    @Column(name = "email")
    private String email;

    /**
     * 手机
     */
    @Schema(description = "手机")
    @Size(max = 20, message = "手机长度不能超过20")
    @Column(name = "mobile")
    private String mobile;

    /**
     * 状态
     */
    @Schema(description = "状态")
    @Column(name = "state")
    private Boolean state;

    /**
     * 头像
     */
    @Schema(description = "头像")
    @Size(max = 255, message = "头像长度不能超过255")
    @Column(name = "avatar")
    private String avatar;

    /**
     * 最后一次输错密码时间
     */
    @Schema(description = "最后一次输错密码时间")
    @Column(name = "password_error_last_time")
    private LocalDateTime passwordErrorLastTime;

    /**
     * 密码错误次数
     */
    @Schema(description = "密码错误次数")
    @Column(name = "password_error_num")
    private Integer passwordErrorNum;

    /**
     * 密码过期时间
     */
    @Schema(description = "密码过期时间")
    @Column(name = "password_expire_time")
    private LocalDateTime passwordExpireTime;

    /**
     * 最后登录时间
     */
    @Schema(description = "最后登录时间")
    @Column(name = "last_login_time")
    private LocalDateTime lastLoginTime;

}
