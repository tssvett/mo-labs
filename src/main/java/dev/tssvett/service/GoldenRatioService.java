package dev.tssvett.service;

import dev.tssvett.display.Display;
import dev.tssvett.math.Solver;
import dev.tssvett.result.Result;

public class GoldenRatioService {
    private final Display display = new Display();

    public void solveByGoldenRatioMethod() {
        Result goldenRatioResult = Solver.findMinimumByGoldenRatio(0, 5, 0.00001);
        display.outputGoldenRatioResult(goldenRatioResult);
    }
}
