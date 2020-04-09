package com.zhiyou100.gym.service.impl;

import com.zhiyou100.gym.mapper.PotentialMapper;
import com.zhiyou100.gym.pojo.Potential;
import com.zhiyou100.gym.service.PotentialService;
import com.zhiyou100.gym.util.PageNumUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PotentialServiceImpl implements PotentialService {

    @Autowired
    private PotentialMapper potentialMapper;

    @Override
    public List<Potential> findAll() {
        return potentialMapper.findAll();
    }

    @Override
    public Potential findById(Integer potId) {
        return potentialMapper.findById(potId);
    }

    @Override
    public void add(Potential potential) {
        Potential potential11 =  potentialMapper.findMax();
        if (potential11 == null){
            potential.setPotNumber(70001);
        }else {
            potential.setPotNumber(potential11.getPotNumber()+1);
        }
        potentialMapper.add(potential);
    }

    @Override
    public void deleteById(Integer potId) {
        potentialMapper.deleteById(potId);
    }

    @Override
    public void update(Potential potential) {
        potentialMapper.update(potential);
    }

    public Integer num = PageNumUtil.PageNum;
    @Override
    public Integer findCount() {
        // 获取 数据库 中 数量
        int count = potentialMapper.findCount();
        int Page = count / num;
        if (count % num != 0) {
            Page++;
        }
        return Page;
    }

    @Override
    public List<Potential> findByPage(Integer page) {
        if (page == null || page < 1) {
            page = 1;
        }
        int size = num;
        //跳过多条数据
        int pages = (page - 1) * size;
        return potentialMapper.findByPage(pages, size);
    }
}
