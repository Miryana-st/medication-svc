package app.repository.medication;

import app.model.entity.medication.Medication;
import app.model.entity.medication.MedicationName;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface MedicationRepository extends JpaRepository<Medication, UUID> {

    Optional<Medication> findMedicationByDogIdAndName(UUID dogId, MedicationName name);

    List<Medication> findAllByDogId(UUID dogId);
}
