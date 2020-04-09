package com.zhiyou100.gym.mapper;

import com.zhiyou100.gym.pojo.Achievement;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface AchievementMapper {

    public List<Achievement> findAll();
    public List<Achievement> findCoachNum(Integer achCoachNum);

    public void add(Achievement achievement);
    public void update1(Integer achId);

    public Integer findCount();
    public List<Achievement> findByPage(@Param("start") int start, @Param("size") int size);

    public Integer findCoachNumCount(Integer achCoachNum);
    public List<Achievement> findCoachNumByPage(@Param("start") int start, @Param("size") int size,Integer achCoachNum);

}
