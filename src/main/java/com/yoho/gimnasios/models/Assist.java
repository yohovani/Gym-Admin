package com.yoho.gimnasios.models;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity(name="asistencias")
@Table(name="asistencias")
public class Assist {
    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    private Long id;
    @Column(
            name = "fecha_assistencia",
            nullable = false,
            columnDefinition = "DATETIME DEFAULT NOW()"
    )
    private LocalDateTime assist_date;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "asistencias")
    private Set<User> usuarios = new HashSet<>();

    public Assist() {
        this.assist_date = LocalDateTime.now();
    }

    public Assist(LocalDateTime assist_date) {
        this.assist_date = assist_date;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getAssist_date() {
        return assist_date;
    }

    public void setAssist_date(LocalDateTime assist_date) {
        this.assist_date = assist_date;
    }
}
