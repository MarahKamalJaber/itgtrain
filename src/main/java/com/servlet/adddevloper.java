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
import java.sql.ResultSet;
import java.sql.SQLException;

import com.dao.devdao;
import com.db.DBConnect;
import com.entity.devloper;

import java.sql.Connection;

@WebServlet("/adddevloper")
public class adddevloper extends HttpServlet {


	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		try {

			String Name = req.getParameter("Name");

			String email = req.getParameter("email");
			String password = req.getParameter("password");
           int leaderid = Integer.parseInt(req.getParameter("leaderid"));
            
			devloper d = new devloper(Name, email,password,leaderid);

			devdao dao = new devdao(DBConnect.getConn());
			HttpSession session = req.getSession();

			if (dao.adddevloper(d)) {
				session.setAttribute("succMsg", "devloper Added Sucessfully..");
				resp.sendRedirect("manger/devloper.jsp");
			} else {
				session.setAttribute("errorMsg", "something wrong on server");
				resp.sendRedirect("manger/devloper.jsp");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
