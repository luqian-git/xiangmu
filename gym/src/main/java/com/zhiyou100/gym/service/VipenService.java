package com.zhiyou100.gym.service;

import com.zhiyou100.gym.pojo.Vipen;

import java.util.List;

public interface VipenService {

    public List<Vipen> findAll(Integer q);
    public void add(Integer vipenUserId);
    public void update(Integer vipenId);

}
