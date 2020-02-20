package com.distribuida.model;

import java.io.Serializable;
import java.util.Date;
import java.util.Map;

import javax.persistence.*;

import lombok.Data;

@Data
@Entity
@Table(name = "album")
public class Album implements Serializable {

	private static final long serialVersionUID = 1L;

	@Column(name = "id") @Id private Integer id;
	@Column(name = "singer_id") private Integer singerId;
	@Column(name = "title") private String title;
	@Column(name = "release_date") private Date releaseDate;
	
	public Album() {
		
	}
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getSingerId() {
		return singerId;
	}

	public void setSingerId(Integer singerId) {
		this.singerId = singerId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Date getReleaseDate() {
		return releaseDate;
	}

	public void setReleaseDate(Date releaseDate) {
		this.releaseDate = releaseDate;
	}

	public static Album fromMap( Map<String, Object> obj ) {
		Album p = new Album( );
		
		p.setId( (Integer )obj.get("id") );
		p.setSingerId((Integer)obj.get("singer_id"));
		p.setTitle( (String )obj.get("title"));
		p.setReleaseDate( (Date)obj.get("release_date") );
		//p.setPost( (String)obj.get("post") );
		//p.setComment( (String)obj.get("comment") );
		
		return p;
	}
	
	
}
