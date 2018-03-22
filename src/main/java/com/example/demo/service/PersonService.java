package com.example.demo.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.domain.Address;
import com.example.demo.domain.Person;
import com.example.demo.form.RegisterForm;
import com.example.demo.repository.AddressRepository;
import com.example.demo.repository.PersonRepository;
import com.example.demo.utility.SMTPMailSender;


@Service
public class PersonService {
	@Autowired
	PersonRepository personRepository;
	
	@Autowired
	AddressRepository addressRepository;
	
	@Autowired
	SMTPMailSender sender;
	
	public Map<String, Object> savePerson(RegisterForm registerForm) {
		Map<String,Object> result = new HashMap<>();
		Address address = registerForm.copyAddress();
		Person person = registerForm.copyPerson();
		if(!isUserExists(person)) {
			address = addressRepository.save(address);
			person.setAddress(address);
			person = personRepository.save(person);
	        result.put("person", person);	
	        result.put("address", address);
	        sender.send(person.getEmailId(), "Verify User",
					"http://localhost:8080/verify/user" + "?" + "token" + "=" + "100");
		result.put("mail", "mail is send");
		}else {
			result.put("error", "User already exists");
		}
        return result;
	}
	
	
	public boolean isUserExists(Person person) {
		boolean userExists = false;
		if(!userExists) {
			Person person1 = personRepository.findByEmailId(person.getEmailId());
			if(person1 != null) {
				userExists = true;
			}
		}
		return userExists;
	}
	
	public Map<String,Object> getUser(Long id) {
		Map<String,Object> result = new HashMap<>();
		Person person = personRepository.findOne(id);
		result.put("person", person);
		return result;
	}
	
	public Map<String, Object> findUser(String searchKeyWord) {
		Map<String,Object> result = new HashMap<>();
		List<Person> personList = new ArrayList<Person>();
		List<Address> addressList = addressRepository.findByState(searchKeyWord);
		for(Address address:addressList) {
			Person person = personRepository.findByAddress(address);
			personList.add(person);
		}
		result.put("personList", personList);
		return result;
	}
	
	public void verifyUser() {
		
	}
}
