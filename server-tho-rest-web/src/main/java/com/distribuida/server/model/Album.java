package com.distribuida.server.model;

import java.io.Serializable;
import java.util.Date;

public class Album implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private Integer singerId;
	private String title;
	private Date releaseDate;
	
	public Album(Integer id, Integer singerId, String title, Date releaseDate) {
		this.id = id;
		this.singerId = singerId;
		this.title = title;
		this.releaseDate = releaseDate;
	}

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

	@Override
	public String toString() {
		return "Album [id=" + id + ", singerId=" + singerId + ", title=" + title + ", releaseDate=" + releaseDate + "]";
	}	

}
