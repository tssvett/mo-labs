package dev.tssvett.lr1.service;

import dev.tssvett.lr1.display.Display;
import dev.tssvett.lr1.math.Solver;
import dev.tssvett.lr1.result.Result;

public class DichotomyService {
    private final Display display = new Display();

    public void solveByDichotomyMethod() {
        Result dihotomyResult = Solver.findMinimumByDichotomyV1(0, 5, 0.00001);
        display.outputDichotomyResult(dihotomyResult);
    }
}
