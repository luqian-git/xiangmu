package com.zhiyou100.gym.MyRegularTask;

import com.zhiyou100.gym.service.StudentService;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.quartz.QuartzJobBean;

public class MyTast extends QuartzJobBean {
    @Autowired
    private StudentService studentService;
    @Override
    protected void executeInternal(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        //先消课 再把本周预约改为 本周
        studentService.updateState2();
        studentService.updateState();
        //下周团体课 占用 教练 安排
        studentService.haveClass();
    }
}
