package com.yoho.gimnasios.models;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.Period;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity(name="usuarios")
@Table(name="usuarios")
public class User {
    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    @Column(
            nullable = false,
            updatable = false
    )
    private Long id;
    @Column(
            name = "nombre",
            columnDefinition = "varchar(50)"
    )
    private String name;
    @Column(
            name = "apellidos",
            columnDefinition = "varchar(80)"
    )
    private String last_name;
    @Column(
            name = "fecha_nacimiento",
            columnDefinition = "Date",
            nullable = false
    )
    private LocalDate date_bird;
    @Column(
            name = "edad",
            columnDefinition = "int"
    )
    private int age;

    @ManyToMany(
            fetch = FetchType.LAZY,
            cascade = CascadeType.ALL
    )
    @JoinTable(
            name = "usuario_asistencia",
            joinColumns = {@JoinColumn(name = "usuario_id")},
            inverseJoinColumns = {@JoinColumn(name = "asistencia_id")}
    )
    private Set<Assist> asistencias = new HashSet<>();

    @ManyToMany(
            fetch = FetchType.LAZY,
            cascade = CascadeType.ALL
    )
    @JoinTable(
            name = "usuario_pagos",
            joinColumns = {@JoinColumn(name = "usuario_id")},
            inverseJoinColumns = {@JoinColumn(name = "pago_id")}
    )
    private Set<Payment> pagos = new HashSet<>();


    public User(){}

    public User(String name, String last_name) {
        this.name = name;
        this.last_name = last_name;
    }

    public User(String name, String last_name, LocalDate date_bird) {
        this.name = name;
        this.last_name = last_name;
        this.date_bird = date_bird;
        this.setAge();
    }

    public User(String name, String last_name, LocalDate date_bird, int age) {
        this.name = name;
        this.last_name = last_name;
        this.date_bird = date_bird;
        this.age = age;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public LocalDate getDate_bird() {
        return date_bird;
    }

    public void setDate_bird(LocalDate date_bird) {
        this.date_bird = date_bird;
    }

    public int getAge() {
        return Period.between(date_bird, LocalDate.now()).getYears();
    }

    public void setAge() {
        this.age = Period.between(date_bird, LocalDate.now()).getYears();
    }

    public Collection<Assist> getAsistencias() {
        return asistencias;
    }

    public void setAsistencias(Set<Assist> asistencias) {
        this.asistencias = asistencias;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Set<Payment> getPagos() {
        return pagos;
    }

    public void setPagos(Set<Payment> pagos) {
        this.pagos = pagos;
    }
}
