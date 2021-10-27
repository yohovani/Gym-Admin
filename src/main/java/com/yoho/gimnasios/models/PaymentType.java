package com.yoho.gimnasios.models;

import javax.persistence.*;
import java.util.List;

@Entity(name ="tipos_pago")
@Table(name ="tipos_pago")
public class PaymentType {
    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    private Long id;
    @Column(
            name = "tipo",
            nullable = false,
            columnDefinition = "VARCHAR(150)"
    )
    private String type;

    @OneToMany(mappedBy="paymentType")
    private List<Payment> payments;

    public PaymentType() {
    }

    public PaymentType(String type) {
        this.type = type;
    }

    public PaymentType(Long id, String type) {
        this.id = id;
        this.type = type;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
