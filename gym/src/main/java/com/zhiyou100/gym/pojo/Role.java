package com.zhiyou100.gym.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.ToString;

import java.io.Serializable;

@Data
@ToString
@TableName(value = "gym_role")
public class Role implements Serializable {

    @TableId(value = "ro_id",type = IdType.AUTO)
    private Integer roId;
    @TableField(value = "ro_name")
    private String roName;
    @TableField(value = "ro_desc")
    private String roDesc;
}
