package com.rashika.dao;

import java.time.LocalTime;

import com.rashika.model.FoodType;

public class TestFoodTypeDAO {

	public static void main(final String[] args) {

	 FoodTypeDAO foodtypeDAO = new FoodTypeDAO();
		
	 
	 FoodType foodtype = new FoodType();

	 foodtype.setId(5);
	 foodtype.setMeal("midnight snacks");
	 foodtype.setQuantity(100);
	 foodtype.setFrom_time(LocalTime.parse("23:15:00"));
	 foodtype.setTo_time(LocalTime.parse("01:15:00"));


	 foodtypeDAO.save(foodtype);
	// foodtypeDAO.delete(5);
		
	}

}
