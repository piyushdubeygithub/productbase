package com.example.demo.repository;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.domain.Address;
@Repository
public interface AddressRepository extends JpaRepository<Address, Serializable>{
  List<Address> findByState(String state);
}
