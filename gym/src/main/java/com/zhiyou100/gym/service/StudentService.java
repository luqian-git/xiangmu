package com.zhiyou100.gym.service;

import com.zhiyou100.gym.pojo.Student;

import java.util.List;

public interface StudentService {

    public List<Student> findAll();
    //教练查看

    public List<Student> findNum(Integer studentCoachNum);
    //学员管理
    public List<Student> findNum01(Integer studentCoachNum);

    public Student findById(Integer studentId);
    public String add(Student student);
    public String update(Integer studentId);
    public void deleteById(Integer studentId);

    //定时任务定时 每周日 凌晨 把预约 成员 改为 本周的

    public void updateState();
    //周日 把所有的 本周课程剩余 改为 消课

    public void updateState2();

    public void haveClass();

}
