package com.github.ibrahimahmads.clinicmanagementsystem.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.*;
import org.hibernate.annotations.UuidGenerator;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "m_docter")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Docter extends BaseEntity{
    @Id
    @GeneratedValue
    @UuidGenerator
    private UUID id;
    private String nameDocter;
    private String specialization;
    private String phoneNumber;
    private String address;

    @NotBlank(message = "Email can not be empty")
    @Pattern(regexp = "^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$", message = "Email is not valid")
    private  String email;

    @OneToMany(mappedBy = "docter")
    @JsonIgnoreProperties("docter")
    private List<Schedule> scheduleList = new ArrayList<>();
}
