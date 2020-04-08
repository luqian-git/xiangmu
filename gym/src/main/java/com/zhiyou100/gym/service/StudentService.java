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

}
