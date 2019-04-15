package com.demo.quartz.job;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class SampleJobService {

    void executeSampleJob() {
        log.debug("You are success!");
    }
}
