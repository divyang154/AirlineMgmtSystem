package com.flyway.pojo;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
@Table(name = "place_tb")
public class Places {

	@Id
	@Column(name = "placeId")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer placeId;
	@Column(name = "placeName")
	private String placeName;
	@Column(name = "createdBy")
	private Integer createdBy;
	@Column(name = "createdOn")
	private Date createdOn;
	@Column(name = "updatedBy")
	private Integer updatedBy;
	@Column(name = "updatedOn")
	private Date updatedOn;
	@OneToMany(fetch = FetchType.EAGER)
	@JoinColumn(name="placeId")
    private Set<Flight> sourceFlights;
	@OneToMany(fetch = FetchType.EAGER)
	@JoinColumn(name="placeId")
    private Set<Flight> destinationFlights;
	
	
	public Integer getPlaceId() {
		return placeId;
	}

	public Set<Flight> getSourcePlaces() {
		return sourceFlights;
	}

	public void setSourcePlaces(Set<Flight> sourcePlaces) {
		this.sourceFlights = sourcePlaces;
	}

	public Set<Flight> getDestinationFlights() {
		return destinationFlights;
	}

	public void setDestinationFlights(Set<Flight> destinationPlaces) {
		this.destinationFlights = destinationPlaces;
	}

	public void setPlaceId(Integer placeId) {
		this.placeId = placeId;
	}

	@NotEmpty
	@Size(max = 200, min = 3, message = "Maximum length is excedded")
	public String getPlaceName() {
		return placeName;
	}

	public void setPlaceName(String placeName) {
		this.placeName = placeName;
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

	public Places() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Places [placeId=" + placeId + ", placeName=" + placeName + ", createdBy=" + createdBy + ", createdOn="
				+ createdOn + ", updatedBy=" + updatedBy + ", updatedOn=" + updatedOn + "]";
	}

}
