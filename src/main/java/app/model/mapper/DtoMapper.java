package app.model.mapper;

import lombok.experimental.UtilityClass;
import app.model.dto.medication.MedicationResponse;
import app.model.entity.medication.Medication;

@UtilityClass
public class DtoMapper {

    public static MedicationResponse from(Medication medication) {

        return MedicationResponse.builder()
                .name(medication.getName())
                .startDate(medication.getStartDate())
                .endDate(medication.getEndDate())
                .medicationDosage(medication.getMedicationDosage())
                .medicationUnit(medication.getMedicationUnit())
                .medicationFrequency(medication.getMedicationFrequency())
                .build();
    }
}
