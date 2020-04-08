package com.zhiyou100.gym.config;

import com.zhiyou100.gym.MyRegularTask.MyTast;
import org.quartz.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
@Configuration
public class QuartzConfig {


    @Bean
    public JobDetail MyTast(){
        //构建一个任务对象
        return JobBuilder.newJob(MyTast.class).storeDurably().withIdentity("myjob").build();
    }
    /**
     * 创建Trigger关联Job任务
     */
    @Bean
    public Trigger trigger(){
        //设置任务的执行方  这里有很多方法
        SimpleScheduleBuilder scheduleBuilder = SimpleScheduleBuilder.simpleSchedule()
                //这是设置几秒  也可.其他的 设置小时等等
                .withIntervalInSeconds(86400)
                .repeatForever();
        return TriggerBuilder.newTrigger().
                //执行任务
                forJob(MyTast()).
                withIdentity("myTriger").
                //forjob你要执行的任务，调用上边方法即可
                        withSchedule(scheduleBuilder).
                //关联schedule对象
                //立即开始，默认的方式
                        startNow().
                //构建触发器
                        build();
    }

}
