package app.service.medication;

import app.model.dto.medication.MedicationRequest;
import app.model.entity.medication.Medication;
import org.springframework.stereotype.Service;
import app.repository.medication.MedicationRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class MedicationService {

    private final MedicationRepository medicationRepository;

    public MedicationService(MedicationRepository medicationRepository) {
        this.medicationRepository = medicationRepository;
    }

    public Medication upsert(MedicationRequest medicationRequest) {

        Optional<Medication> medicationOptional = medicationRepository.findMedicationByDogIdAndName(medicationRequest.getDogId(), medicationRequest.getName());

        if (medicationOptional.isPresent()) {

            Medication medication = medicationOptional.get();

            medication.setMedicationConcentrationMg(medicationRequest.getMedicationConcentrationMg());
            medication.setMedicationFrequency(medicationRequest.getMedicationFrequency());
            medication.setEndDate(medicationRequest.getEndDate());
            medication.setStartDate(medicationRequest.getStartDate());

            return medicationRepository.save(medication);
        }

        Medication medication = Medication.builder()
                .dogId(medicationRequest.getDogId())
                .name(medicationRequest.getName())
                .medicationConcentrationMg(medicationRequest.getMedicationConcentrationMg())
                .medicationFrequency(medicationRequest.getMedicationFrequency())
                .startDate(medicationRequest.getStartDate())
                .endDate(medicationRequest.getEndDate())
                .build();

        return medicationRepository.save(medication);
    }

    public List<Medication> getAllMedicationsByDogId(UUID dogId) {

        return medicationRepository.findAllByDogId(dogId);
    }

    public void deleteMedication(UUID dogId, UUID medicationId) {
        List<Medication> medications = medicationRepository.findAllByDogId(dogId);
        for (Medication medication : medications) {
            if (medication.getId().equals(medicationId)) {
                medicationRepository.delete(medication);
            }
        }
    }
}
