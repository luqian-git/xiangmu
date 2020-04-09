package com.zhiyou100.gym.mapper;

import com.zhiyou100.gym.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface UserMapper{
    //查询 所有的

    public List<User> findAllUR();

    //查看 该账号的角色权限

    public User findAccount(String usAccount);

    // 登录 账号判断

    public User findByUAccount(String usAccount);


    //所有可用 账号

    public User findByMember(Integer usMember);

    //查询 可用 员工 编号

    public User findByUMax();
    //查询 可用 会员 编号

    public User findByHMax();
    //添加 账号

    public void add(User user);

    //赋予 权限

    public void addRole(Integer usId,Integer roleId);

    //注销的账号

    public void cancellation(Integer usMember);

    //修改账户信息

    public void updateinfo(User user);

    //分页多少条数据
    public Integer findUserCount();
    //分页
    public List<User> findByPage(@Param("start") int start, @Param("size") int size);
}
