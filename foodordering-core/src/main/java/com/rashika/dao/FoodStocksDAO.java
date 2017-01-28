package com.rashika.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;

import com.rashika.model.Food;
import com.rashika.model.FoodStocks;
import com.rashika.model.FoodType;
import com.rashika.util.ConnectionUtil;

public class FoodStocksDAO {

	private final JdbcTemplate jdbcTemplate = ConnectionUtil.getJdbcTemplate();

	/**
	 * TO INSERT A RECORD INTO THE FoodStocks RELATION.
	 * 
	 * @param foodstocks
	 */
	public void save(final FoodStocks foodstocks) {
		final String sql = "insert into food_stocks(sno,mealid,foodid,quantity) values (?,?,?,?)";
		final Object[] params = { foodstocks.getSno(), foodstocks.getMealid(), foodstocks.getFoodid(), foodstocks.getQuantity() };
		final int rows = jdbcTemplate.update(sql, params);
		System.out.println(rows);
	}

	/**
	 * TO UPDATE A RECORD IN THE FoodStocks RELATION.
	 * 
	 * @param foodstocks
	 */
	public void update(final FoodStocks foodstocks) {
		final String sql = "update food_stocks set quantity=? where sno=? ";
		final Object[] params = { foodstocks.getQuantity(), foodstocks.getSno() };
		final int rows = jdbcTemplate.update(sql, params);
		System.out.println(rows);
	}

	/**
	 * TO DELETE A RECORD FROM THE FoodStocks RELATION.
	 * 
	 * @param foodstocks
	 */
	public void delete(final int id) {
		final String sql = "delete from food_stocks where sno=?";

		final int rows = jdbcTemplate.update(sql, id);
		System.out.println(rows);

	}

	/**
	 * TO VIEW ALL THE ITEMS WITH THEIR FROM FROM THE FoodStocks RELATION.
	 * 
	 * @param foodstocks
	 */
	public List<FoodStocks> list() {
		final String sql = "select sno,mealid,foodid,quantity from food_stocks";
		return jdbcTemplate.query(sql, (rs, rowNum) -> {
			final FoodStocks foodstocks = convert(rs);
			return foodstocks;

		});
	}

	static FoodStocks convert(final ResultSet rs) throws SQLException {
		final FoodStocks foodstocks = new FoodStocks();
		foodstocks.setSno(rs.getInt("sno"));
		FoodType foodtype= new FoodType();
	    foodtype.setId(rs.getInt("mealid"));
		foodstocks.setMealid(foodtype);
		Food food=new Food();
		food.setId(rs.getInt("foodid"));
		foodstocks.setFoodid(food);
	
		foodstocks.setQuantity(rs.getInt("quantity"));


		return foodstocks;
	}

}