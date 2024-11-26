package dev.tssvett.lr1.result;

public record Result(
        double answer,
        double epsilon,
        int iterations
) {
}
