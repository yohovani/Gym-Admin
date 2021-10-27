package com.yoho.gimnasios.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity(name = "pagos")
@Table(name = "pagos")
public class Payment {
    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    private Long id;
    private Double monto;

    @Column(
            name = "fecha_pago",
            nullable = false,
            columnDefinition = "DATETIME DEFAULT NOW()"
    )
    private LocalDateTime payment_date;

    @ManyToOne
    @JoinColumn(name = "tipo_pago_id", nullable = false)
    private PaymentType paymentType;

    @ManyToMany(cascade = CascadeType.ALL, mappedBy = "pagos")
    @JsonIgnore
    private Set<User> usuarios = new HashSet<>();

    public Payment() {
        this.payment_date = LocalDateTime.now();
    }

    public Payment(Double monto) {
        this.monto = monto;
        this.payment_date = LocalDateTime.now();
    }

    public Payment(Long id, Double monto) {
        this.id = id;
        this.monto = monto;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getMonto() {
        return monto;
    }

    public void setMonto(Double monto) {
        this.monto = monto;
    }

    public PaymentType getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(PaymentType paymentType) {
        this.paymentType = paymentType;
    }

    public Set<User> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(Set<User> usuarios) {
        this.usuarios = usuarios;
    }

    public LocalDateTime getPayment_date() {
        return payment_date;
    }

    public void setPayment_date(LocalDateTime payment_date) {
        this.payment_date = payment_date;
    }
}
