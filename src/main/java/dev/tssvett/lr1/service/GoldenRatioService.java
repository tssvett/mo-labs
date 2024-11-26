package dev.tssvett.lr1.service;

import dev.tssvett.lr1.display.Display;
import dev.tssvett.lr1.math.Solver;
import dev.tssvett.lr1.result.Result;

public class GoldenRatioService {
    private final Display display = new Display();

    public void solveByGoldenRatioMethod() {
        Result goldenRatioResult = Solver.findMinimumByGoldenRatio(0, 5, 0.00001);
        display.outputGoldenRatioResult(goldenRatioResult);
    }
}
