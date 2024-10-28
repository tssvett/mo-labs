package dev.tssvett.display;

import dev.tssvett.service.DichotomyResult;

public class Display {
    private static final String BORDER = "===========================================================================================";

    public void outputLaboratoryVariant() {
        System.out.println("Вариант лабораторной работы - 10");
    }

    public void outputLaboratoryEquation() {
        System.out.println("Задание:");
        System.out.println("f(x) = sqrt(abs(x-2)^5), x принадлежит [0, 5]");
        System.out.println(BORDER);
    }

    public void outputLaboratorySolverName() {
        System.out.println("Лабораторную работу выполнил студент группы 6301-010302D Жиляев Максим");
    }

    public void outputDihotomyResult(DichotomyResult dichotomyResult) {
        System.out.println("Результат дихотомии: " + dichotomyResult.dichotomyResult() + ", погрешность: " + dichotomyResult.epsilon() + ", количество итераций: " + dichotomyResult.iterations());
        System.out.println(BORDER);
    }
}
