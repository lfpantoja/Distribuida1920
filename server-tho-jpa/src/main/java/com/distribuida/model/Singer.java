package com.distribuida.model;

import java.io.Serializable;
import java.util.Date;
import java.util.Map;

import javax.persistence.*;

import lombok.Data;

@Data
@Entity
@Table(name = "singer")
public class Singer implements Serializable {

	private static final long serialVersionUID = 1L;

	@Column(name = "id") @Id private Integer id;
	@Column(name = "first_name") private String firstName;
	@Column(name = "last_name") private String lastName;
	@Column(name = "birth_date") private Date birthDate;
	
	public Singer() {
		
	}
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	public static Singer fromMap( Map<String, Object> obj ) {
		Singer p = new Singer( );
		
		p.setId( (Integer )obj.get("id") );
		p.setFirstName( (String )obj.get("first_name"));
		p.setLastName( (String )obj.get("last_name"));
		p.setBirthDate( (Date)obj.get("birth_date") );
		//p.setPost( (String)obj.get("post") );
		//p.setComment( (String)obj.get("comment") );
		
		return p;
	}
	
	
}
