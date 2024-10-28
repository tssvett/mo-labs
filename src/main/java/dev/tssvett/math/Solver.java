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
        double phi = (1 + Math.sqrt(5)) / 2; // Золотое сечение
        double resphi = 2 - phi;

        // Инициализация
        double x1 = a + resphi * (b - a);
        double x2 = b - resphi * (b - a);
        double f1 = f(x1);
        double f2 = f(x2);

        int iteration = 0;

        while (Math.abs(b - a) > deltaX) {
            iteration++;
            if (f1 < f2) {
                b = x2; // Сужаем интервал
                x2 = x1;
                f2 = f1;
                x1 = a + resphi * (b - a);
                f1 = f(x1);
            } else {
                a = x1; // Сужаем интервал
                x1 = x2;
                f1 = f2;
                x2 = b - resphi * (b - a);
                f2 = f(x2);
            }
        }

        double minimumPoint = (f1 < f2) ? x1 : x2;

        return new Result(minimumPoint, (b - a) / 2, iteration);
    }


    public static Result findMinimumByFibonacciMethod(double a, double b, double deltaX) {
        // Определение числа итераций через длину интервала и deltaX
        int n = 1;
        double fibonacciN2 = 1, fibonacciN1 = 1, fibonacciN = 2;
        while (fibonacciN * deltaX < b - a) {
            n++;
            fibonacciN2 = fibonacciN1;
            fibonacciN1 = fibonacciN;
            fibonacciN = fibonacciN1 + fibonacciN2;
        }

        double x1 = a + fibonacciN2 / fibonacciN * (b - a);
        double x2 = a + fibonacciN1 / fibonacciN * (b - a);
        double f1 = f(x1);
        double f2 = f(x2);

        int iterationCount = 0;

        for (int i = 1; i < n; i++) {
            iterationCount++;
            if (f1 < f2) {
                b = x2;
                x2 = x1;
                f2 = f1;
                x1 = a + fibonacciN2 / fibonacciN * (b - a);
                f1 = f(x1);
            } else {
                a = x1;
                x1 = x2;
                f1 = f2;
                x2 = a + fibonacciN1 / fibonacciN * (b - a);
                f2 = f(x2);
            }
            fibonacciN = fibonacciN1;
            fibonacciN1 = fibonacciN2;
            fibonacciN2 = fibonacciN - fibonacciN1;
        }

        double minimum = (a + b) / 2;
        return new Result(minimum, (b - a) / 2, iterationCount);
    }
}
