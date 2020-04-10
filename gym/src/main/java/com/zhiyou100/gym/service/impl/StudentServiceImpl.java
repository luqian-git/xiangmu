package com.zhiyou100.gym.service.impl;

import com.zhiyou100.gym.mapper.LeagueMapper;
import com.zhiyou100.gym.mapper.StudentMapper;
import com.zhiyou100.gym.pojo.League;
import com.zhiyou100.gym.pojo.Student;
import com.zhiyou100.gym.service.StudentService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Log4j2
@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentMapper studentMapper;
    @Autowired
    private LeagueMapper leagueMapper;

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
    //周日 把所有的 本周课程剩余 改为 消课
    @Override
    public void updateState2() {
        studentMapper.updateState();
    }

    //团体课有安排

    @Override
    public void haveClass() {
        List<League> leagues = leagueMapper.haveClass();
        if (leagues == null||leagues.isEmpty()){
            log.info("下周无团课安排");
        }else {
            for (League league:leagues){
                Student student = new Student();
                student.setStudentCoachNum(league.getLeagueCoachNumber());
                student.setStudentVipNum(0);
                student.setStudentWeek(league.getLeagueWeekGroup());
                student.setStudentTime(league.getLeagueGroup());
                add(student);
            }
        }
    }
}
