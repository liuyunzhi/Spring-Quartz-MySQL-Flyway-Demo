package com.demo.quartz.config;

import com.demo.quartz.job.SampleJob;
import com.demo.quartz.job.SynchronizeJob;
import org.quartz.JobDetail;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.quartz.CronTriggerFactoryBean;
import org.springframework.scheduling.quartz.JobDetailFactoryBean;

@Configuration
public class QuartzConfiguration {

    @Bean
    public JobDetailFactoryBean sampleJob() {
        JobDetailFactoryBean jobDetailFactory = new JobDetailFactoryBean();

        jobDetailFactory.setJobClass(SampleJob.class);
        jobDetailFactory.setDurability(true);

        return jobDetailFactory;
    }

    @Bean
    public CronTriggerFactoryBean sampleTrigger(JobDetail sampleJob) {
        CronTriggerFactoryBean trigger = new CronTriggerFactoryBean();
        trigger.setCronExpression("* * * * * ? *");
        trigger.setJobDetail(sampleJob);
        return trigger;
    }

    @Bean
    public JobDetailFactoryBean synchronizeJob() {
        JobDetailFactoryBean jobDetailFactory = new JobDetailFactoryBean();

        jobDetailFactory.setJobClass(SynchronizeJob.class);
        jobDetailFactory.setDurability(true);

        return jobDetailFactory;
    }

    @Bean
    public CronTriggerFactoryBean synchronizeTrigger(JobDetail synchronizeJob) {
        CronTriggerFactoryBean trigger = new CronTriggerFactoryBean();
        trigger.setCronExpression("0 0/5 * * * ? *");
        trigger.setMisfireInstructionName("MISFIRE_INSTRUCTION_DO_NOTHING");
        trigger.setJobDetail(synchronizeJob);
        return trigger;
    }
}
