package dev.tssvett.service;

public record DichotomyResult(
        double dichotomyResult,
        double epsilon,
        int iterations
) {
}
