package com.demo.quartz.job;

import lombok.extern.slf4j.Slf4j;
import org.quartz.JobExecutionContext;
import org.springframework.scheduling.quartz.QuartzJobBean;

@Slf4j
public class SynchronizeJob extends QuartzJobBean {

    @Override
    protected void executeInternal(JobExecutionContext context) {
        log.debug("This is a synchronize job.");
    }
}
