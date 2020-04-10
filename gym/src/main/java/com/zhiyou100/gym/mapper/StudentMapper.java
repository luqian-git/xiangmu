package com.zhiyou100.gym.mapper;

import com.zhiyou100.gym.pojo.Student;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface StudentMapper {

    public List<Student> findAll();
    //教练查看

    public List<Student> findNum(Integer studentCoachNum);

    public List<Student> findNum01(Integer studentCoachNum);

    public Student findById(Integer studentId);
    public void add(Student student);

    public void update(Integer studentId);

    public void deleteById(Integer studentId);

    //周日 把所有的 预约 改为 本周课程

    public void updateState();

    //周日 把所有的 本周课程剩余 改为 消课

    public void updateState2();

}
