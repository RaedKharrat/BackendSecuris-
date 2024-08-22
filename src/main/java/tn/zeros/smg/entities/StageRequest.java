package tn.zeros.smg.entities;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class StageRequest {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private User user;

    private String cvUrl;

    @Enumerated(EnumType.STRING)
    private StageStatus status;
}
