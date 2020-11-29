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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
@Table(name = "flight_tb")
public class Flight {

	@Id
	@Column(name = "flightId")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer flightId;

	@ManyToOne
	@JoinColumn(name = "airlineId")
	private Airlines airlines;

	@ManyToOne
	@JoinColumn(name = "sourcePlaceId")
	private Places sourcePlace;

	@ManyToOne
	@JoinColumn(name = "destinationPlaceId")
	private Places destinationPlace;

	@NotEmpty
	@Size(max = 200, min = 1, message = "Maximum length is excedded")
	@Column(name = "price")
	private String price;

	@Column(name = "arrivalDate")
	@Temporal(TemporalType.DATE)
	private Date arrivalDate;

	@Column(name = "createdBy")
	private Integer createdBy;
	@Column(name = "createdOn")
	private Date createdOn;
	@Column(name = "updatedBy")
	private Integer updatedBy;
	@Column(name = "updatedOn")
	private Date updatedOn;
	@OneToMany(fetch = FetchType.EAGER)
	@JoinColumn(name = "flightId")
	private Set<BookingDetail> booking;

	@Override
	public String toString() {
		return "Flight [flightId=" + flightId + ", airlines=" + airlines + ", sourcePlace=" + sourcePlace
				+ ", destinationPlace=" + destinationPlace + ", price=" + price + ", arrivalDate=" + arrivalDate
				+ ", createdBy=" + createdBy + ", createdOn=" + createdOn + ", updatedBy=" + updatedBy + ", updatedOn="
				+ updatedOn + "]";
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

	public Integer getFlightId() {
		return flightId;
	}

	public void setFlightId(Integer flightId) {
		this.flightId = flightId;
	}

	public Airlines getAirlines() {
		return airlines;
	}

	public void setAirlines(Airlines airlines) {
		this.airlines = airlines;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public Date getArrivalDate() {
		return arrivalDate;
	}

	public void setArrivalDate(Date arrivalDate) {
		this.arrivalDate = arrivalDate;
	}

	public Places getSourcePlace() {
		return sourcePlace;
	}

	public void setSourcePlace(Places sourcePlace) {
		this.sourcePlace = sourcePlace;
	}

	public Places getDestinationPlace() {
		return destinationPlace;
	}

	public void setDestinationPlace(Places destinationPlace) {
		this.destinationPlace = destinationPlace;
	}

	public Set<BookingDetail> getBooking() {
		return booking;
	}

	public void setBooking(Set<BookingDetail> booking) {
		this.booking = booking;
	}
}
