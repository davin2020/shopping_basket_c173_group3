package com.example.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
@Entity
public class Customer {

    @Setter
    @Getter
    @Id

    private String customerId;

    @Setter
    @Getter
    @Column(nullable = false, unique = true)
    private String customerEmail;

    @Setter
    @Getter
    private String customerName;

    @Setter
    @Getter
    @Column(nullable = false, unique = true, length = 64)
    private String password;


}
