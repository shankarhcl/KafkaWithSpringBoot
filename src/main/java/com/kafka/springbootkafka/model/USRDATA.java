package com.kafka.springbootkafka.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Lob;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Entity(name="USRDATA")
@NoArgsConstructor
@AllArgsConstructor
public class USRDATA {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private String usrData;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsrData() {
		return usrData;
	}

	public void setUsrData(String usrData) {
		this.usrData = usrData;
	}

	@Override
	public String toString() {
		return  usrData;
	}
	
	

}
