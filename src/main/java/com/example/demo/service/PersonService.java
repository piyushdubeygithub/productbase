package com.example.demo.service;

import java.util.HashMap;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.domain.Person;
import com.example.demo.repository.PersonRepository;
import com.example.demo.utility.SMTPMailSender;


@Service
public class PersonService {
	@Autowired
	PersonRepository personRepository;
	
	@Autowired
	SMTPMailSender sender;
	
	public Map<String, Object> savePerson(Person person) {
		Map<String,Object> result = new HashMap<>();
		if(!isUserExists(person)) {
			person = personRepository.save(person);
	        result.put("person", person);	
	        sender.send(person.getEmailId(), "Verify User",
					"http://localhost:8080/verify/user" + "?" + "token" + "=" + "100");
		result.put("mail", "mail is send");
		}else {
			result.put("error", "User already exists");
		}
        return result;
	}
	
	public boolean isUserExists(Person person) {
		boolean userExists = personRepository.exists(person.getId());
		if(!userExists) {
			Person person1 = personRepository.findByEmailId(person.getEmailId());
			if(person1 != null) {
				userExists = true;
			}
		}
		return userExists;
	}
	public void verifyUser() {
		
	}
}
