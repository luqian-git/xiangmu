package com.zhiyou100.gym.mapper;

import com.zhiyou100.gym.pojo.Achievement;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface AchievementMapper {

    public List<Achievement> findAll();
    public List<Achievement> findCoachNum(Integer achCoachNum);

    public void add(Achievement achievement);
    public void update1(Integer achId);

}
