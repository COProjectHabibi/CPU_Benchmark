package com.example.co_project.testbanch;

import com.example.co_project.benchmark.IBenchmark;
import com.example.co_project.benchmark.CPUDigitsOfPi;
import com.example.co_project.logging.ConsoleLogger;
import com.example.co_project.logging.FileLogger;
import com.example.co_project.logging.ILogger;
import com.example.co_project.logging.TimeUnit;
import com.example.co_project.timing.ITimer;
import com.example.co_project.timing.Timer;


public class PiTestBench {
    public static void main(String[] args) {
        ITimer timer = new Timer();
        ILogger log = new ConsoleLogger();
        IBenchmark bench = new CPUDigitsOfPi();

        TimeUnit timeUnit = TimeUnit.Milli;

        final long workload = 5000;
        final int scale = 100;
        final int runs = 12;
        long temp ;
        bench.initialize(workload,scale);

        for (int i = 0; i <runs ; i++) {
            bench.warmUp();
        }

        for (int i = 0; i < runs; i++) {
            timer.resume();
            bench.run();
            temp = timer.pause();
            log.writeTime("Run " + i + " finished in: ", temp, timeUnit);
        }
        temp = timer.stop();

        System.out.println(((CPUDigitsOfPi)bench).getPi());
        log.writeTime("Finished in ", temp, timeUnit);

        log.close();
        bench.clean();

    }
}
