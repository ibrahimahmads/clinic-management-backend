package com.github.ibrahimahmads.clinicmanagementsystem.entity;

import com.github.ibrahimahmads.clinicmanagementsystem.utils.enums.Role;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.*;
import org.hibernate.annotations.UuidGenerator;

import java.util.UUID;

@Entity
@Table(name = "m_user")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Users extends BaseEntity{
    @Id
    @GeneratedValue
    @UuidGenerator
    private UUID id;
    @NotBlank(message = "Username cannot be empty")
    private String username;
    @Size(min = 5, message = "Minimum password length 8")
    @Pattern(regexp = ".*[A-Z].*", message = "Password must have 1 capital letter")
    private String password;
    @Enumerated(EnumType.STRING)
    private Role role;
}
