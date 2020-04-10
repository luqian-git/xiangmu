package com.zhiyou100.gym.service.impl;

import com.zhiyou100.gym.mapper.CoachMapper;
import com.zhiyou100.gym.mapper.UserMapper;
import com.zhiyou100.gym.pojo.Coach;
import com.zhiyou100.gym.pojo.User;
import com.zhiyou100.gym.service.CoachService;
import com.zhiyou100.gym.util.PageNumUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class CoachServiceImpl implements CoachService {

    @Autowired
    private CoachMapper coachMapper;
    @Autowired
    private UserMapper userMapper;

    @Override
    public List<Coach> findAll(Integer coachPosition) {
        return coachMapper.findAll(coachPosition);
    }
    @Override
    public List<Coach> findAllD(Integer coachPosition) {
        return coachMapper.findAllD(coachPosition);
    }

    @Override
    public Coach findcoachNumber(Integer coachNumber) {
        return coachMapper.findByCoachNum(coachNumber);
    }

    @Override
    public Coach findById(Integer coachId) {
        return coachMapper.findById(coachId);
    }

    @Override
    public void add(Coach coach) {
        User userMax = userMapper.findByUMax();
        // 添加账号
        User user = new User();
        user.setUsAccount(coach.getAccount());
        user.setUsPassword(coach.getPassword());
        user.setUsName(coach.getCoachName());
        user.setUsSex(coach.getCoachSex());
        user.setUsAge(coach.getCoachAge());
        user.setUsHead(coach.getCoachHead());
        user.setUsLabel(coach.getCoachLabel());
        user.setUsIntroduce(coach.getCoachIntroduce());
        user.setUsMember(userMax.getUsMember()+1);
        userMapper.add(user);
        //通过刚创建的账号查询 这条数据
        User us = userMapper.findAccount(coach.getAccount());
        userMapper.addRole(us.getUsId(),coach.getCoachPosition());
        // 添加员工-- 获得员工编号
        coach.setCoachNumber(userMax.getUsMember()+1);
        coachMapper.add(coach);
    }

    @Override
    public void deleteById(Integer coachId) {
        coachMapper.deleteById(coachId);
    }

    @Override
    public void update(Coach coach) {
        User user = new User();
        user.setUsPassword(coach.getPassword());
        user.setUsName(coach.getCoachName());
        user.setUsSex(coach.getCoachSex());
        user.setUsAge(coach.getCoachAge());
        user.setUsHead(coach.getCoachHead());
        user.setUsLabel(coach.getCoachLabel());
        user.setUsIntroduce(coach.getCoachIntroduce());
        user.setUsMember(coach.getCoachNumber());
        System.out.println(user);
        userMapper.updateinfo(user);
        System.out.println(coach+"==========="+coach.getCoachNumber());
        if (coach.getCoachStatus().equals("离职") || coach.getCoachStatus().equals("辞退")){
            System.out.println(coach.getCoachStatus());
            userMapper.cancellation(coach.getCoachNumber());
        }
        coachMapper.update(coach);
    }

    @Override
    public List<Coach> findCoach() {
        return coachMapper.findCoach();
    }

    public Integer num = PageNumUtil.PageNum;
    @Override
    public Integer findCount(Integer coachPosition) {
        // 获取 数据库 中 数量
        int count = coachMapper.findAllCount(coachPosition);
        int Page = count / num;
        if (count % num != 0) {
            Page++;
        }
        return Page;
    }

    @Override
    public List<Coach> findByPage(Integer page, Integer coachPosition) {
        if (page == null || page < 1) {
            page = 1;
        }
        int size = num;
        //跳过多条数据
        int pages = (page - 1) * size;
        return coachMapper.findDByPage(pages, size,coachPosition);
    }
}
