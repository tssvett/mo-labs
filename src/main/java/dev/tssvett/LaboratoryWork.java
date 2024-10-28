package dev.tssvett;

import dev.tssvett.display.Display;
import dev.tssvett.service.DichotomyService;
import dev.tssvett.service.FibonacciService;
import dev.tssvett.service.GoldenRatioService;

public class LaboratoryWork {
    private final Display display = new Display();
    private final DichotomyService dichotomyService = new DichotomyService();
    private final GoldenRatioService goldenRatioService = new GoldenRatioService();
    private final FibonacciService fibonacciService = new FibonacciService();

    public void run() {
        display.outputGeneralLaboratoryInformation();
        dichotomyService.solveByDichotomyMethod();
        goldenRatioService.solveByGoldenRatioMethod();
        fibonacciService.solveByFibonacciMethod();
    }
}
