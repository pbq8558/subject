package com.pbq.common.po;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class UserPo {

    private String userId;

    private String userName;

    private String realName;

    private String password;

    @DateTimeFormat(pattern="yyyy-MM-dd")//页面写入数据库时格式化
    @JsonFormat(pattern="yyyy-MM-dd")//数据库导出页面时json格式化
    private Date birthday;

    private String gender;

    private Integer roleId;

    private String mobile;

    private String email;

    private Integer rank;

    private Integer deptCode;

    private Integer failLoginTimes;

    private String enabled;

    private String isLocked;

    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")//页面写入数据库时格式化
    @JsonFormat(timezone = "GMT+8",pattern="yyyy-MM-dd HH:mm:ss")//数据库导出页面时json格式化
    private Date lastLoginTime;

    private Integer insertBy;

    private Integer updateBy;

    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")//页面写入数据库时格式化
    @JsonFormat(timezone = "GMT+8",pattern="yyyy-MM-dd HH:mm:ss")//数据库导出页面时json格式化
    private Date insertTime;

    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")//页面写入数据库时格式化
    @JsonFormat(timezone = "GMT+8",pattern="yyyy-MM-dd HH:mm:ss")//数据库导出页面时json格式化
    private Date updateTime;

    private String column1;

    private String column2;

    private String column3;

    private String column4;

    private String column5;
}
