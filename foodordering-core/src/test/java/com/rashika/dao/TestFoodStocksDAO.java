package com.rashika.dao;

import java.util.Iterator;
import java.util.List;

import com.rashika.model.FoodStocks;
import com.rashika.model.FoodTransaction;

//import com.rashika.model.FoodStocks;

public class TestFoodStocksDAO {

	public static void main(final String[] args) {

	 FoodStocksDAO foodstocksDAO = new FoodStocksDAO();
		
	 
//	 FoodStocks foodstocks = new FoodStocks();

//	 foodstocks.setSno(17);
//	 foodstocks.setMealid(4);
//	 foodstocks.setFoodid(17);
//     foodstocks.setQuantity(300);
// 


//	 foodstocksDAO.save(foodstocks);
	// foodstocksDAO.delete(17);
	 
	 List<FoodStocks> list=foodstocksDAO.list();
		Iterator i=list.iterator();
		while(i.hasNext())
		{
			FoodStocks foodstocks = (FoodStocks) i.next();
			System.out.println(foodstocks.getSNo()+"\t"+foodstocks.getMealId().getId()+"\t"+foodstocks.getFoodId().getId()
					+"\t"+foodstocks.getQuantity());
			
		}
		
	}

}