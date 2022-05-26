package com.example.co_project.benchmark;

public class CPUFixedVsFloatingPoint implements IBenchmark {

    private int resultInt;
    private double resultDouble;
    private double result;
    private int size;

    @Override
    public void initialize(Object... params) {
        this.size = (Integer) params[0];
    }

    @Override
    public void warmUp() {
        for (int i = 0; i < size; i++) {
            resultInt = i / 256; // fixed
            resultDouble = i / 256.0; // floating
        }
    }

    @Override
    @Deprecated
    public void run() {
        throw new UnsupportedOperationException("Use run(Object... options) instead");
    }

    @Override
    public void run(Object... options) {
        result = 0;

        switch ((CPUNumberRepresentation) options[0]) {
            case FLOATING:
                for (int i = 0; i < size; i++)
                    resultInt += i / 256;
                result = resultInt;
                break;
            case FIXED:
                for (int i = 0; i < size; i++)
                    resultDouble += i / 256.0;
                result = resultDouble;
                break;
            default:
                break;
        }

    }

    @Override
    public void cancel() {

    }

    @Override
    public void clean() {
    }

    @Override
    public String getResult() {
        return String.valueOf(result);
    }

}
