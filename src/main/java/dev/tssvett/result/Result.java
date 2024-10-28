package dev.tssvett.result;

public record Result(
        double answer,
        double epsilon,
        int iterations
) {
}
