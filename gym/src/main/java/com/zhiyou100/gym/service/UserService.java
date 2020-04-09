package com.zhiyou100.gym.service;

import com.zhiyou100.gym.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserService {
    public List<User> findAll();
    public User findById(Integer usId);
    public String add(User user);
    public String deleteById(Integer usId);
    public String update(User user);

    //查询 链接 role

    public User findByUAccount(String usAccount);
    public String isSuccess(User user);

    //查询单表

    public User findAccount(String usAccount);

    //调用可用 账号

    public User findByMember(Integer usMember);

    //修改账户信息

    public void updateinfo(User user);

    //当前登录的账号信息
    public User shiroUser();

    //分页多少条数据
    public Integer findUserCount();
    //分页
    public List<User> findByPage(Integer page);
}
