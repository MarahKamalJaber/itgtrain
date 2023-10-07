package com.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.entity.devloper;
import com.entity.leader;
import com.entity.status;
import com.entity.task;

public class statdao {
	private Connection conn;

	public statdao(Connection conn) {
		super();
		this.conn = conn;
	}
	
	
	public List<status> getAllstatus() {

		List<status> list = new ArrayList<status>();
		status d = null;
		try {

			String sql = "select * from status order by sid desc";
			PreparedStatement ps = conn.prepareStatement(sql);

			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				d = new status();
				d.setSuid(rs.getInt(1));
				d.setStatusname(rs.getString(2));
				
				list.add(d);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
	
	public status getsById(int id) {

		status d = null;
		try {

			String sql = "select * from status where sid=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				d = new status();
				d.setSuid(rs.getInt(1));
				d.setStatusname(rs.getString(2));
				
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return d;
	}

//
}
