package dev.tssvett.service;

import dev.tssvett.display.Display;
import dev.tssvett.math.Solver;
import dev.tssvett.result.Result;

public class FibonacciService {
    private final Display display = new Display();

    public void solveByFibonacciMethod(){
        Result fibonacciResult = Solver.findMinimumByFibonacciMethod(0, 5, 0.00001);
        display.outputFibonacciResult(fibonacciResult);
    }
}
