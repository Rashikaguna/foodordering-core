package com.rashika.dao;

import org.springframework.jdbc.core.JdbcTemplate;

import com.rashika.model.Food;
import com.rashika.util.ConnectionUtil;

public class FoodDAO {

	JdbcTemplate jdbcTemplate = ConnectionUtil.getJdbcTemplate();

	public void save(Food food) {

		String sql = "insert into food(id,food_name) values(?,?)";
		Object[] params = { food.getId(), food.getFood_name() };
		int rows = jdbcTemplate.update(sql, params);
		System.out.println("No of rows inserted: " + rows);

	}

	public void update(Food food) {

		String sql = "update food set food_name=? where id=?";
		Object[] params = { food.getFood_name(), food.getId() };
		int rows = jdbcTemplate.update(sql, params);
		System.out.println("No of rows updated: " + rows);

	}

	public void delete(int id) {

		String sql = "delete from food where id=?";
		Object[] params = { id };
		int rows = jdbcTemplate.update(sql, params);
		System.out.println("No of rows deleted: " + rows);

	}

}
