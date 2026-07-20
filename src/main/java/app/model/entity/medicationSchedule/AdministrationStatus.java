package app.model.entity.medicationSchedule;

public enum AdministrationStatus {
    PENDING("Pending"),
    TAKEN("Taken"),
    MISSED("Missed"),
    ;

    private final String displayAdministrationStatus;

    AdministrationStatus(String displayAdministrationStatus) {
        this.displayAdministrationStatus = displayAdministrationStatus;
    }

}
