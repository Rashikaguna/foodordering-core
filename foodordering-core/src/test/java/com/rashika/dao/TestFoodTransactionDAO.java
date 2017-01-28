package com.rashika.dao;


import java.util.Iterator;
import java.util.List;

import com.rashika.model.FoodTransaction;

public class TestFoodTransactionDAO {

	public static void main(final String[] args) {

		FoodTransactionDAO foodtransactionDAO = new FoodTransactionDAO();
		
		

	
        

	 //foodtransactionDAO.save(foodtransaction);
	// foodtransactionDAO.delete(5);
		
	List<FoodTransaction> list=foodtransactionDAO.list();
	Iterator i=list.iterator();
	while(i.hasNext())
	{
		FoodTransaction foodtransaction = (FoodTransaction) i.next();
		System.out.println(foodtransaction.getOrder_no()+"\t"+foodtransaction.getSeat_no().getId()+"\t"+foodtransaction.getFood_id().getId()
				+"\t"+foodtransaction.getQuantity()+"\t"+foodtransaction.getOrder_status()+"\t"+foodtransaction.getDate_of_order()+"\t"+foodtransaction.getBill_status());
		
	}
	
		
	}

}
