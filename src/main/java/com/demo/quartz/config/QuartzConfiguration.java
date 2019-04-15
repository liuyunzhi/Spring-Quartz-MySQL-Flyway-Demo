package com.demo.quartz.config;

import com.demo.quartz.job.SampleJob;
import org.quartz.JobDetail;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.quartz.CronTriggerFactoryBean;
import org.springframework.scheduling.quartz.JobDetailFactoryBean;

@Configuration
public class QuartzConfiguration {

    @Bean
    public JobDetailFactoryBean job() {
        JobDetailFactoryBean jobDetailFactory = new JobDetailFactoryBean();

        jobDetailFactory.setJobClass(SampleJob.class);
        jobDetailFactory.setDurability(true);

        return jobDetailFactory;
    }

    @Bean
    public CronTriggerFactoryBean trigger(JobDetail job) {
        CronTriggerFactoryBean trigger = new CronTriggerFactoryBean();
        trigger.setCronExpression("0/5 1-2 * * * ? ");
        trigger.setJobDetail(job);
        return trigger;
    }
}
