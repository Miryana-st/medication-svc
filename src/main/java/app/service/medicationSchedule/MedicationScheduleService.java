package app.service.medicationSchedule;

import app.exceptions.MedicationScheduleNotFoundException;
import app.model.dto.medicationSchedule.MedicationScheduleRequest;
import app.model.entity.medication.Medication;
import app.model.entity.medicationSchedule.MedicationSchedule;
import app.repository.medicationSchedule.MedicationScheduleRepository;
import app.service.medication.MedicationService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class MedicationScheduleService {

    private final MedicationScheduleRepository medicationScheduleRepository;
    private final MedicationService medicationService;

    public MedicationScheduleService(MedicationScheduleRepository medicationScheduleRepository, MedicationService medicationService) {
        this.medicationScheduleRepository = medicationScheduleRepository;
        this.medicationService = medicationService;
    }

    public MedicationSchedule addMedicationSchedule(MedicationScheduleRequest medicationScheduleRequest) {

        Medication medication = medicationService.getMedicationById(
                medicationScheduleRequest.getMedicationId()
        );

        MedicationSchedule medicationSchedule = MedicationSchedule.builder()
                .dogId(medicationScheduleRequest.getDogId())
                .medication(medication)
                .administrationTime(medicationScheduleRequest.getAdministrationTime())
                .amount(medicationScheduleRequest.getAmount())
                .dosage(medicationScheduleRequest.getDosage())
                .build();

        return medicationScheduleRepository.save(medicationSchedule);
    }

    public MedicationSchedule updateMedicationSchedule(MedicationScheduleRequest medicationScheduleRequest) {

        MedicationSchedule medicationSchedule = medicationScheduleRepository
                .findMedicationScheduleByMedication_Id(medicationScheduleRequest.getMedicationId())
                .orElseThrow(() -> new MedicationScheduleNotFoundException("Medication Schedule Not Found"));

        Medication medication = medicationService.getMedicationById(medicationScheduleRequest.getMedicationId());

        medicationSchedule.setMedication(medication);
        medicationSchedule.setAdministrationTime(medicationScheduleRequest.getAdministrationTime());
        medicationSchedule.setAmount(medicationScheduleRequest.getAmount());
        medicationSchedule.setDosage(medicationScheduleRequest.getDosage());

        return medicationScheduleRepository.save(medicationSchedule);
    }

    public List<MedicationSchedule> getAllMedicationSchedulesByDogId(UUID dogId) {
        return medicationScheduleRepository.findAllByDogId(dogId);
    }

    public void deleteMedicationSchedule(UUID dogId, UUID medicationScheduleId) {

        MedicationSchedule medicationSchedule = medicationScheduleRepository
                .findById(medicationScheduleId)
                .orElseThrow(() -> new MedicationScheduleNotFoundException("Medication Schedule Not Found"));

        if (!medicationSchedule.getDogId().equals(dogId)) {
            throw new MedicationScheduleNotFoundException("Medication Schedule Not Found for this Dog");
        }

        medicationScheduleRepository.delete(medicationSchedule);
    }
}

