package com.zhiyou100.gym.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zhiyou100.gym.pojo.Role;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface RoleMapper{

    public List<Role> findAll();

    public List<Role> findStaff();

    public Role findById(Integer roId);
    public void add(Role role);
    public void deleteById(Integer roId);
    public void update(Role role);
}
