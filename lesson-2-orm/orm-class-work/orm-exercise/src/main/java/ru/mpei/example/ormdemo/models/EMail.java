package ru.mpei.example.ormdemo.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import jakarta.persistence.*;

@Data
@Entity
@Table(name = "e_mail")
@NoArgsConstructor
@AllArgsConstructor
public class EMail {
    @Id
    private long id;

    @Column(name = "mail")
    private String email;


}
