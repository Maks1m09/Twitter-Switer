<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<html>
<head>
    <title>ChangeUserRole</title>
    <jsp:include page="_header.jsp"/>
</head>
<body>

<div class="container">
    <div class="row justify-content-center">
        <div class="col-sm-5">

            <ul>
                <br>
                <div class="alert alert-success" role="alert">
                    <c:forEach var="post" items="${requestScope.all}">

                        <li>${post}</li>
                        <fmt:formatDate type="both" value="${now}"/>

                    </c:forEach>
                </div>
            </ul>

        </div>
    </div>
    <div class="form-floating">
        <div class="container">
            <div class="row justify-content-center">
                <div class="col-sm-3">

                    <form class="text-center" action="/change" method="post">
                        <br>
                        <input type="text" name="userName" required placeholder="enter login">
                        <br><br>
                        <button type="submit" class="btn btn-success">change</button>
                    </form>
</div>
            </div>
        </div>
    </div>
</div>

</body>
</html>
