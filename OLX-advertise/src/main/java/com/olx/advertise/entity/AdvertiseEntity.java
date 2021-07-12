package com.olx.advertise.entity;


import java.time.LocalDate;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="advertises")
public class AdvertiseEntity {
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	private long id;
	private String title;
	private String description;
	private double price;
	private long category;
	@Column(name="created_date")
	private Date createdDate;
	@Column(name="modified_date")
	private LocalDate modifiedDate;
	private String active;
	@Column(name="username")
	private String username;
	public AdvertiseEntity(String title, String description, double price, long category, Date createdDate,
			LocalDate modifiedDate, String active, String username) {
		super();
		this.title = title;
		this.description = description;
		this.price = price;
		this.category = category;
		this.createdDate = createdDate;
		this.modifiedDate = modifiedDate;
		this.active = active;
		this.username = username;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public long getCategory() {
		return category;
	}
	public void setCategory(long category) {
		this.category = category;
	}
	public Date getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(Date date) {
		this.createdDate = date;
	}
	public LocalDate getModifiedDate() {
		return modifiedDate;
	}
	public void setModifiedDate(LocalDate modifiedDate) {
		this.modifiedDate = modifiedDate;
	}
	public String getActive() {
		return active;
	}
	public void setActive(String active) {
		this.active = active;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public AdvertiseEntity(Long long1, String string, Long long2, Double double1, String string2, String string3, Object object, Object object2, Long long3) {
		super();
	}
	@Override
	public String toString() {
		return "AdvertiseEntity [id=" + id + ", title=" + title + ", description=" + description + ", price=" + price
				+ ", category=" + category + ", createdDate=" + createdDate + ", modifiedDate=" + modifiedDate
				+ ", active=" + active + ", username=" + username + "]";
	}
	
	
	
}