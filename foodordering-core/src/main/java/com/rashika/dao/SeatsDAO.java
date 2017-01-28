package com.rashika.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;

import com.rashika.model.Seats;
import com.rashika.util.ConnectionUtil;

public class SeatsDAO {

	private final JdbcTemplate jdbcTemplate = ConnectionUtil.getJdbcTemplate();

	/**
	 * TO INSERT A RECORD INTO THE SEATS RELATION.
	 * 
	 * @param seats
	 */
	public void save(final Seats seats) {
		final String sql = "insert into seats(sno,id,seat_status,availability) values (?,?,?,?)";
		final Object[] params = { seats.getSno(), seats.getId(), seats.getSeat_status(),seats.getAvailability() };
		final int rows = jdbcTemplate.update(sql, params);
		System.out.println(rows);
	}

	/**
	 * TO UPDATE A RECORD IN THE SEATS RELATION.
	 * 
	 * @param seats
	 */
	public void update(final Seats seats) {
		final String sql = "update seats set seat_status=? where id= ?";
		final Object[] params = { seats.getSeat_status(), seats.getId() };
		final int rows = jdbcTemplate.update(sql, params);
		System.out.println(rows);
	}

	/**
	 * TO DELETE A RECORD FROM THE SEATS RELATION.
	 * 
	 * @param seats
	 */
	public void delete(final int id) {
		final String sql = "delete from seats where id=?";
		final int rows = jdbcTemplate.update(sql, id);
		System.out.println(rows);
	}

	/**
	 * TO VIEW ALL THE SEATS FROM THE SEATS RELATION.
	 * 
	 * @param seats
	 */
	public List<Seats> list() {
		final String sql = "Select sno,id,seat_status,availability from seats";
		return jdbcTemplate.query(sql, (rs, rowNum) -> {
			final Seats seats = convert(rs);
			return seats;
		});

	}

	public Seats convert(final ResultSet rs) throws SQLException {
		final Seats seats = new Seats();
		seats.setSno(rs.getInt("sno"));
		seats.setId(rs.getInt("id"));
		seats.setSeat_status(rs.getString("seat_status"));
		seats.setAvailability(rs.getInt("availability"));

		return seats;
	}

}