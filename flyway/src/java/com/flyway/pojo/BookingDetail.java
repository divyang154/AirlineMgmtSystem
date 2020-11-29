package com.flyway.pojo;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "bookingdetail_tb")
public class BookingDetail {
	@Id
	@Column(name = "bookingId")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int bookingId;
	@Column(name = "paymentStatus")
	private String paymentStatus;
	@ManyToOne
	@JoinColumn(name = "sourcePlaceId")
	private Places sourcePlace;
	@ManyToOne
	@JoinColumn(name = "destinationPlaceId")
	private Places destinationPlace;
	@ManyToOne
	@JoinColumn(name = "flightId")
	private Flight flight;
	@ManyToOne
	@JoinColumn(name = "userId")
	private User user;
	@Column(name = "noOfPerson")
	private int noOfPerson;
	@Column(name = "createdBy")
	private Integer createdBy;
	@Column(name = "createdOn")
	private Date createdOn;
	@Column(name = "updatedBy")
	private Integer updatedBy;
	@Column(name = "updatedOn")
	private Date updatedOn;

	public int getBookingId() {
		return bookingId;
	}

	public void setBookingId(int bookingId) {
		this.bookingId = bookingId;
	}

	public String getPaymentStatus() {
		return paymentStatus;
	}

	public void setPaymentStatus(String paymentStatus) {
		this.paymentStatus = paymentStatus;
	}

	public Flight getFlight() {
		return flight;
	}

	public void setFlight(Flight flight) {
		this.flight = flight;
	}

	public int getNoOfPerson() {
		return noOfPerson;
	}

	public void setNoOfPerson(int noOfPerson) {
		this.noOfPerson = noOfPerson;
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

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
}
