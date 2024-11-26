package dev.tssvett;

import dev.tssvett.lr1.display.Display;
import dev.tssvett.lr1.service.DichotomyService;
import dev.tssvett.lr1.service.FibonacciService;
import dev.tssvett.lr1.service.GoldenRatioService;

public class SecondLaboratoryWork {
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
