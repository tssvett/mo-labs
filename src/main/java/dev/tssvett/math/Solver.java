package dev.tssvett.math;

import dev.tssvett.service.DichotomyResult;

public class Solver {

    private Solver() {
    }

    public static double f(double x) {
        return Math.sqrt(Math.abs(x - 2)) * Math.sqrt(Math.abs(x - 2) * Math.abs(x - 2) * Math.abs(x - 2) * Math.abs(x - 2) * Math.abs(x - 2));
    }

    public static DichotomyResult findMinimumByDichotomy(double a, double b, double deltaX) {
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
}
