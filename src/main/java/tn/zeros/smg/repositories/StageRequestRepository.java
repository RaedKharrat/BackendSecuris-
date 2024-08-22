package tn.zeros.smg.repositories;

import tn.zeros.smg.entities.StageRequest;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StageRequestRepository extends JpaRepository<StageRequest, Long> {
    List<StageRequest> findByUserId(Long userId);
}
