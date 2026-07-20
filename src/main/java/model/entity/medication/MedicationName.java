package model.entity.medication;

public enum MedicationName {
    PHENOBARBITAL("Phenobarbital"),
    POTASSIUM_BROMIDE_KBR("Potassium Bromide(KBr)"),
    LEVETIRACETAM_KEPPRA("Levetiracetam(Keppra)"),
    ZONISAMIDE("Zonisamide"),
    PREGABALIN("Pregabalin"),
    GABAPENTIN("Gabapentin"),
    IMEPITOIN("Imepitoin"),
    TOPIRAMATE("Topiramate"),
    FELBAMATE("Felbamate")
    ;

    private final String displayMedication;

    MedicationName(String displayMedication) {
        this.displayMedication = displayMedication;
    }
}
