<%@page import="com.entity.devloper"%>
<%@page import="com.dao.devdao"%>
<%@page import="java.util.List"%>
<%@page import="com.entity.leader"%>
<%@page import="com.dao.leddao"%>
<%@page import="com.db.DBConnect"%>
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
<div class="container-fluid p-3">
		<div class="row">

			<div class="col-md-5 offset-md-4">
				<div class="card paint-card">
					<div class="card-body">
						<p class="fs-3 text-center">Add Devloper</p>
						<c:if test="${not empty errorMsg}">
							<p class="fs-3 text-center text-danger">${errorMsg}</p>
							<c:remove var="errorMsg" scope="session" />
						</c:if>
						<c:if test="${not empty succMsg}">
							<div class="fs-3 text-center text-success" role="alert">${succMsg}</div>
							<c:remove var="succMsg" scope="session" />
						</c:if>
						<form action="../adddevloper" method="post">
							<div class="mb-3">
								<label class="form-label">Name</label> <input type="text"
									required name="Name" class="form-control">
							</div>

						<div class="mb-3">
								<label class="form-label">Leader</label> <select name="leaderid"
									required class="form-control">
									<option>--select Leader--</option>

									<%
									leddao dao = new leddao(DBConnect.getConn());
									List<leader> list = dao.getAllleader();
									for (leader s : list) {
									%>
									<option value="<%=s.getId()%>"><%=s.getName()%> (<%=s.getEmail()%>)
									</option>
									<%
									}
									%>


								</select>
							</div>
						

							<div class="mb-3">
								<label class="form-label">Email</label> <input type="text"
									required name="email" class="form-control">
							</div>

							

							<div class="mb-3">
								<label class="form-label">Password</label> <input required
									name="password" type="password" class="form-control">
							</div>

							<button type="submit" class="btn btn-primary">Submit</button>
						</form>
					</div>
				</div>
			</div>

 <div class="col-md-12">
				<div class="card paint-card">
					<div class="card-body">
						
						<table class="table">
							<thead>
								<tr> 
								<th scope="col">leaderid</th>
									<th scope="col">Name</th>
									<th scope="col">Email</th>
									
									
									
								</tr>
							</thead>
							<tbody>
							
                            <%
								devdao dao2 = new devdao(DBConnect.getConn());
								List<devloper> list2 = dao2.getAlldev();
								for (devloper d : list2) {
								%>
								<tr>
									<td><%=d.getLeaderid()%></td>
									<td><%=d.getName()%></td>
									<td><%=d.getEmail()%></td>
								
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