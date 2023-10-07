
<%@page import="com.db.DBConnect"%>
<%@page import="com.dao.devdao"%>
<%@page import="com.dao.taskdao"%>
<%@page import="com.entity.devloper"%>
<%@page import="com.dao.devdao"%>
<%@page import="java.util.List"%>
<%@page import="com.entity.leader"%>
<%@page import="com.entity.task"%>
<%@page import="com.entity.status"%>
<%@page import="com.dao.statdao"%>
<%@ page language="java" contentType="text/html; charset=windows-1256"
    pageEncoding="windows-1256"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="windows-1256">
<title>Insert title here</title>
<%@include file="component/css.jsp"%>
</head>
<body>



	<%@include file="devnav.jsp"%>
	<div class="container p-3">
		<div class="row">

			<div class="col-md-12">
				<div class="card paint-card">
					<div class="card-body">
						<p class="fs-3 text-center">Task Details</p>
						<c:if test="${not empty errorMsg}">
							<p class="fs-4 text-center text-danger">${errorMsg}</p>
							<c:remove var="errorMsg" scope="session" />
						</c:if>
						
                        <form action="../updetestatus" method="post">
						<table class="table">
							<thead>
								<tr>
									<th scope="col">Task Name</th>
									<th scope="col">Task Description</th>
									
						           	<th scope="col">Status</th>

									<th scope="col">Change</th>
								</tr>
							</thead>
							<tbody>
								<%
								devloper d = (devloper) session.getAttribute("devObj");
								taskdao dao = new taskdao(DBConnect.getConn());
								statdao dao2 = new statdao(DBConnect.getConn());
								List<task> list = dao.getAllAppointmentBydevloperLogin(d.getId());
								for (task ap : list) {
									status d1 = dao2.getsById(ap.getStatid());
								%>
								<tr>
									<th><%=ap.getTaskname()%></th>
									<td><%=ap.getTaskdescription()%></td>
									<td><%=d1.getStatusname()%></td>
									<td>
									
										<a href="edit.jsp?id=<%=ap.getId()%>"
										class="btn btn-dark btn-sm">Edit</a> 
									</td>
								</tr>
								<%
								}
								%>



							</tbody>
						</table>
</form>
					</div>
				</div>
			</div>

		</div>
	</div>


</body>
</html>