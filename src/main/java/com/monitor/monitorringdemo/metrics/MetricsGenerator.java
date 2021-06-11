package com.monitor.monitorringdemo.metrics;

import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class MetricsGenerator {

    private final DemoMetrics demoMetrics;

    public MetricsGenerator(DemoMetrics demoMetrics){
        this.demoMetrics = demoMetrics;
    }

    @Scheduled(fixedRate = 1000)
    public void triggerCustomMetrics(){
        demoMetrics.getRandomMetricData();
    }
}
