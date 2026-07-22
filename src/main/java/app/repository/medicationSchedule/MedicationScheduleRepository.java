package app.repository.medicationSchedule;

import app.model.entity.medicationSchedule.MedicationSchedule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface MedicationScheduleRepository extends JpaRepository<MedicationSchedule, UUID> {
    Optional<MedicationSchedule> findMedicationScheduleByMedication_Id(UUID medicationId);

    List<MedicationSchedule> findAllByDogId(UUID dogId);
}
