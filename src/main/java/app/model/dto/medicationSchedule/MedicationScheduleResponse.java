package app.model.dto.medicationSchedule;

import app.model.entity.medication.Medication;
import app.model.entity.medicationSchedule.Dosage;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalTime;

@Data
@Builder
public class MedicationScheduleResponse {

    private Medication medication;

    private LocalTime administrationTime;

    private BigDecimal amount;

    private Dosage dosage;
}
