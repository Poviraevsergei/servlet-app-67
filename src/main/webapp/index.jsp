<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Group 65</title>
</head>
<body>
<p>name: ${name}</p>
<p>name: <%= request.getAttribute("name") %></p>
<p>from cookie: ${cookie.password.value}</p>

<c:out value="This is our message"/>

<c:if test="${null != null}">
    <h1>WE HAVE COOKIE!!</h1>
</c:if>

<c:forEach var="user" items="${names}">
    <h3>Hello ${user}</h3>
</c:forEach>
</body>
</html>
