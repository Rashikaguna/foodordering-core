package com.rashika.dao;

import com.rashika.model.Food;

public class TestFoodDAO {

	public static void main(String[] args) {

		FoodDAO foodDAO = new FoodDAO();

	 Food food = new Food();

		 food.setId(18);
		 food.setFood_name("milk");

		 foodDAO.save(food);
		// foodDAO.update(food);
		//foodDAO.delete(1);

	}
	
}
