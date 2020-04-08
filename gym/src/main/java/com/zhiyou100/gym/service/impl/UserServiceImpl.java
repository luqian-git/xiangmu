package com.zhiyou100.gym.service.impl;

import com.zhiyou100.gym.mapper.UserMapper;
import com.zhiyou100.gym.pojo.User;
import com.zhiyou100.gym.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service(value = "userService")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public List<User> findAll() {
        return userMapper.findAllUR();
    }


    @Override
    public String add(User user) {
        if (user == null || user.getUsAccount().length() <= 0) {
            return "注册账号不能为空";
        }
        if (user.getUsPassword().length() <= 0) {
            return "注册密码不能为空";
        }
        User user2 = userMapper.findByUAccount(user.getUsAccount());

        if (user2 != null) {
            return "注册账号已被使用";
        }
        //默认账号状态 1 为 正常 0 为
        user.setUsStatus(1);
                ;
        return "注册成功";
    }

    @Override
    public String deleteById(Integer id) {

        return "删除失败";
    }

    @Override
    public User findById(Integer id) {

        return null;
    }

    @Override
    public String update(User user) {

        return "修改失败";
    }

    @Override
    public User findByUAccount(String account) {
        return userMapper.findByUAccount(account);
    }

    @Override
    public String isSuccess(User user) {
        if (user == null || user.getUsAccount().length() <= 0) {
            return "账号不能为空";
        }
        if (user.getUsPassword().length() <= 0) {
            return "密码不能为空";
        }
        User user2 = userMapper.findByUAccount(user.getUsAccount());
        if (user2 == null) {
            return "账号不正确";
        }
        if (!user.getUsPassword().equals(user2.getUsPassword())) {
            return "密码不正确";
        }
        return "登录成功";
    }

    @Override
    public User findAccount(String usAccount) {
        return userMapper.findAccount(usAccount);
    }

    @Override
    public User findByMember(Integer usMember) {
        return userMapper.findByMember(usMember);
    }

    @Override
    public void updateinfo(User user) {
        userMapper.updateinfo(user);
    }
    @Override
    public User shiroUser() {
        return (User) SecurityUtils.getSubject().getPrincipal();
    }
}
