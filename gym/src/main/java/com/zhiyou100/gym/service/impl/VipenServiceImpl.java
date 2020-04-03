package com.zhiyou100.gym.service.impl;

import com.zhiyou100.gym.mapper.VipenMapper;
import com.zhiyou100.gym.pojo.Vipen;
import com.zhiyou100.gym.service.VipenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VipenServiceImpl implements VipenService {

    @Autowired
    private VipenMapper vipenMapper;

    @Override
    public List<Vipen> findAll(Integer q) {
        if (q == 1){
            return vipenMapper.findAll1();
        }
        return vipenMapper.findAll0();
    }

    @Override
    public void update(Integer vipenId) {
        vipenMapper.update(vipenId);
    }

    @Override
    public void add(Integer vipenUserId) {
        Vipen vipen = new Vipen();
        long t1=System.currentTimeMillis();
        vipen.setVipenNumber(t1);
        vipen.setVipenUserId(vipenUserId);
        System.out.println(vipen);
        vipenMapper.add(vipen);
    }
}
