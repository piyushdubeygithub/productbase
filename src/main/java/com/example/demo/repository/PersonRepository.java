package com.example.demo.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.domain.Address;
import com.example.demo.domain.Person;

@Repository
public interface PersonRepository extends JpaRepository<Person, Serializable>{
	
	 Person findByUserName(String userName);
}
