package com.example.co_project.benchmark;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;

public class CPUDigitsOfPi implements IBenchmark {
    private long iterations;
    private static int scale;
    private boolean running = true;
    MathContext mc;
    BigDecimal two;
    BigDecimal a;
    BigDecimal b;
    BigDecimal t;
    BigDecimal p;
    BigDecimal an1;
    BigDecimal bn1;
    BigDecimal tn1;
    BigDecimal pn1;
    BigDecimal pi;

    @Override
    public void initialize(Object... params) {
        iterations = (long) params[0];
        scale = (int) params[1];

        mc = new MathContext(scale);
        two = new BigDecimal(2);
        a = new BigDecimal(1.0d);
        b = new BigDecimal(1.0d).divide(new BigDecimal(2).sqrt(mc), scale, RoundingMode.CEILING);
        t = new BigDecimal(0.25d);
        p = new BigDecimal(1.0d);
        pi = new BigDecimal(0);
    }

    @Override
    public void warmUp() {
        MathContext mc = new MathContext(scale);
        BigDecimal two = new BigDecimal(2);
        BigDecimal a = new BigDecimal(1.0);
        BigDecimal b = new BigDecimal(1.0).divide(new BigDecimal(2).sqrt(mc), scale, RoundingMode.CEILING);
        BigDecimal t = new BigDecimal(0.25);
        BigDecimal p = new BigDecimal(1.0);
        BigDecimal an1;
        BigDecimal bn1;
        BigDecimal tn1;
        BigDecimal pn1;
        BigDecimal pi = new BigDecimal(0);

        for (long i = 0; i < 5000 && running; ++i) {
            an1 = a.add(b, mc).divide(two, scale, RoundingMode.CEILING);
            bn1 = a.multiply(b, mc).sqrt(mc);
            tn1 = t.subtract(p.multiply(a.subtract(an1, mc).pow(2, mc), mc), mc);
            pn1 = p.multiply(two, mc);
            pi = a.add(b, mc).pow(2, mc).divide(t.multiply(new BigDecimal(4), mc), scale, RoundingMode.CEILING);
            a = an1;
            b = bn1;
            t = tn1;
            p = pn1;

        }
    }


    @Override
    public void run() {

        for (long i = 0; i < iterations && running; ++i) {
            an1 = a.add(b, mc).divide(two, scale, RoundingMode.CEILING);
            bn1 = a.multiply(b, mc).sqrt(mc);
            tn1 = t.subtract(p.multiply(a.subtract(an1, mc).pow(2, mc), mc), mc);
            pn1 = p.multiply(two, mc);
            pi = a.add(b, mc).pow(2, mc).divide(t.multiply(new BigDecimal(4), mc), scale, RoundingMode.CEILING);
            a = an1;
            b = bn1;
            t = tn1;
            p = pn1;

        }
    }

    public BigDecimal getPi() {
        return pi;
    }

    @Override
    public void run(Object... params) {
        throw new UnsupportedOperationException("Use run() instead");
    }

    @Override
    public void clean() {

    }

    @Override
    public String getResult() {
        return null;
    }

    @Override
    public void cancel() {
        running = false;
    }
}
