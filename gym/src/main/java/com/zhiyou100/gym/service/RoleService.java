package com.zhiyou100.gym.service;

import com.zhiyou100.gym.pojo.Role;

import java.util.List;

public interface RoleService {
    public List<Role> findAll();
    public List<Role> findStaff();
    public Role findById(Integer roId);
    public void add(Role role);
}
