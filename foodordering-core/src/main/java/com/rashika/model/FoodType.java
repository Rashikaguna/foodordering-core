package com.rashika.model;

import java.time.LocalTime;

import lombok.Data;

@Data
public class FoodType {
	private int id;
	private String meal;
	private int quantity;
	private LocalTime from_time;
	private LocalTime to_time;
	
}