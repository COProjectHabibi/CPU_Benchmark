package com.example.co_project;

public class PiSpigot {
    public  int digits_requested;
    public  int[] digits;
    public StringBuilder predigits = new StringBuilder();

    public String piString = "";

    public  static final int MAX_DIGITS_REQUESTED = 644245094;


    public static void printHelp() {
        System.err.println("\n  PiSpigot [number of digits requested]\n");
    }


    public static void main(String args[]) {
        PiSpigot spigot = new PiSpigot();
        if (!spigot.parseArgs(args)) return;
        spigot.run();
    }


    public boolean parseArgs(String args[]) {
        if (args.length != 1) {
            printHelp();
            return false;
        }

        try {
            digits_requested = Integer.parseInt(args[0]);
        } catch (NumberFormatException e) {
            printHelp();
            return false;
        }

        if (digits_requested <= 0) {
            System.err.println("Digit count must be positive.");
            return false;
        }

        if (digits_requested > MAX_DIGITS_REQUESTED) {
            System.err.println("Maximum digit count is " + MAX_DIGITS_REQUESTED);
            return false;
        }

        return true;
    }


    public boolean init() {
        int array_size_needed = digits_requested * 10 / 3 + 1;
        digits = new int[array_size_needed];
        if (digits == null) {
            System.err.printf("Failed to allocate " + (array_size_needed*4)
                    + " bytes.");
            return false;
        }

        for (int i=0; i < digits.length; i++)
            digits[i] = 2;

        return true;
    }


    void run() {
        if (!init()) return;

        for (int iter = 0; iter < digits_requested; iter++) {

            int carry = 0;
            for (int i=digits.length-1; i > 0; i--) {
                int numerator = i;
                int denomenator = i * 2 + 1;
                int tmp = digits[i] * 10 + carry;
                digits[i] = tmp % denomenator;
                carry = tmp / denomenator * numerator;
            }

            int tmp = digits[0] * 10 + carry;
            digits[0] = tmp % 10;
            int digit = tmp / 10;

            if (digit < 9) {
                flushDigits();
                if (iter == 1)
                    piString += ".";
                addDigit(digit);
            } else if (digit == 9) {
                addDigit(digit);
            } else {
                overflowDigits();
                flushDigits();
                addDigit(0);
            }
        }
        flushDigits();
        System.out.println();
    }



    void flushDigits() {
        piString += predigits;
        predigits.setLength(0);
    }


    void addDigit(int digit) {
        predigits.append((char)('0' + digit));
    }


    void overflowDigits() {
        for (int i=0; i < predigits.length(); i++) {
            char digit = predigits.charAt(i);

            if (digit == '9') {
                predigits.setCharAt(i, '0');
            } else {
                predigits.setCharAt(i, (char)(digit + 1));
            }
        }
    }

}