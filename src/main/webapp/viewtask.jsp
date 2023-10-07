
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
<%@include file="leader/navbar.jsp"%>

<c:if test="${empty ledObj }">
		<c:redirect url="leaderlogin.jsp"></c:redirect>
	</c:if>
	

	<div class="container p-3">
		<div class="row">
			<div class="col-md-9">
				<div class="card paint-card">
					<div class="card-body">
						<p class="fs-4 fw-bold text-center text-danger">Task</p>
						<table class="table">
							<thead>
								<tr>
									<th scope="col">Task Name</th>
									<th scope="col">Task Description</th>
									<th scope="col">Devloper Name</th>
									<th scope="col">status</th>
								</tr>
							</thead>
							<tbody>
								<%
								leader l = (leader) session.getAttribute("ledObj");
								taskdao dao = new taskdao(DBConnect.getConn());
								devdao dao2 = new devdao(DBConnect.getConn());
								statdao dao4 = new statdao(DBConnect.getConn());
								List<task> list = dao.getAlltaskByLoginled(l.getId());
								for (task ap : list) {
									devloper d = dao2.getdevloperById(ap.getDevloperid());
									status d3 = dao4.getsById(ap.getStatid());
								%>
								<tr>
									<th><%=ap.getTaskname()%></th>
									<td><%=ap.getTaskdescription()%></td>
									<td><%=d.getName()%></td>
									
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