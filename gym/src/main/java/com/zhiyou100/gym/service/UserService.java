package com.zhiyou100.gym.service;

import com.zhiyou100.gym.pojo.User;

import java.util.List;

public interface UserService {
    public List<User> findAll();
    public User findById(Integer usId);
    public String add(User user);
    public String deleteById(Integer usId);
    public String update(User user);

    public User findByAccount(String account);
    public String isSuccess(User user);
    public User findByUid(Integer usId);

    //调用可用 账号

    public User findByMember(Integer usMember);
}
