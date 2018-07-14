package com.example.demo.repository;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.example.demo.domain.Train;

@Repository
public interface TrainRepository extends JpaRepository<Train, Serializable> {

	 @Query("SELECT t from Train t where t.stoppageStations = :station")
	public List<Train> findByStoppageStations(@Param(value = "station") String station);

}
