package com.zhiyou100.gym.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.ToString;

import java.io.Serializable;
import java.util.List;

@Data
@ToString
@TableName(value = "gym_user")
public class User  implements Serializable {

    @TableId(value = "us_id",type = IdType.AUTO)
    private Integer usId;
    @TableField(value = "us_account")
    private String usAccount;
    @TableField(value = "us_password")
    private String usPassword;
    @TableField(value = "us_name")
    private String usName;
    @TableField(value = "us_sex")
    private String usSex;
    @TableField(value = "us_age")
    private Integer usAge;
    @TableField(value = "us_head")
    private String usHead;
    @TableField(value = "us_label")
    private String usLabel;
    @TableField(value = "us_introduce")
    private String usIntroduce;
    @TableField(value = "us_member")
    private Integer usMember;
    @TableField(value = "us_status")
    private Integer usStatus;

    private List<Role> roles;
}
