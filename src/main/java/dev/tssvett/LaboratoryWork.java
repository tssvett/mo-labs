package dev.tssvett;

import dev.tssvett.display.Display;
import dev.tssvett.service.DichotomyService;

public class LaboratoryWork {
    private final Display display = new Display();
    private final DichotomyService dichotomyService = new DichotomyService();

    public void run() {
        outputGeneralLaboratoryInformation();
        dichotomyService.solveByDichotomyMethod();
    }

    private void outputGeneralLaboratoryInformation() {
        display.outputLaboratorySolverName();
        display.outputLaboratoryVariant();
        display.outputLaboratoryEquation();
    }
}
