package com.zhiyou100.gym.service;

import com.zhiyou100.gym.pojo.Sign;

import java.sql.Timestamp;
import java.util.List;

public interface SignService {
    public List<Sign> findAll(Integer q);
    public List<Sign> findById(Integer signUserNumber);
    public String add(Sign sign);
    public String add2(Long phone,String desc);
    public void deleteById(Integer singId);
    public void update(Sign sign);

    public Sign findNum(Integer signUserNumer);

    public Integer findCount(Integer q);

    public List<Sign> findByPage(Integer page,Integer q);

    public List<Sign> findByPageNum(Integer page,Integer signUserNumer);

    public Integer findCountNum(Integer signUserNumber);

}
