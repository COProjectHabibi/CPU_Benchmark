package com.example.co_project;

import java.time.Clock;

import static java.lang.Math.log;
import static java.lang.Math.sqrt;

class DigitsOfPi {
    public static double pi;
    public static double duration;
    public static String printValueOfPi()
    {
        long startTime = System.nanoTime();
        pi = 2 * Math.acos(0.0);
        long endTime = System.nanoTime();
        duration = (endTime - startTime)%1000000;
        String s=String.valueOf(duration);
        return s;
    }

    public static String printScore(){
        double score = sqrt(pi * duration) / log(10);
        String s = String.valueOf(score);
        return s;
    }

}