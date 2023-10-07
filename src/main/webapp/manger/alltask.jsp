<%@page import="com.db.DBConnect"%>
<%@page import="com.dao.devdao"%>
<%@page import="com.dao.taskdao"%>
<%@page import="com.dao.leddao"%>
<%@page import="com.dao.statdao"%>
<%@page import="com.entity.devloper"%>
<%@page import="com.dao.devdao"%>
<%@page import="java.util.List"%>
<%@page import="com.entity.leader"%>
<%@page import="com.entity.task"%>
<%@page import="com.entity.status"%>
<%@ page language="java" contentType="text/html; charset=windows-1256"
    pageEncoding="windows-1256"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="windows-1256">
<title>Insert title here</title>
<%@include file="../component/css.jsp"%>
</head>
<body>
<%@include file="navbar.jsp"%>
	<div class="container p-3">
		<div class="row">

			<div class="col-md-12">
				<div class="card paint-card">
					<div class="card-body">
						<p class="fs-3 text-center">Task Details</p>
						

						<table class="table">
							<thead>
								<tr>
									<th scope="col">Task Name</th>
									<th scope="col">Task Description</th>
									<th scope="col">DevloperName</th>
									<th scope="col">LeaderName</th>
									<th scope="col">Status</th>
								</tr>
							</thead>
							<tbody>
								<%
								leddao dao3 = new leddao(DBConnect.getConn());
								taskdao dao = new taskdao(DBConnect.getConn());
								devdao dao2 = new devdao(DBConnect.getConn());
								statdao dao4 = new statdao(DBConnect.getConn());
								List<task> list = dao.getAlltaskes();
								for (task ap : list) {
									devloper d1 = dao2.getdevloperById(ap.getDevloperid());
									leader d2 = dao3.getledById(ap.getLeaderid());
									status d3 = dao4.getsById(ap.getStatid());
								%>
								<tr>
									<th><%=ap.getTaskname()%></th>
									<td><%=ap.getTaskdescription()%></td>
									<td><%=d1.getName()%></td>
									
									<td><%=d2.getName()%></td>
									<td><%=d3.getStatusname()%></td>
								
								</tr>
								<%
								}
								%>



							</tbody>
						</table>

					</div>
				</div>
			</div>

		</div>
	</div>


</body>
</html>