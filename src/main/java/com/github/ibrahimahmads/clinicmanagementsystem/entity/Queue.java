package com.github.ibrahimahmads.clinicmanagementsystem.entity;

import com.github.ibrahimahmads.clinicmanagementsystem.utils.enums.QueueStatus;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.UuidGenerator;

import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name = "t_queue")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Queue {
    @Id
    @GeneratedValue
    @UuidGenerator
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "docter_id")
    private Docter docter;

    @ManyToOne
    @JoinColumn(name = "patient_id")
    private Patient patient;

    private Integer queueNumber;

    @Enumerated(EnumType.STRING)
    private QueueStatus status;
    private LocalDate visitDate;
}
