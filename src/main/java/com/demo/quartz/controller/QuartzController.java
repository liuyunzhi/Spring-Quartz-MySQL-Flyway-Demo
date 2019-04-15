package com.demo.quartz.controller;

import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/job")
public class QuartzController {

    private Scheduler scheduler;

    @Autowired
    public QuartzController(Scheduler scheduler) {
        this.scheduler = scheduler;
    }

    @GetMapping("/start")
    public void trigger() throws SchedulerException {

        scheduler.start();
    }
}
