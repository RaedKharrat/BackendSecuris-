package tn.zeros.smg.services;

import tn.zeros.smg.entities.LeaveRequest;
import tn.zeros.smg.entities.LeaveStatus;
import tn.zeros.smg.repositories.LeaveRequestRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LeaveRequestService {
    private final LeaveRequestRepository repository;

    public LeaveRequestService(LeaveRequestRepository repository) {
        this.repository = repository;
    }

    public List<LeaveRequest> findAll() {
        return repository.findAll();
    }

    public LeaveRequest findById(Long id) {
        return repository.findById(id).orElseThrow(() -> new RuntimeException("Leave request not found"));
    }

    public List<LeaveRequest> findByUserId(Long userId) {
        return repository.findByUserId(userId);
    }

    public LeaveRequest save(LeaveRequest leaveRequest) {
        return repository.save(leaveRequest);
    }

    public LeaveRequest approveLeave(Long id) {
        LeaveRequest leaveRequest = findById(id);
        leaveRequest.setStatus(LeaveStatus.APPROVED);
        return repository.save(leaveRequest);
    }

    public LeaveRequest rejectLeave(Long id) {
        LeaveRequest leaveRequest = findById(id);
        leaveRequest.setStatus(LeaveStatus.REJECTED);
        return repository.save(leaveRequest);
    }

    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}
