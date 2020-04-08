package com.zhiyou100.gym.service;

import com.zhiyou100.gym.pojo.Achievement;

import java.util.List;

public interface AchievementService {

    public List<Achievement> findAll();
    public List<Achievement> findCoachNum(Integer achCoachNum);
    public void add(Achievement achievement);
    public void update1(Integer achId);

}
