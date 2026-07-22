package app.model.dto.medicationSchedule;

import app.model.entity.medicationSchedule.Dosage;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalTime;
import java.util.UUID;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MedicationScheduleRequest {

    @NotNull
    private UUID dogId;

    @NotNull
    private UUID medicationId;

    @NotNull
    private LocalTime administrationTime;

    @NotNull
    @Positive
    private BigDecimal amount;

    @NotNull
    private Dosage dosage;
}
