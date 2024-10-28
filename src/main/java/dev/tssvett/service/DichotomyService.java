package dev.tssvett.service;

import dev.tssvett.display.Display;
import dev.tssvett.math.Solver;

public class DichotomyService {
    private final Display display = new Display();

    public void solveByDichotomyMethod() {
        DichotomyResult dihotomyDichotomyResult = Solver.findMinimumByDichotomyV1(0, 5, 0.00001);
        display.outputDihotomyResult(dihotomyDichotomyResult);
        DichotomyResult minimumByDichotomyV2 = Solver.findMinimumByDichotomyV2(0, 5, 0.00001);
        display.outputDihotomyResult(minimumByDichotomyV2);
    }

}
