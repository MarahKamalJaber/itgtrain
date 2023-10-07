package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.entity.task;

public class taskdao {

	private Connection conn;

	public taskdao(Connection conn) {
		super();
		this.conn = conn;
	}

	public boolean addtask(task ap) {
		boolean f = false;

		try {

			String sql = "insert into task(taskname,taskdesc,leaderid,devloperid,statid) values(?,?,?,?,?)";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, ap.getTaskname());
			ps.setString(2, ap.getTaskdescription());
			ps.setInt(3, ap.getLeaderid());
			ps.setInt(4, ap.getDevloperid());
			ps.setInt(5, ap.getStatid());

			int i = ps.executeUpdate();
			if (i == 1) {
				f = true;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return f;
	}

	public List<task> getAlltaskByLoginled(int leId) {
		List<task> list = new ArrayList<task>();
		task ap = null;

		try {

			String sql = "select * from task where leaderid=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, leId);

			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				ap = new task();
				ap.setId(rs.getInt(1));
				ap.setTaskname(rs.getString(2));
				ap.setTaskdescription(rs.getString(3));
				ap.setLeaderid(rs.getInt(4));
				ap.setDevloperid(rs.getInt(5));
				ap.setStatid(rs.getInt(6));
				list.add(ap);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return list;
	}
//
	public List<task> getAllAppointmentBydevloperLogin(int dId) {
		List<task> list = new ArrayList<task>();
		task ap = null;

		try {

			String sql = "select * from task where devloperid=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, dId);

			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				ap = new task();
				ap.setId(rs.getInt(1));
				ap.setTaskname(rs.getString(2));
				ap.setTaskdescription(rs.getString(3));
				ap.setLeaderid(rs.getInt(4));
				ap.setDevloperid(rs.getInt(5));
				ap.setStatid(rs.getInt(6));
				list.add(ap);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return list;
	}

	public task gettaskById(int id) {

		task ap = null;

		try {

			String sql = "select * from task where taskid=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);

			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				ap = new task();
				ap.setId(rs.getInt(1));
				ap.setTaskname(rs.getString(2));
				ap.setTaskdescription(rs.getString(3));
				ap.setLeaderid(rs.getInt(4));
				ap.setDevloperid(rs.getInt(5));
				ap.setStatid(rs.getInt(6));

			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return ap;
	}
//
	public boolean updateTaskStatus(int id, int devId, String stat) {
		boolean f = false;
		try {
			String sql = "update task set statid=? where taskid=? and devloperid=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, stat);
			ps.setInt(2, id);
			ps.setInt(3, devId);

			int i = ps.executeUpdate();
			if (i == 1) {
				f = true;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return f;
	}
//
	public List<task> getAlltaskes() {
		List<task> list = new ArrayList<task>();
		task ap = null;

		try {

			String sql = "select * from task order by taskid desc";
			PreparedStatement ps = conn.prepareStatement(sql);

			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				ap = new task();
				ap.setId(rs.getInt(1));
				ap.setTaskname(rs.getString(2));
				ap.setTaskdescription(rs.getString(3));
				ap.setLeaderid(rs.getInt(4));
				ap.setDevloperid(rs.getInt(5));
				ap.setStatid(rs.getInt(6));
				list.add(ap);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return list;
	}

}