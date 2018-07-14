package com.example.demo.service;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.example.demo.domain.Address;
import com.example.demo.domain.Person;
import com.example.demo.domain.TicketDetails;
import com.example.demo.domain.Train;
import com.example.demo.form.BookForm;
import com.example.demo.form.LoginForm;
import com.example.demo.form.RegisterForm;
import com.example.demo.form.StationForm;
import com.example.demo.repository.AddressRepository;
import com.example.demo.repository.PersonRepository;
import com.example.demo.repository.TrainRepository;
import com.example.demo.utility.SMTPMailSender;


@Service
public class PersonService {
	@Autowired
	PersonRepository personRepository;
	
	@Autowired
	TrainRepository trainRepository;
	
	@Autowired
	AddressRepository addressRepository;
	
	@Autowired
	SMTPMailSender sender;
	
	@Value("${mypath}") 
    String mypath;
	
/*	public Map<String, Object> savePerson(RegisterForm registerForm) {
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
	}*/
	
	public Map<String,Object> loginPerson(LoginForm loginForm){
		Map<String,Object> result = new HashMap<>();
		Person person = personRepository.findByUserName(loginForm.getUserName());
        if(person != null) {
        	String password = loginForm.getPassword();
        	String savedPassword = person.getPassword();
        	if(password.equals(savedPassword)) {
        		result.put("success", "Login Successful");
        	}else {
            	result.put("error", "Password is incorrect");
        	}
        }else {
        	result.put("error", "User does not exists");
        }
        return result;
	}
	
	public Map<String,Object> registerPerson(RegisterForm registerForm){
		Map<String,Object> result = new HashMap<>();
		Person person1 = new Person();
		person1.setAge(registerForm.getUserName());
		person1.setName(registerForm.getName());
		person1.setPassword(registerForm.getPassword());
		person1.setUserName(registerForm.getUserName());
		if(isUserExists(person1)) {
	    	result.put("error", "user already registered");
            return result;
		}
	    Person	person = personRepository.save(person1);
	    if(person != null) {
	        result.put("person", person);
	        result.put("success", "registered successfully");
	    }else {
	    	result.put("error", "can not be registered");
	    }
        return result;
	}
	
	
	public boolean isUserExists(Person person) {
		boolean isUserExists = false;
		Person person1 = personRepository.findByUserName(person.getUserName());
		if(person1 != null) {
			isUserExists = true;
		}
		return isUserExists;
	}
	
	public Map<String,Object> searchTrain(StationForm stationForm){
		Map<String,Object> result = new HashMap<>();
		List<Train> trainList1 = trainRepository.findByStoppageStations(stationForm.getSourceStation());
		List<Train> trainList2 = trainRepository.findByStoppageStations(stationForm.getDestinationStation());
        List<Train> finalList = new ArrayList<>();
        for(Train t1: trainList1) {
        	if(trainList2.contains(t1)) {
        		finalList.add(t1);
        	}
        }
        result.put("TrainList", finalList);
        if(finalList.isEmpty()) {
        	result.put("error", "train not found");
        }
		return result;
	}
	
	
	public Map<String,Object> bookTicket(BookForm bookForm){
		Map<String,Object> result = new HashMap<>();
		TicketDetails ticketDetails = new TicketDetails();
		ticketDetails.setAge(bookForm.getAge());
		ticketDetails.setDestinationStation(bookForm.getDestinationStation());
		ticketDetails.setName(bookForm.getName());
		ticketDetails.setSourceStation(bookForm.getSourceStation());
		ticketDetails.setTrainName(bookForm.getTrainName());
		
        return result;
	}
	
	
	
	
	
	
	
	
	
	
	
	/*public boolean isUserExists(Person person) {
		boolean userExists = false;
		if(!userExists) {
			Person person1 = personRepository.findByEmailId(person.getEmailId());
			if(person1 != null) {
				userExists = true;
			}
		}
		return userExists;
	}*/
	
	/*public Map<String,Object> getUser(Long id) {
		Map<String,Object> result = new HashMap<>();
		Person person = personRepository.findOne(id);
		result.put("person", person);
		return result;
	}*/
	
	/*public Map<String, Object> findUser(String searchKeyWord) {
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
	
     public Map<String, Object> downloadFile(String urlString ) {
    	 Map<String,Object> result = new HashMap<>();
		File file = new File(mypath+"/label.gif");
		  URL url;
		try {
			  String urlArray[] = urlString.split("X-Amz-Security-Token");
			  String encodeParam=null;
			try {
				encodeParam = URLEncoder.encode(urlArray[1], "UTF-8");
			} catch (UnsupportedEncodingException e1) {
				e1.printStackTrace();
			}
			  urlString = urlArray[0]+"X-Amz-Security-Token"+encodeParam;
			url = new URL(urlString);
	        BufferedInputStream bis;
			try {
				HttpURLConnection connection = (HttpURLConnection) url.openConnection();
				connection.setRequestMethod("GET");
		        connection.setDoOutput(true);
		        connection.connect();
				bis = new BufferedInputStream(connection.getInputStream());
				  FileOutputStream fos = new FileOutputStream(file);
			        byte[] buffer = new byte[1024];
			        int count=0;
			        while((count = bis.read(buffer,0,1024)) != -1)
			        {
			            fos.write(buffer, 0, count);
			        }
			        fos.close();
			        bis.close();
			} catch (IOException e) {
				e.printStackTrace();
				result.put("error", e.toString());
			}
	      
		} catch (MalformedURLException e) {
			e.printStackTrace();
			result.put("error", e.toString());
		}
		result.put("responseMessage", "success");
		return result;
	}
	
	public void verifyUser() {
		
	}*/
}
