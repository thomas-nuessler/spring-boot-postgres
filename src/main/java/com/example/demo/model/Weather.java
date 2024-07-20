package com.example.demo.model;


import lombok.Data;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.io.Serializable;
import java.time.LocalDate;

@Data
@Entity
@Table(name = "weather")
public class Weather implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = 3318583474472947980L;

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String city;

    private Integer temp_hi;

    private Integer temp_lo;

    private Float prcp;

    @SuppressWarnings("unused")
	private Integer is_del;

    private LocalDate date;

	public void setDate(LocalDate now) {
		date = now;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city2) {
		city = city2;		
	}

	public Integer getTemp_hi() {
		return temp_hi;
	}

	public void setTemp_hi(Integer temp_hi2) {
		temp_hi = temp_hi2;	
	}

	public Integer getTemp_lo() {
		return temp_lo;
	}

	public void setTemp_lo(Integer temp_lo2) {
		temp_lo = temp_lo2;		
	}

	public Float getPrcp() {
		return prcp;
	}

	public void setPrcp(Float prcp2) {
		prcp =  prcp2;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setIs_del(int i) {
		is_del = i;
	}
}
