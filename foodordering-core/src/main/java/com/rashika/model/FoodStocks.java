package com.rashika.model;

import lombok.Data;

@Data

public class FoodStocks {
	private int sno;
	private FoodType mealid;
	private Food foodid;
	private int quantity;
}
