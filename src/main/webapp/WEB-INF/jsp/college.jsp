<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ include file="/WEB-INF/jsp/includes.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>College Management</title>
</head>
<body>
<h1>Colleges Data</h1>
<form:form action="college.do" method="POST" modelAttribute="college" class="form-data">
	<table>
		<tr>
			<td>College ID</td>
			<td><form:input path="id" /></td>
		</tr>
		<tr>
			<td>College Name</td>
			<td><form:input path="name" /></td>
			<td><form:errors path="name"  cssClass="error"/></td>
		</tr>
		<tr>
			<td>Location</td>
			<td><form:input path="city" /></td>
			<td><form:errors path="city"  cssClass="error"/></td>
		</tr>
		<tr>
			<td colspan="2">
				<input type="submit" name="action" value="Add" />
				<input type="submit" name="action" value="Edit" />
				<input type="submit" name="action" value="Delete" />
				<input type="submit" name="action" value="Search" />
			</td>
		</tr>
	</table>
</form:form>
<br>
<table border="1" class="data-grid">
	<th>ID</th>
	<th>College Name</th>
	<th>Location</th>
	<c:forEach items="${collegeList}" var="college">
		<tr>
			<td>${college.id}</td>
			<td>${college.name}</td>
			<td>${college.city}</td>
			
		</tr>
	</c:forEach>
</table>
</body>
</html>