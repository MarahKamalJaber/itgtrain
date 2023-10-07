package com.servlet;


import com.db.DBConnect;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.dao.taskdao;
import com.db.DBConnect;
import com.entity.devloper;
import com.entity.leader;
import com.entity.task;
@WebServlet("/addtask")
public class addTask extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		int leaderid = Integer.parseInt(req.getParameter("ledid"));
		String Taskname = req.getParameter("taskname");
		int devloperid = Integer.parseInt(req.getParameter("dev"));
		String Taskdescription = req.getParameter("desc");
		int statusid = Integer.parseInt(req.getParameter("stat"));
		task ap = new task(Taskname, Taskdescription,leaderid, devloperid
				, statusid);

		taskdao dao = new taskdao(DBConnect.getConn());
		HttpSession session = req.getSession();

		if (dao.addtask(ap)) {
			session.setAttribute("succMsg", "task Sucessfully");
			resp.sendRedirect("task.jsp");
		} else {
			session.setAttribute("errorMsg", "Something wrong on server");
			resp.sendRedirect("task.jsp");
		}

	}

}