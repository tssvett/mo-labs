package dev.tssvett.lr2.display;

import dev.tssvett.lr2.result.Result;

public class Display {
    private static final String BORDER = "==========================================================================" +
            "==========================";

    public void outputGeneralLaboratoryInformation() {
        this.outputLaboratorySolverName();
        this.outputLaboratoryVariant();
        this.outputLaboratoryEquation();
    }

    public void outputLaboratoryVariant() {
        System.out.println("Вариант лабораторной работы - 10");
    }

    public void outputLaboratoryEquation() {
        System.out.println("Задание:");
        System.out.println("f(x,y,z) = 2x^4 + 2y'^2 + z'^2, (y^0, z^0) = (1, 4), alpha = 0, X^0 = (3, 0, -1)");
        System.out.println(BORDER);
    }

    public void outputLaboratorySolverName() {
        System.out.println("Лабораторную работу выполнил студент группы 6301-010302D Жиляев Максим");
    }

    public void outputDichotomyResult(Result result) {
        System.out.println("Результат дихотомии: " + result.answer() + ", погрешность: " + result.epsilon()
                + ", количество итераций: " + result.iterations());
        System.out.println(BORDER);
    }

    public void outputGoldenRatioResult(Result result) {
        System.out.println("Результат золотого сечения: " + result.answer() + ", погрешность: " + result.epsilon()
                + ", количество итераций: " + result.iterations());
        System.out.println(BORDER);
    }

    public void outputFibonacciResult(Result result) {
        System.out.println("Результат фибоначчи: " + result.answer() + ", погрешность: " + result.epsilon()
                + ", количество итераций: " + result.iterations());
        System.out.println(BORDER);
    }
}
