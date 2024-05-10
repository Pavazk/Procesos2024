package com.process.shop.model;

import com.process.shop.model.enunm.DocumentType;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@NoArgsConstructor
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank(message = "Please provide the fullName")
    private String fullName;
    private LocalDate birthDay;
    private DocumentType typeIdentification;
    @NotBlank(message = "Please provide the identification")
    @Size(min = 7, max = 10)
    private String identification;
    private String phone;
    @NotBlank(message = "Please provide the email")
    @Email(message = "Please provide valid email")
    private String email;
    @NotBlank(message = "Please provide the password")
    @Size(min = 8, max = 15)
    private String password;
    @OneToMany(mappedBy = "user")
    private List<Address> address;
}
