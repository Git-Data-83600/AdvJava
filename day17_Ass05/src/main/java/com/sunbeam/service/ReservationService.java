package com.sunbeam.service;

import com.sunbeam.dto.ResrvationReqDTO;

//1.Create Reservation:
//•	Endpoint: POST /reservations
//•	Request:JSON payload containing reservation details (guest name, check-in date, check-out date, room ID).
//•	Response: Confirmation of the created reservation.

public interface ReservationService {
	
	public String createReservation(ResrvationReqDTO dto);
}
