package com.zhiyou100.gym.MyRegularTask;

import com.zhiyou100.gym.service.CabInfoService;
import com.zhiyou100.gym.service.StudentService;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.quartz.QuartzJobBean;

public class MyCabInfoExpired extends QuartzJobBean {
    @Autowired
    private CabInfoService cabInfoService;
    @Override
    protected void executeInternal(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        //租柜记录过期
        cabInfoService.expired();
    }
}
