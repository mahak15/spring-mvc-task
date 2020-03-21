<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>Read</title>
<%@ page isELIgnored="false" %>
</head>
<body>
	<h2>Spring MVC</h2>
	<p><strong>Employee List is Here </strong></p>
	<table border="1">
		<tr>
			<th>Id</th>
			<th>Name</th>
			<th>Department</th>
		</tr>
		<c:forEach var="employee" items="${listEmployee}">
			<tr>
				<td><c:out value="${employee.id}" /></td>
				<td><c:out value="${employee.name}" /></td>
				<td><c:out value="${employee.department}" /></td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>