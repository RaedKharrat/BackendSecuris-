package tn.zeros.smg.services;

import tn.zeros.smg.entities.Absence;
import tn.zeros.smg.repositories.AbsenceRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AbsenceService {
    private final AbsenceRepository repository;

    public AbsenceService(AbsenceRepository repository) {
        this.repository = repository;
    }

    public List<Absence> findAll() {
        return repository.findAll();
    }

    public Absence findById(Long id) {
        return repository.findById(id).orElseThrow(() -> new RuntimeException("Absence not found"));
    }

    public List<Absence> findByUserId(Long userId) {
        return repository.findByUserId(userId);
    }

    public Absence save(Absence absence) {
        return repository.save(absence);
    }

    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}
