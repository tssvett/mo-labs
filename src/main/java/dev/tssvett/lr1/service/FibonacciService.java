package dev.tssvett.lr1.service;

import dev.tssvett.lr1.display.Display;
import dev.tssvett.lr1.math.Solver;
import dev.tssvett.lr1.result.Result;

public class FibonacciService {
    private final Display display = new Display();

    public void solveByFibonacciMethod(){
        Result fibonacciResult = Solver.findMinimumByFibonacciMethod(0, 5, 0.00001);
        display.outputFibonacciResult(fibonacciResult);
    }
}
