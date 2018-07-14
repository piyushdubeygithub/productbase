package com.example.demo.domain;

import java.util.ArrayList;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;

@Entity
public class Train {
	
    @Column
	long trainNumber;
    @Column
	String trainName;
    @Column
	String sourceStation;
    @Column
	String destinationStation;
    
    @ElementCollection
    @CollectionTable(name ="stoppageStations")
	ArrayList<String> stoppageStations;
	
    
	public ArrayList<String> getStoppageStations() {
		return stoppageStations;
	}
	public void setStoppageStations(ArrayList<String> stoppageStations) {
		this.stoppageStations = stoppageStations;
	}
	public long getTrainNumber() {
		return trainNumber;
	}
	public void setTrainNumber(long trainNumber) {
		this.trainNumber = trainNumber;
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
	
	
}
