package com.example.demo.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
@Entity
public class User {
	  @Column
		String name;
	    @Column
		String userName;
	    @Column
		String password;
	    @Column
		String age;
}
