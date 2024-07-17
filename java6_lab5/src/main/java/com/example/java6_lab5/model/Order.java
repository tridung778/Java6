package com.example.java6_lab5.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@AllArgsConstructor
@Entity
@Data
@NoArgsConstructor
@Table(name = "orders")
public class Order implements Serializable {
    @Id
    UUID id = UUID.randomUUID();
    String address;
    @Temporal(TemporalType.DATE)
    @Column(name = "created_at")
    Date createdAt = new Date();
    @ManyToOne
    @JoinColumn(name = "account_id")
    Account account;
    @JsonIgnore
    @OneToMany(mappedBy = "order")
    List<OrderDetail> orderDetails;
}
