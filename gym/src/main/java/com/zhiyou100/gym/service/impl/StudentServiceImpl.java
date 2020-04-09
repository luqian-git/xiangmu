package com.zhiyou100.gym.service.impl;

import com.zhiyou100.gym.mapper.StudentMapper;
import com.zhiyou100.gym.pojo.Student;
import com.zhiyou100.gym.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentMapper studentMapper;

    @Override
    public List<Student> findAll() {
        return studentMapper.findAll();
    }

    @Override
    public List<Student> findNum(Integer studentCoachNum) {
        return studentMapper.findNum(studentCoachNum);
    }

    @Override
    public List<Student> findNum01(Integer studentCoachNum) {
        return studentMapper.findNum01(studentCoachNum);
    }

    @Override
    public Student findById(Integer studentId) {
        return studentMapper.findById(studentId);
    }

    @Override
    public String add(Student student) {
        studentMapper.add(student);
        return "成功";
    }

    @Override
    public String update(Integer studentId) {
        studentMapper.update(studentId);
        return "成功";
    }

    @Override
    public void deleteById(Integer studentId) {
        studentMapper.deleteById(studentId);
    }
    //定时任务定时 每周日 凌晨 把预约 成员 改为 本周的
    @Override
    public void updateState() {
        studentMapper.updateState();
    }
}
