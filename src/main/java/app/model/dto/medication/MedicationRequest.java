package app.model.dto.medication;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import app.model.entity.medication.MedicationName;
import app.model.entity.medication.MedicationUnit;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MedicationRequest {

    @NotNull
    private UUID dogId;

    @NotNull
    private MedicationName name;

    @NotNull
    private LocalDate startDate;

    private LocalDate endDate;

    @Positive
    @NotNull
    private BigDecimal medicationDosage;

    @NotNull
    private MedicationUnit medicationUnit;

    @NotNull
    private String medicationFrequency;
}
