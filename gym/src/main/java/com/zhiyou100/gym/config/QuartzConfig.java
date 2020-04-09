package com.zhiyou100.gym.config;

import com.zhiyou100.gym.MyRegularTask.MyTast;
import org.quartz.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import sun.rmi.runtime.NewThreadAction;

import java.util.Date;

import static org.quartz.CronScheduleBuilder.cronSchedule;
import static org.quartz.SimpleScheduleBuilder.simpleSchedule;

@Configuration
public class QuartzConfig {


    @Bean
    public JobDetail MyTast(){
        //构建一个任务对象
        return JobBuilder.newJob(MyTast.class).storeDurably().withIdentity("myjob").build();
    }

    @Bean
    public Trigger trigger(){
        //设置任务的执行方  这里有很多方法
        Trigger trigger = TriggerBuilder.newTrigger()
                .withIdentity("trigger3", "group1")
                //每周凌晨一点 0 0 1 ? * L || 0 15 12 ? * THU 每周四
                //SUN, MON, TUE, WED, THU, FRI SAT 周日 到 周六
                .withSchedule(cronSchedule("0 26 12 ? * THU")).forJob(MyTast()).build();

                //.withSchedule(cronSchedule("0 0 1 ? * SUN")).forJob(MyTast()).build();

        return trigger;




    }
}
