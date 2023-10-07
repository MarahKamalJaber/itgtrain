<%@page import="com.db.DBConnect"%>
<%@page import="com.dao.devdao"%>
<%@page import="com.entity.leader"%>
<%
response.setHeader("Cache-Control", "no-cache");
response.setHeader("Cache-Control", "no-store");
response.setHeader("Pragma", "no-cache");
response.setDateHeader("Expires", 0);
%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page isELIgnored="false"%>
<%@page import="com.entity.devloper"%>
<%@page import="java.util.List"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>task</title>
<%@include file="../component/css.jsp"%>

</head>
<body>
	<%@include file="leader/navbar.jsp"%>

	
	<div class="container p-3">
		<div class="row">
			

			<div class="col-md-6">
				<div class="card paint-card">
					<div class="card-body">
						<p class="text-center fs-3">Add Task</p>
						
						<form class="row g-3" action="addtask" method="post">

							<input type="hidden" name="ledid" value="${ledObj.id }">

							<div class="col-md-6">
								<label for="inputEmail4" class="form-label">Task Name</label> <input
									required type="text" class="form-control" name="taskname">
							</div>
							<div class="col-md-6">
							<label for="inputEmail4" class="form-label">Description</label>
							 <textarea name="desc" class="form-control text-area"  placeholder="Please Enter Task Description Here .."></textarea>
							</div>
                             
							
							<div class="col-md-6">
								<label for="inputPassword4" class="form-label">Devloper</label> <select
									required class="form-control" name="dev">
									<option value="">--select--</option>

									<%
									devdao dao = new devdao(DBConnect.getConn());
									List<devloper> list = dao.getAlldev();
									for (devloper d : list) {
									%>
									<option value="<%=d.getId()%>"><%=d.getName()%> (<%=d.getLeaderid()%>)(<%=d.getEmail()%>)
									</option>
									<%
									}
									%>




								</select>
							</div>
                             <button type="submit" class="btn btn-dark">Submit</button>
                      
							
						</form>
					</div>
				</div>
			</div>
		</div>

	</div>
	

</body>
</html>
