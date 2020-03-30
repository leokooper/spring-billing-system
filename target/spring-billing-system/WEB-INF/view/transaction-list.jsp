<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false"%>
<html>
<head>
    <title>Get list of transaction!</title>
</head>
<body>
<ul>
    <c:forEach var="temp" items="${financialtransactionList}">
        <li>${temp}</li>
    </c:forEach>
</ul>

</body>
</html>
