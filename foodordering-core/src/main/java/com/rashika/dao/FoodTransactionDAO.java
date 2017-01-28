package com.rashika.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;

import com.rashika.model.Food;
import com.rashika.model.FoodTransaction;
import com.rashika.model.Seats;
import com.rashika.util.ConnectionUtil;

public class FoodTransactionDAO {

	private final JdbcTemplate jdbcTemplate = ConnectionUtil.getJdbcTemplate();

	/**
	 * TO INSERT A RECORD INTO THE FoodTransaction RELATION.
	 * 
	 * @param foodtransaction
	 */
	public void save(final FoodTransaction foodtransaction) {
		final String sql = "insert into food_transaction(order_no,seat_no,food_id,quantity) values (?,?,?,?)";
		final Object[] params = {foodtransaction.getOrderNo(), foodtransaction.getSeatNo().getId(), foodtransaction.getFoodId().getId(), foodtransaction.getQuantity() };
		final int rows = jdbcTemplate.update(sql, params);
		System.out.println(rows);
	}

	/**
	 * TO UPDATE A RECORD IN THE FoodTransaction RELATION.
	 * 
	 * @param foodtransaction
	 */
	public void update(final FoodTransaction foodtransaction) {
		final String sql = "update food_transaction set quantity=? where order_no=? ";
		final Object[] params = { foodtransaction.getQuantity(), foodtransaction.getOrderNo() };
		final int rows = jdbcTemplate.update(sql, params);
		System.out.println(rows);
	}

	/**
	 * TO DELETE A RECORD FROM THE FoodTransaction RELATION.
	 * 
	 * @param foodtransaction
	 */
	public void delete(final int id) {
		final String sql = "delete from food_transaction where order_no=?";

		final int rows = jdbcTemplate.update(sql, id);
		System.out.println(rows);

	}

	/**
	 * TO VIEW ALL THE ITEMS WITH THEIR FROM FROM THE FoodTransaction RELATION.
	 * 
	 * @param foodtransaction
	 */
	public List<FoodTransaction> list() {
		final String sql = "select order_no,seat_no,food_id,quantity,order_status,date_of_order,bill_status from food_transaction";
		return jdbcTemplate.query(sql, (rs, rowNum) -> {
			final FoodTransaction foodtransaction = convert(rs);
			return foodtransaction;

		});
	}

	static FoodTransaction convert(final ResultSet rs) throws SQLException {
		final FoodTransaction foodtransaction = new FoodTransaction();
		foodtransaction.setOrderNo(rs.getInt("order_no"));
		Seats seat=new Seats();
		seat.setId(rs.getInt("seat_no"));
		foodtransaction.setSeatNo(seat);
		Food food=new Food();
		food.setId(rs.getInt("food_id"));
		foodtransaction.setFoodId(food);
		foodtransaction.setQuantity(rs.getInt("quantity"));
		foodtransaction.setOrderStatus(rs.getString("order_status"));
		foodtransaction.setorderDate(rs.getTimestamp("date_of_order").toLocalDateTime());
		foodtransaction.setBillStatus(rs.getString("bill_status"));



		return foodtransaction;
	}

}