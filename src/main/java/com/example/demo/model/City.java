package com.example.demo.model;

import jakarta.persistence.Convert;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import org.hibernate.type.SqlTypes;
import org.postgresql.geometric.PGpoint;

import com.example.demo.PGpointType;

import org.hibernate.annotations.JdbcTypeCode;

import lombok.Data;

import java.io.Serializable;

@Data
@Entity
@Convert(attributeName = "point", converter = PGpointType.class)
//@TypeDef(name = "point", typeClass = PGpointType.class)
@Table(name = "cities")
public class City implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = -2531814140973780580L;

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    //@Type(type = "point")
    @JdbcTypeCode(SqlTypes.POINT)
    private PGpoint location;

	public String getName() {
		return name;
	}

	public void setName(String name2) {
		name = name2;
	}

	public PGpoint getLocation() {
		return location;
	}

	public void setLocation(PGpoint location2) {
		location= location2;	
	}

}
