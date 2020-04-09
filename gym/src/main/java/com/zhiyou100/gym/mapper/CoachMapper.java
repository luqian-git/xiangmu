package com.zhiyou100.gym.mapper;

import com.zhiyou100.gym.pojo.Coach;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface CoachMapper {

    public List<Coach> findAll(Integer coachPosition);
    public List<Coach> findAllD(Integer coachPosition);


    // 分页 员工 单
    public Integer findAllCount(Integer coachPosition);
    public List<Coach> findDByPage(@Param("start") int start, @Param("size") int size,Integer coachPosition);



    public List<Coach> findCoach();
    public Coach findById(Integer coachId);
    public void add(Coach coach);
    public void deleteById(Integer coachId);
    public void update(Coach coach);

    public Coach findByMax();

    public Coach findByNum(Integer coachNum);

    public Coach findByCoachNum(Integer coachNum);

}
