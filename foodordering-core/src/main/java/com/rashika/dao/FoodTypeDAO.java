package com.rashika.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;

import com.rashika.model.FoodType;
import com.rashika.util.ConnectionUtil;

public class FoodTypeDAO {

	JdbcTemplate jdbcTemplate = ConnectionUtil.getJdbcTemplate();

	public void save(FoodType foodtype) {

		String sql = "insert into foodtype(id,meal,quantity,from_time,to_time) values(?,?,?,?,?)";
		Object[] params = { foodtype.getId(), foodtype.getMeal(),foodtype.getQuantity(),foodtype.getFrom_time(),foodtype.getTo_time() };
		int rows = jdbcTemplate.update(sql, params);
		System.out.println("No of rows inserted: " + rows);

	}

	public void update(FoodType foodtype) {

		String sql = "update foodtype set quantity=? where id=?";
		Object[] params = { foodtype.getQuantity(), foodtype.getId() };
		int rows = jdbcTemplate.update(sql, params);
		System.out.println("No of rows updated: " + rows);

	}

	public void delete(int id) {

		String sql = "delete from foodtype where id=?";
		Object[] params = { id };
		int rows = jdbcTemplate.update(sql, params);
		System.out.println("No of rows deleted: " + rows);

	}
	
	
	public List<FoodType> list() {
		final String sql = "select id,meal,quantity,from_time,to_time from foodtype";
		return jdbcTemplate.query(sql, (rs, rowNum) -> {
			final FoodType foodtype = convert(rs);
			return foodtype;
		});

	}

	static FoodType convert(final ResultSet rs) throws SQLException {
		final FoodType foodtype = new FoodType();
		foodtype.setId(rs.getInt("id"));
		foodtype.setMeal(rs.getString("meal"));
		foodtype.setQuantity(rs.getInt("quantity"));

		foodtype.setFrom_time(rs.getTime("from_time").toLocalTime());
		foodtype.setTo_time(rs.getTime("to_time").toLocalTime());
		return foodtype;
	}

}


