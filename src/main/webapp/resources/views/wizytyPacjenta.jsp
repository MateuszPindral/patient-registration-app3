<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: barto
  Date: 22.03.2018
  Time: 18:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Wizyty</title>
    <link href="${pageContext.servletContext.contextPath}/resources/css/app.css" rel="stylesheet">
</head>

<body>
<jsp:include page="menu.jsp" />

<ul class="b">
    <c:forEach items="${wizyty}" var="wizyta">
        <li class="b">${wizyta.dayOfVisit},
                ${wizyta.hourOfVisit},
            Dr. ${wizyta.doctor.lastName}</li>
    </c:forEach>

</ul>

</body>
</html>
