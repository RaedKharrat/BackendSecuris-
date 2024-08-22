package tn.zeros.smg.repositories;

import tn.zeros.smg.entities.Absence;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AbsenceRepository extends JpaRepository<Absence, Long> {
    List<Absence> findByUserId(Long userId);
}
