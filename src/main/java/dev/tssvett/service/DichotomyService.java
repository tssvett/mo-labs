package dev.tssvett.service;

import dev.tssvett.display.Display;
import dev.tssvett.math.Solver;
import dev.tssvett.result.Result;

public class DichotomyService {
    private final Display display = new Display();

    public void solveByDichotomyMethod() {
        Result dihotomyResult = Solver.findMinimumByDichotomyV1(0, 5, 0.00001);
        display.outputDichotomyResult(dihotomyResult);

        Result minimumByDichotomyV2 = Solver.findMinimumByDichotomyV2(0, 5, 0.00001);
        display.outputDichotomyResult(minimumByDichotomyV2);
    }
}
