package com.rashika.model;

import java.time.LocalDateTime;
import java.time.LocalTime;

import lombok.Data;

@Data
public class FoodTransaction {
	private int orderNo;
	private Seats seatNo;
    private Food foodId;
	private int quantity;
	private String orderStatus;
	private LocalDateTime OrderDate;
    private String billStatus;


}
