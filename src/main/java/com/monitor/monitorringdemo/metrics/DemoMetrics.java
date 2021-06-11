package com.monitor.monitorringdemo.metrics;

import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.MeterRegistry;
import org.springframework.stereotype.Component;

import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

@Component
public class DemoMetrics {

    private final Counter counter;
    private final AtomicInteger gauge;

    public DemoMetrics(MeterRegistry registry){
        this.counter = registry.counter("demo_counter");
        this.gauge = registry.gauge("demo_gauge", new AtomicInteger(0));
    }

    public void getRandomMetricData(){
        counter.increment();
        gauge.set(getRandomNumberInRange(0,100));
    }

    public int getRandomNumberInRange(int min, int max){
        if(min > max){
            throw new IllegalArgumentException("min should be less than max");
        }

        Random random = new Random();

        return random.nextInt((max-min)+1)+min;
    }
}
