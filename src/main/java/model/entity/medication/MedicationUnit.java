package model.entity.medication;

public enum MedicationUnit {
    TABLET( "Tablet"),
    ML( "Ml"),
    MG( "Mg"),
    ;

    private final String displayMedicationUnit;

    MedicationUnit(String displayMedicationUnit) {
        this.displayMedicationUnit = displayMedicationUnit;
    }

}
