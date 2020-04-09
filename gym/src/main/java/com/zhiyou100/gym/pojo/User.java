package com.zhiyou100.gym.pojo;


import lombok.Data;
import lombok.ToString;
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
