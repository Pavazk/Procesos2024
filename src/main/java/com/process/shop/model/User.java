package com.process.shop.model;

import com.process.shop.model.enunm.DocumentType;
import jakarta.persistence.*;
import lombok.Builder;
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
    private String fullName;
    private LocalDate birthDay;
    private DocumentType typeIdentification;
    private String identification;
    private String phone;
    private String email;
    private String password;
    @OneToMany(mappedBy = "user")
    private List<Address> address;
}
