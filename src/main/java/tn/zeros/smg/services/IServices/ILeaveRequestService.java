package tn.zeros.smg.services.IServices;

import tn.zeros.smg.entities.LeaveRequest;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ILeaveRequestService extends JpaRepository<LeaveRequest, Long>{
}
