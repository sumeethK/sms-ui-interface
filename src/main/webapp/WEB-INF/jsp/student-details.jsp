<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ include file="/WEB-INF/jsp/includes.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Student Management</title>
</head>
<body>
	<h1>Students Data</h1>
	<form class="form-wrapper">
		<input type="text" class="search" id="searchByFirstName"
			placeholder="Search by student FirstName" required /> 
			<input type="submit" value="Search" id="submit" />
	</form>
	
	<form class="form-wrapper">
		<input type="text" class="search" id="searchByLastName"
			placeholder="Search by student LasttName" required/>
			 <input type="submit" value="Search" id="submit" />
	</form>
	
	<form class="form-wrapper">
		<input type="text" class="search" id="searchByCollegeId"
			placeholder="Search by student College Id" required/> 
			 <input type="submit" value="Search" id="submit" />
	</form>
	
	<form class="form-wrapper">
		<input type="text" class="search" id="searchByYearLevel"
			placeholder="Search by student Year Level" required/> 
			 <input type="submit" value="Search" id="submit" />
	</form>
	
	<table border="1" class="data-grid">
		<thead>
			<th>ID</th>
			<th>First name</th>
			<th>Last name</th>
			<th>Year level</th>
			<th>College ID</th>
		</thead>
		<tbody>

		</tbody>
	</table>
	<div id="ajaxGetUserServletResponse"></div>
</body>
</html>