package tn.zeros.smg.services;

import tn.zeros.smg.entities.StageRequest;
import tn.zeros.smg.entities.StageStatus;
import tn.zeros.smg.repositories.StageRequestRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StageRequestService {
    private final StageRequestRepository repository;

    public StageRequestService(StageRequestRepository repository) {
        this.repository = repository;
    }

    public List<StageRequest> findAll() {
        return repository.findAll();
    }

    public StageRequest findById(Long id) {
        return repository.findById(id).orElseThrow(() -> new RuntimeException("Stage request not found"));
    }

    public List<StageRequest> findByUserId(Long userId) {
        return repository.findByUserId(userId);
    }

    public StageRequest save(StageRequest stageRequest) {
        return repository.save(stageRequest);
    }

    public StageRequest approveStage(Long id) {
        StageRequest stageRequest = findById(id);
        stageRequest.setStatus(StageStatus.APPROVED);
        return repository.save(stageRequest);
    }

    public StageRequest rejectStage(Long id) {
        StageRequest stageRequest = findById(id);
        stageRequest.setStatus(StageStatus.REJECTED);
        return repository.save(stageRequest);
    }

    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}
