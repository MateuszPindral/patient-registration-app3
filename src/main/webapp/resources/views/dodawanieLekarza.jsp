<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: DJ
  Date: 2018-03-26
  Time: 17:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Dodawanie lekarza</title>
    <link href="${pageContext.servletContext.contextPath}/resources/css/app.css" rel="stylesheet">
</head>
<body>
<div id="wrapper">
    <div class="page-header">
        <%--Header strony--%>
        <h1>TwojeZdrowie</h1>
    </div>

    <div class="page-menu">
        <jsp:include page="menu.jsp"/>
    </div>
    <div class="page-text">
        <%--Część odpowiedzialna za wyświetlanie treści strony--%>
        <h2>Dodaj nowego lekarza:</h2>
        <br>
        <p>
            <form:form action="dodajLekarza" method="post" modelAttribute="newDoctor">
                <label>Imię:</label><br>
                <form:input type="text" path="name"/><br>

                <label>Nazwisko:</label><br>
                <form:input type="text" path="lastName"/><br>

                <label>Specjalizacjca:</label><br>
                <select title="specialization" name="specType">
                    <c:forEach items="${docSpecEnum}" var="spec">
                        <option value="${spec}">${spec}</option>
                    </c:forEach>
                </select><br>

                <label>Login:</label><br>
                <form:input path="login"/><br>

                <label>Hasło:</label><br>
                <form:input type="password" path="password"/><br>
                <input type="submit" value="Zatwierdź"><br>

            </form:form>
        </p>
    </div>

    <div class="page-footer">
        <%--stopka--%>
        <footer>Copyright © 2018 Design GangOfThree</footer>
    </div>
</div>
</body>
</html>
