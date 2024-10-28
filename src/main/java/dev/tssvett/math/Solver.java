package dev.tssvett.math;

import dev.tssvett.service.DichotomyResult;

public class Solver {

    private Solver() {
    }

    public static double f(double x) {
        return Math.sqrt(Math.abs(x - 2)) * Math.sqrt(Math.abs(x - 2) * Math.abs(x - 2) * Math.abs(x - 2) * Math.abs(x - 2) * Math.abs(x - 2));
    }

    public static DichotomyResult findMinimumByDichotomyV1(double a, double b, double deltaX) {
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

        return new DichotomyResult(dichotomyResult, dichotomyEpsilon, iteration);
    }

    public static DichotomyResult findMinimumByDichotomyV2(double a, double b, double deltaX) {
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

        return new DichotomyResult(dichotomyResult, dichotomyEpsilon, iteration);
    }
}
