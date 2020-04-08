package com.zhiyou100.gym.service.impl;

import com.zhiyou100.gym.mapper.RoleMapper;
import com.zhiyou100.gym.pojo.Role;
import com.zhiyou100.gym.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
@Transactional
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleMapper roleMapper;

    @Override
    public List<Role> findAll() {
        return roleMapper.findAll();
    }

    @Override
    public List<Role> findStaff() {
        return roleMapper.findStaff();
    }

    @Override
    public Role findById(Integer roId) {
        return roleMapper.findById(roId);
    }

    @Override
    public void add(Role role) {
        roleMapper.add(role);
    }
}
