package com.sunbeam.entities;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

//•	Reservation:Reservation ID, guest id, check-in date, check-out date, room ID, total price.


@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "Reservation")

public class Reservation extends BaseEntity {
	@Column(name = "Check_In_Date")
	private LocalDate checkInDate;
	
	@Column(name = "Check_Out_Date")
	private LocalDate checkOutDate;
	
	@Column(name = "Total_Price")
	private double totalPrice;
	
	@ManyToOne
	@JoinColumn(name="guest_id",nullable = false)
	private Guest guest;
	
	@ManyToOne
	@JoinColumn(name="room_id",nullable = false)
	private Room room;
	
}
