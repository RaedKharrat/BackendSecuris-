package tn.zeros.smg.controllers.DTO;

import lombok.Data;
import tn.zeros.smg.entities.LeaveStatus;
import tn.zeros.smg.entities.LeaveType;

import java.time.LocalDate;

@Data
public class LeaveRequestDTO {
    private Long userId;
    private LeaveType type;
    private LocalDate startDate;
    private LocalDate endDate;
    private LeaveStatus status;
    private int daysAccrued;
}
