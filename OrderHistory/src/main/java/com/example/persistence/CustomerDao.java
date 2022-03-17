package com.example.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.entity.Customer;

public interface CustomerDao extends JpaRepository<Customer, Integer> {

}
