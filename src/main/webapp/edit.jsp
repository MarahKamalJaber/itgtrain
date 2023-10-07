
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

<div class="container-fulid backImg p-5">
		<p class="text-center fs-2 text-white"></p>
	</div>
	<div class="container p-3">
		<div class="row">

			<div class="col-md-6 offset-md-3">
				<div class="card paint-card">
					<div class="card-body">
						<p class="text-center fs-4">Edit Status</p>

						<%
						int id = Integer.parseInt(request.getParameter("id"));
						taskdao dao = new taskdao(DBConnect.getConn());

						task ap = dao.gettaskById(id);
						%>
						<form class="row" action="updateStatus" method="post">
							
<div class="mb-3">
								<label class="form-label">Status</label> <select name="stat"
									required class="form-control">
									<option>--select Leader--</option>

									<%
									statdao dao6 = new statdao(DBConnect.getConn());
									List<status> list1 = dao6.getAllstatus();
									for (status s : list1) {
									%>
									<option value="<%=s.getSuid()%>"><%=s.getStatusname()%> 
									</option>
									<%
									}
									%>


								</select>
							</div>
							<input type="hidden" name="id" value="<%=ap.getId()%>"> <input
								type="hidden" name="did" value="<%=ap.getDevloperid()%>">

							<button class=" mt-3 btn btn-danger col-md-6 offset-md-3">Submit</button>

						</form>

					</div>
				</div>
			</div>
		</div>
	</div>





</body>
</html>