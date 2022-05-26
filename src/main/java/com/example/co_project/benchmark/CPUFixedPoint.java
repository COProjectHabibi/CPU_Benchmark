package com.example.co_project.benchmark;

import java.util.stream.IntStream;

public class CPUFixedPoint implements IBenchmark {
    private int size;
    private int option;
    private final int[] num = new int[]{0, 1, 2, 3};
    private int[] res;
    private int j = 0;
    private int k = 2;
    private int l = 2;
    private int[] a;
    private int[] b;
    private int result = 0;

    @Override
    public void initialize(Object... params) {

        size = (int) params[0];
        res = new int[size];
        a = IntStream.range(0, size).toArray();
        b = new int[size];
    }

    @Override
    public void warmUp() {
        int[] num = new int[]{0, 1, 2, 3};
        int[] res = new int[size];
        int j = 12;
        int k = 1;
        int l = 1;
        int[] a = IntStream.range(0, size).toArray();
        int[] b = new int[size];


        for (int i = 0; i < size; i++) {
            j = num[1] * (k - j) * (l - k);
            k = num[3] * k - (l - j) * k;
            l = (l - k) * (num[2] + j);
            //res[l - 2] = j + k + 1;
            //res[k - 2] = j * k * l;
        }


        for (int i = 0; i < size; i++) {
            if (j == 1)
                j = num[2];
            else
                j = num[3];
            if (j > 2)
                j = num[0];
            else
                j = num[1];
            if (j < 1)
                j = num[1];
            else
                j = num[0];
        }

        for (int i = 0; i < size; i++) {
            swap(a[i], b[a[i]]);
        }

    }

    @Override
    public void run() {
        throw new UnsupportedOperationException("Use run(Object... options) instead");
    }

    private void swap(Object oj1, Object oj2) {
        Object aux = oj1;
        oj1 = oj2;
        oj2 = aux;
    }

    @Override
    public void run(Object... options) {
        option = (int) options[0];

        switch ((int) options[0]) {

            case 0:
                for (int i = 0; i < size; i++) {
                    j = num[1] * (k - j) * (l - k);
                    k = num[3] * k - (l - j) * k;
                    l = (l - k) * (num[2] + j);
                    //res[l - 2] = j + k + 1;
                    //res[k - 2] = j * k * l;
                }
                break;

            case 1:
                for (int i = 0; i < size; i++) {
                    if (j == 1)
                        j = num[2];
                    else
                        j = num[3];
                    if (j > 2)
                        j = num[0];
                    else
                        j = num[1];
                    if (j < 1)
                        j = num[1];
                    else
                        j = num[0];
                }
                break;
            case 2:
                for (int i = 0; i < size; i++) {
                    swap(a[i], b[a[i]]);
                }

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
        switch (option) {
            case 0 -> result += 29;
            case 1 -> result += 15;
            case 2 -> result += 9;
            default -> throw new IllegalStateException("Unexpected value: " + option);
        }

        return String.valueOf(result);
    }

    public int getOP() {
        return result;
    }
}
