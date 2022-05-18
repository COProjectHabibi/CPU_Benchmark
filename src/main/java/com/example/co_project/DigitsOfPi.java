package com.example.co_project;

import java.time.Clock;

class DigitsOfPi {

    public static String printValueOfPi()
    {
        long startTime = System.nanoTime();
        double pi = 2 * Math.acos(0.0);
        long endTime = System.nanoTime();
        long duration = (endTime - startTime)%1000000;
        String s=String.valueOf(duration);
        return s;
    }

}