package com.zhiyou100.gym.service.impl;

import com.zhiyou100.gym.mapper.CabinetMapper;
import com.zhiyou100.gym.pojo.Cabinet;
import com.zhiyou100.gym.service.CabinetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CabinetServiceImpl implements CabinetService {

    @Autowired
    private CabinetMapper cabinetMapper;

    @Override
    public List<Cabinet> findYAll() {
        return cabinetMapper.findYAll();
    }
    @Override
    public List<Cabinet> findWAll() {
        return cabinetMapper.findWAll();
    }

    @Override
    public Cabinet findById(Integer usId) {
        return null;
    }

    @Override
    public String add(Cabinet user) {
        return null;
    }

    @Override
    public String deleteById(Integer usId) {
        return null;
    }

    @Override
    public String update(Cabinet user) {
        return null;
    }


    @Override
    public void update1(Integer cabId) {
        cabinetMapper.update1(cabId);
    }

    @Override
    public void update3(Integer cabId) {
        cabinetMapper.update3(cabId);
    }
}
