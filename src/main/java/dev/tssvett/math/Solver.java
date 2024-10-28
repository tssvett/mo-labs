package dev.tssvett.math;

import dev.tssvett.result.Result;

public class Solver {

    private Solver() {
    }

    public static double f(double x) {
        return Math.sqrt(Math.abs(x - 2)) * Math.sqrt(Math.abs(x - 2) * Math.abs(x - 2) * Math.abs(x - 2) * Math.abs(x - 2) * Math.abs(x - 2));
    }

    public static Result findMinimumByDichotomyV1(double a, double b, double deltaX) {
        int iteration = 0;
        double epsilon = 0.1 * deltaX;

        while (b - a > 2 * deltaX) {
            double x1 = (a + b - epsilon) / 2;
            double x2 = (a + b + epsilon) / 2;

            if (f(x1) < f(x2)) {
                b = x2;
            } else {
                a = x1;
            }
            iteration++;
        }
        double dichotomyResult = (a + b) / 2;
        double dichotomyEpsilon = (b - a) / 2;

        return new Result(dichotomyResult, dichotomyEpsilon, iteration);
    }

    public static Result findMinimumByDichotomyV2(double a, double b, double deltaX) {
        int iteration = 0;
        double xm = (a + b) / 2;
        double L = b - a;

        while (L > 2 * deltaX) {
            double x1 = a + L / 4;
            double x2 = b - L / 4;

            if (f(x1) < f(xm)) {
                b = xm;
                xm = x1;
            } else if (f(x2) < f(xm)) {
                a = xm;
                xm = x2;
            } else {
                a = x1;
                b = x2;
            }
            L = b - a;
            iteration++;
        }
        double dichotomyResult = (a + b) / 2;
        double dichotomyEpsilon = (b - a) / 2;

        return new Result(dichotomyResult, dichotomyEpsilon, iteration);
    }

    public static Result findMinimumByGoldenRatio(double a, double b, double deltaX) {
        double t1 = 0.3819660113;
        double t2 = 1.0 - t1;
        double x0 = a;
        double x1 = a + t1 * (b - a);
        double x2 = a + t2 * (b - a);
        double x3 = b;
        int iteration = 0;
        double fr = 0;

        double f0 = f(x0);
        double f1 = f(x1);
        double f2 = f(x2);
        double f3 = f(x3);
        while (Math.abs(x3 - x0) > deltaX) {
            iteration++;
            if (f1 <= f2) {
                x3 = x2;
                f3 = f2;
                x2 = x1;
                f2 = f1;
                x1 = x0 + t1 * (x3 - x0);
                f1 = f(x1);
                fr = f1;
            } else {
                x0 = x1;
                f0 = f1;
                x1 = x2;
                f1 = f2;
                x2 = x0 + t2 * (x3 - x0);
                f2 = f(x2);
                fr = f2;
            }
        }
        a = x0;
        b = x3;
        return new Result(fr, b - a, iteration);
    }

    public static Result findMinimumByFibonacciMethod(double a, double b, double deltaX) {
        int n = 1;
        while (fibonacci(n) < (b - a) / deltaX) {
            n++;
        }

        double x1 = a + ((double) fibonacci(n - 2) / fibonacci(n)) * (b - a);
        double x2 = a + ((double) fibonacci(n - 1) / fibonacci(n)) * (b - a);
        double f1 = f(x1);
        double f2 = f(x2);

        for (int i = 0; i < n; i++) {
            if (f1 > f2) {
                a = x1;
                x1 = x2;
                f1 = f2;
                x2 = a + ((double) fibonacci(n - i - 1) / fibonacci(n - i)) * (b - a);
                f2 = f(x2);
            } else {
                b = x2;
                x2 = x1;
                f2 = f1;
                x1 = a + ((double) fibonacci(n - i - 2) / fibonacci(n - i)) * (b - a);
                f1 = f(x1);
            }
        }
        double idkWhatIsThis = b - a;
        return new Result(f((a + b) / 2), idkWhatIsThis, n);
    }


    private static int fibonacci(int n) {
        if (n == 0){
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        return fibonacci(n - 1) + fibonacci(n - 2);
    }
}
