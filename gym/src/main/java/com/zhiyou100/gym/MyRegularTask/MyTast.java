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
        studentService.updateState();
    }
}
