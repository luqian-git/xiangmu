package com.zhiyou100.gym.service.impl;

import com.zhiyou100.gym.mapper.TopMapper;
import com.zhiyou100.gym.pojo.Top;
import com.zhiyou100.gym.service.TopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TopServiceImpl implements TopService {

    @Autowired
    private TopMapper topMapper;

    @Override
    public List<Top> findAll() {
        return topMapper.findAll();
    }

    @Override
    public Top findById(Integer topId) {
        return topMapper.findById(topId);
    }

    @Override
    public void add(Top top) {
        topMapper.add(top);
    }

    @Override
    public void deleteById(Integer topId) {
        topMapper.deleteById(topId);
    }

    @Override
    public void update(Top top) {
        topMapper.update(top);
    }
}
