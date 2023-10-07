package com.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.entity.devloper;
import com.entity.leader;
public class leddao {
	private Connection conn;

	public leddao(Connection conn) {
		super();
		this.conn = conn;
	}
	
	public boolean registerleader(leader d) {
		boolean f = false;

		try {
			String sql = "insert into leader(lename,leemail,lephone,lepasswd) values(?,?,?,?)";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, d.getName());
			ps.setString(2, d.getEmail());
			ps.setString(3, d.getPhonenumber());
			ps.setString(4, d.getPassword());

			int i = ps.executeUpdate();
			if (i == 1) {
				f = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return f;
	}

	public List<leader> getAllleader() {

		List<leader> list = new ArrayList<leader>();
		leader d = null;
		try {

			String sql = "select * from leader order by leid desc";
			PreparedStatement ps = conn.prepareStatement(sql);

			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				d = new leader();
				d.setId(rs.getInt(1));
				d.setName(rs.getString(2));
				d.setEmail(rs.getString(3));
				d.setPhonenumber(rs.getString(4));
				d.setPassword(rs.getString(5));
				list.add(d);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
  
	
	public List<leader> getnameleader(){
		List<leader> list = new ArrayList<leader>();
		leader s = null;

		try {
			String sql = "select leid,lename from leader ";
			PreparedStatement ps = conn.prepareStatement(sql);

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				s = new leader();
				s.setId(rs.getInt(1));
				s.setName(rs.getString(2));
				list.add(s);
			}
			rs.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return list;
	}
	
	public leader login(String email, String psw) {
		leader d = null;
		try {

			String sql = "select * from leader where leemail=? and lepasswd=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, email);
			ps.setString(2, psw);

			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				d = new leader();
				d = new leader();
				d.setId(rs.getInt(1));
				d.setName(rs.getString(2));
				d.setEmail(rs.getString(3));
				d.setPhonenumber(rs.getString(4));
				d.setPassword(rs.getString(5));
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return d;
	}

	
	
	
	public leader getledById(int id) {

		leader d = null;
		try {

			String sql = "select * from leader where leid=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				d = new leader();
				d.setId(rs.getInt(1));
				d.setName(rs.getString(2));
				d.setEmail(rs.getString(3));
				d.setPhonenumber(rs.getString(4));
				d.setPassword(rs.getString(5));

			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return d;
	}

	
	
	
	
	
	
	
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

