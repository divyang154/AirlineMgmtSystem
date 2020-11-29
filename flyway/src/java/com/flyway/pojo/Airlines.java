package com.flyway.pojo;

import static javax.persistence.GenerationType.IDENTITY;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Length;
@Entity
@Table(name="airline_tb")
public class Airlines {

	@Id
	@Column(name="airlineId")
	private Integer airlineId;
	@Column(name="name")
	private String name;
	@Column(name="createdBy")
	private Integer createdBy;
	@Column(name="createdOn")
	private Date createdOn;
	@Column(name="updatedBy")
	private Integer updatedBy;
	@Column(name="updatedOn")
	private Date updatedOn;
	@OneToMany
	@JoinColumn(name="airlineId")
    private Set<Flight> sourcePlace = new HashSet<>();
	
	public int getAirlineId() {
		return airlineId;
	}
	public void setAirlineId(int airlineId) {
		this.airlineId = airlineId;
	}
	@NotEmpty
	@Size(max = 20, min = 3, message = "Maximum length is excedded")
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(Integer createdBy) {
		this.createdBy = createdBy;
	}
	public Date getCreatedOn() {
		return createdOn;
	}
	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
	}
	public Integer getUpdatedBy() {
		return updatedBy;
	}
	public void setUpdatedBy(Integer updatedBy) {
		this.updatedBy = updatedBy;
	}
	public Date getUpdatedOn() {
		return updatedOn;
	}
	public void setUpdatedOn(Date updatedOn) {
		this.updatedOn = updatedOn;
	}
	
}
