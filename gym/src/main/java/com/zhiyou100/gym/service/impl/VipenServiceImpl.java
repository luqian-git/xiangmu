package com.zhiyou100.gym.service.impl;

import com.zhiyou100.gym.mapper.VipenMapper;
import com.zhiyou100.gym.pojo.Vipen;
import com.zhiyou100.gym.service.VipenService;
import com.zhiyou100.gym.util.PageNumUtil;
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
    public Integer num = PageNumUtil.PageNum;
    @Override
    public Integer findCount(Integer vipenStatus) {
        // 获取 数据库 中 数量
        int count = vipenMapper.findCount(vipenStatus);
        int Page = count / num;
        if (count % num != 0) {
            Page++;
        }
        return Page;
    }

    @Override
    public List<Vipen> findByPage(Integer page, Integer vipenStatus) {
        if (page == null || page < 1) {
            page = 1;
        }
        int size = num;
        //跳过多条数据
        int pages = (page - 1) * size;
        return vipenMapper.findByPage(pages, size,vipenStatus);
    }
}
