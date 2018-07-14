package com.example.demo.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.form.BookForm;
import com.example.demo.form.LoginForm;
import com.example.demo.form.RegisterForm;
import com.example.demo.form.StationForm;
import com.example.demo.service.PersonService;

@RestController
public class MainController {
	@Autowired
	PersonService personservice;
	
	@RequestMapping(value="/registerPerson", method= RequestMethod.POST)
	public Map<String,Object> registerPerson(@RequestBody RegisterForm registerForm) {
		  Map<String,Object> result = new HashMap<>();
		  //result = personservice.savePerson(registerForm);
		  result = personservice.registerPerson(registerForm);
		  return result;
	  }
	
	public Map<String,Object> loginPerson(@RequestBody LoginForm loginForm){
		Map<String,Object> result ;
		result = personservice.loginPerson(loginForm);
		return result;
	}
	
	public Map<String,Object> searchTrain(StationForm stationForm ){
		Map<String,Object> result ;
		result = personservice.searchTrain(stationForm);
        return result;
	}
	
	public Map<String,Object> bookTicket(BookForm bookForm ){
		Map<String,Object> result ;
		result = personservice.bookTicket(bookForm);
        return result;
	}

	
	
	/*@RequestMapping(value="/registerPerson", method= RequestMethod.POST)
  public Map<String,Object> registerPerson(@RequestBody RegisterForm registerForm) {
	  Map<String,Object> result = new HashMap<>();
	  result = personservice.savePerson(registerForm);
	  return result;
  }
	
	@RequestMapping(value="/verify/user", method= RequestMethod.GET)
	public Map<String,Object> verifyUser(@RequestParam String token) {
		  Map<String,Object> result = new HashMap<>();
           result.put("verified", "User is verified");
           return result;
	}
	
	@RequestMapping(value="/get/user", method= RequestMethod.GET)
	public Map<String,Object> getUser(@RequestParam Long id){
		Map<String,Object> result = new HashMap<>();
		result = personservice.getUser(id);
		return result;
	}
	
	@RequestMapping(value="/find/user", method= RequestMethod.GET)
	public Map<String,Object> findUser(@RequestParam String searchKeyWord){
		Map<String,Object> result = new HashMap<>();
		result = personservice.findUser(searchKeyWord);
		return result;
	}
	
	@RequestMapping(value="/download/file", method= RequestMethod.GET)
	public Map<String,Object> downloadFile(@RequestParam String urlString) {
		Map<String,Object> result = new HashMap<>();
		result = personservice.downloadFile(urlString);
        return result;
	}
*/
	}
