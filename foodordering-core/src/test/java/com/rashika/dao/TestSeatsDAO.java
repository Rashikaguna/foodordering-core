package com.rashika.dao;

import com.rashika.model.Seats;

public class TestSeatsDAO {

	public static void main(String[] args) {

	SeatsDAO seatsDAO = new SeatsDAO();

	 Seats seats = new Seats();

		 seats.setSno(11);
		 seats.setId(11);
		 seats.setSeat_status("available");
		 seats.setAvailability(0);

		seatsDAO.save(seats);
		// seatsDAO.update(seats);
		// seatsDAO.delete(1);

	}
	
}
