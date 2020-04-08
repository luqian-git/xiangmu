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
public class User {

    private Integer usId;

    private String usAccount;

    private String usPassword;

    private String usName;

    private String usSex;

    private Integer usAge;

    private String usHead;

    private String usLabel;

    private String usIntroduce;

    private Integer usMember;

    private Integer usStatus;

    private List<Role> roles;
}
