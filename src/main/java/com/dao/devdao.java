package com.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.entity.devloper;
import com.entity.leader;
public class devdao {
	private static Connection conn;
	
	public  devdao(Connection conn) {
		super();
		this.conn=conn;
	}
	
//public static int getidleader(String name){
//	System.out.print("hellllllllllllllllllllllllllo");
//		//lename='"+name+"'"
//		int c=0;
//			try {
//				String sql = "select leid FROM leader WHERE lename='"+name+"'";
//				PreparedStatement ps = conn.prepareStatement(sql);
//          // ps.setString(1,1);
//				ResultSet rs = ps.executeQuery();
//
//				
//				c=rs.getInt("leid");  System.out.println(c+"doneeeeeeeeeeeeeee");
//				rs.close();
//			} catch (Exception e) {
//				e.printStackTrace();
//			}
//
//			return c;
//		}
//	
	public boolean adddevloper(devloper d) {
		boolean f = false;

		try {
			

			String sql = "insert into devloper1(leaderid,devname,devemail,devpasswd) values(?,?,?,?)";
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setInt(1,d.getLeaderid());
			ps.setString(2, d.getName());
			ps.setString(3, d.getEmail());
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
	
	public List<devloper> getAlldev() {

		List<devloper> list = new ArrayList<devloper>();
		devloper d = null;
		try {

			String sql = "select * from devloper1 order by devid desc";
			PreparedStatement ps = conn.prepareStatement(sql);

			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				d = new devloper();
				d.setId(rs.getInt(1));
				d.setLeaderid(rs.getInt(2));
				d.setName(rs.getString(3));
				d.setEmail(rs.getString(4));
				d.setPassword(rs.getString(5));
				list.add(d);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
	
	
	public devloper login(String em, String psw) {
		devloper u = null;

		try {
			String sql = "select * from devloper1 where devemail=? and devpasswd=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, em);
			ps.setString(2, psw);

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				u = new devloper();
				u.setId(rs.getInt(1));
				u.setLeaderid(rs.getInt(2));
				u.setName(rs.getString(3));
				u.setEmail(rs.getString(4));
				u.setPassword(rs.getString(5));
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return u;
	}
	
	public devloper getdevloperById(int id) {

		devloper d = null;
		try {

			String sql = "select * from devloper1 where devid=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				d = new devloper();
				d.setId(rs.getInt(1));
				d.setLeaderid(rs.getInt(2));
				d.setName(rs.getString(3));
				d.setEmail(rs.getString(4));
				d.setPassword(rs.getString(5));

			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return d;
	}
   
	public devloper getdevloperByleId(int id) {

		devloper d = null;
		try {

			String sql = "select * from devloper1 where leaderid=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				d = new devloper();
				d.setId(rs.getInt(1));
				d.setLeaderid(rs.getInt(2));
				d.setName(rs.getString(3));
				d.setEmail(rs.getString(4));
				d.setPassword(rs.getString(5));

			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return d;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
