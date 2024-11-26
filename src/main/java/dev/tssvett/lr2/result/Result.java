package dev.tssvett.lr2.result;

public record Result(
        double answer,
        double epsilon,
        int iterations
) {
}
