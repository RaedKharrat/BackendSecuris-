package tn.zeros.smg.services;

import tn.zeros.smg.entities.Payroll;
import tn.zeros.smg.repositories.PayrollRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PayrollService {
    private final PayrollRepository repository;

    public PayrollService(PayrollRepository repository) {
        this.repository = repository;
    }

    public List<Payroll> findAll() {
        return repository.findAll();
    }

    public Payroll findById(Long id) {
        return repository.findById(id).orElseThrow(() -> new RuntimeException("Payroll not found"));
    }

    public List<Payroll> findByUserId(Long userId) {
        return repository.findByUserId(userId);
    }

    public Payroll save(Payroll payroll) {
        return repository.save(payroll);
    }

    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}
