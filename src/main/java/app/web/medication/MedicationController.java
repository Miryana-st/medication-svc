package app.web.medication;

import app.model.dto.medication.MedicationRequest;
import app.model.dto.medication.MedicationResponse;
import app.model.entity.medication.Medication;
import app.model.mapper.DtoMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import app.service.medication.MedicationService;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("api/v1/medications")
public class MedicationController {

    private final MedicationService medicationService;

    public MedicationController(MedicationService medicationService) {
        this.medicationService = medicationService;
    }

    @PostMapping
    public ResponseEntity<MedicationResponse> upsertMedication(@RequestBody MedicationRequest medicationRequest) {

        Medication medication = medicationService.upsert(medicationRequest);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(DtoMapper.from(medication));
    }

    @GetMapping
    public ResponseEntity<List<MedicationResponse>> getMedicationsByDogId(@RequestParam ("dogId") UUID dogId) {

        List<Medication> medications = medicationService.getAllMedicationsByDogId(dogId);
        List<MedicationResponse> medicationResponses = medications.stream().map(DtoMapper::from).toList();

        return ResponseEntity.ok(medicationResponses);
    }

    @DeleteMapping
    public ResponseEntity<Void> deleteMedication(@RequestParam ("dogId") UUID dogId, @RequestParam ("medicationId") UUID medicationId) {

        medicationService.deleteMedication(dogId, medicationId);

        return ResponseEntity.ok(null);
    }

}
