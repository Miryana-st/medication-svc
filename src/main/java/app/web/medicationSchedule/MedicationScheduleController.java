package app.web.medicationSchedule;

import app.model.dto.medicationSchedule.MedicationScheduleRequest;
import app.model.dto.medicationSchedule.MedicationScheduleResponse;
import app.model.entity.medicationSchedule.MedicationSchedule;
import app.model.mapper.DtoMapper;
import app.service.medicationSchedule.MedicationScheduleService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("api/v1/medication-schedule")
public class MedicationScheduleController {

    private final MedicationScheduleService medicationScheduleService;

    public MedicationScheduleController(MedicationScheduleService medicationScheduleService) {
        this.medicationScheduleService = medicationScheduleService;
    }

    @GetMapping
    public ResponseEntity<List<MedicationScheduleResponse>> getAllMedicationSchedulesByDogId(@RequestParam ("dogId") UUID dogId) {

        List<MedicationSchedule> medicationSchedules = medicationScheduleService.getAllMedicationSchedulesByDogId(dogId);

        List<MedicationScheduleResponse> medicationScheduleResponses = medicationSchedules.stream().map(DtoMapper::from).toList();

        return ResponseEntity.ok(medicationScheduleResponses);
    }

    @PostMapping
    public ResponseEntity<MedicationScheduleResponse> addMedicationSchedule(@RequestBody MedicationScheduleRequest medicationScheduleRequest) {

        MedicationSchedule medicationSchedule = medicationScheduleService.addMedicationSchedule(medicationScheduleRequest);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(DtoMapper.from(medicationSchedule));
    }

    @PutMapping
    public ResponseEntity<MedicationScheduleResponse> updateMedicationSchedule(@RequestBody MedicationScheduleRequest medicationScheduleRequest) {

        MedicationSchedule medicationSchedule = medicationScheduleService.updateMedicationSchedule(medicationScheduleRequest);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(DtoMapper.from(medicationSchedule));
    }

    @DeleteMapping
    public ResponseEntity<Void> deleteMedicationSchedule(@RequestParam ("dogId") UUID dogId, @RequestParam ("medicationScheduleId") UUID medicationScheduleId) {

        medicationScheduleService.deleteMedicationSchedule(dogId, medicationScheduleId);

        return ResponseEntity.noContent().build();
    }

}
