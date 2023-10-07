package com.servlet;
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

import com.dao.leddao;
import com.db.DBConnect;
import com.entity.devloper;
import com.entity.leader;

@WebServlet("/addleader")
public class addleader extends HttpServlet{
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		try {

			String Name = req.getParameter("Name");

			String email = req.getParameter("email");
			String Phonenumber = req.getParameter("Phonenumber");
			String password = req.getParameter("password");

			leader d = new leader(Name, email, Phonenumber, password);

			leddao dao = new leddao(DBConnect.getConn());
			HttpSession session = req.getSession();

			if (dao.registerleader(d)) {
				session.setAttribute("succMsg", "leader Added Sucessfully..");
				resp.sendRedirect("manger/leader.jsp");
			} else {
				session.setAttribute("errorMsg", "something wrong on server");
				resp.sendRedirect("manger/leader.jsp");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
