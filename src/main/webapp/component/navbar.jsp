<%@page import="com.db.DBConnect"%>
<%@page import="java.sql.Connection"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page isELIgnored="false"%>

<nav class="navbar navbar-expand-lg navbar-dark bg-danger">

  <div class="container-fluid">
    <a class="navbar-brand" href="index.jsp">Company</a>
    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarSupportedContent">
      <ul class="navbar-nav me-auto mb-2 mb-lg-0">
      <c:if test="${  empty devObj }">
        <li class="nav-item">
          <a class="nav-link active" aria-current="page" href="devloperlogin.jsp">Devloper</a>
        </li>
        <li class="nav-item">
          <a class="nav-link active" aria-current="page" href="leaderlogin.jsp">Leader</a>
        </li>
       <li class="nav-item">
          <a class="nav-link active" aria-current="page" href="managerlogin.jsp">Manger</a>
        </li>
       
          </c:if>
        <c:if test="${not empty devObj }">
      <ul class="navbar-nav me-auto mb-2 mb-lg-0">
 <li class="nav-item">
          <a class="nav-link active" aria-current="page" href="#">Taskes</a>
        </li></ul>
			<div class="dropdown">
						<button class="btn btn-dark dropdown-toggle" type="button"
							id="dropdownMenuButton1" data-bs-toggle="dropdown"
							aria-expanded="false">
							<i class="fa-solid fa-circle-user"></i> ${devObj.name }
							
						</button>
						<ul class="dropdown-menu" aria-labelledby="dropdownMenuButton1">
							<li><a class="dropdown-item" href="devLogout">Logout</a></li>
							
						</ul>
					</div>


					
</ul>
				</c:if>
        
      
     
    </div>
  </div>
</nav>