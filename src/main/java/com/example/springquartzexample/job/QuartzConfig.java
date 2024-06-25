package com.example.springquartzexample.job;

import org.quartz.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class QuartzConfig {

    @Bean
    public JobDetail jobDetail2() {
        return JobBuilder.newJob()
                .withIdentity("myJob2", "group1")
                .ofType(MyJob2.class)
                .storeDurably()
                .build();
    }

    @Bean
    public Trigger trigger2(JobDetail jobDetail2) {
        return TriggerBuilder.newTrigger()
                .withIdentity("myTrigger2", "group1")
                .forJob(jobDetail2)
                .startNow()
                .withSchedule(CronScheduleBuilder.cronSchedule("*/10 * * * * ?"))
                .build();
    }

    @Bean
    public JobDetail jobDetail() {
        return JobBuilder.newJob()
                .withIdentity("myJob", "group1")
                .ofType(MyJob.class)
                .storeDurably()
                .build();
    }

    @Bean
    public Trigger trigger(JobDetail jobDetail) {
        return TriggerBuilder.newTrigger()
                .withIdentity("myTrigger", "group1")
                .forJob(jobDetail)
                .startNow()
                .withSchedule(CronScheduleBuilder.cronSchedule("*/20 * * * * ?"))
                .build();
    }

}
