package app.model.dto.medication;

import lombok.Builder;
import lombok.Data;
import app.model.entity.medication.MedicationName;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@Builder
public class MedicationResponse {

    private MedicationName name;

    private LocalDate startDate;

    private LocalDate endDate;

    private BigDecimal medicationConcentrationMg;

    private String medicationFrequency;
}
