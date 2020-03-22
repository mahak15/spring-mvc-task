<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
    <head>
    </head>

    <body>
        <c:forEach var="employee" items="{employeeData.employeeList}">
            <h1><c:out value="${employee.name}" /></h1>
            <h2><c:out value="${employee.department}" /></h2>
        </c:forEach>
    </body>
</html>