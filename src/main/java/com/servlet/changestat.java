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
@WebServlet("/updateStatus")
public class changestat extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		try {
			int id = Integer.parseInt(req.getParameter("id"));
			int did = Integer.parseInt(req.getParameter("did"));
			String stat = req.getParameter("stat");

			taskdao dao = new taskdao(DBConnect.getConn());

			HttpSession session = req.getSession();

			if (dao.updateTaskStatus(id, did, stat)) {
				session.setAttribute("succMsg", "status Updated");
				resp.sendRedirect("edittask.jsp");
			} else {
				session.setAttribute("errorMsg", "Something wrong on server");
				resp.sendRedirect("edittask.jsp");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}