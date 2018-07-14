package com.example.demo.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class TicketDetails {

	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	Long ticketId;
	   @Column
		String trainName;
	    @Column
		String sourceStation;
	    @Column
		String destinationStation;
	    @Column
		String name;
	    @Column
		String age;
		public Long getTicketId() {
			return ticketId;
		}
		public void setTicketId(Long ticketId) {
			this.ticketId = ticketId;
		}
		public String getTrainName() {
			return trainName;
		}
		public void setTrainName(String trainName) {
			this.trainName = trainName;
		}
		public String getSourceStation() {
			return sourceStation;
		}
		public void setSourceStation(String sourceStation) {
			this.sourceStation = sourceStation;
		}
		public String getDestinationStation() {
			return destinationStation;
		}
		public void setDestinationStation(String destinationStation) {
			this.destinationStation = destinationStation;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public String getAge() {
			return age;
		}
		public void setAge(String age) {
			this.age = age;
		}
	    
	    
}
