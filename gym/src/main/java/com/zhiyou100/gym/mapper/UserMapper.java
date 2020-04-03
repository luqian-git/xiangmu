package com.zhiyou100.gym.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zhiyou100.gym.pojo.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserMapper{
    //查询 所有的

    public List<User> findAllUR();

    //查看 该账号的角色权限

    public User findByUId(Integer usId);

    // 登录 账号判断

    public User findByUAccount(String usAccount);


    //所有可用 账号

    public User findByMember(Integer usMember);
}
