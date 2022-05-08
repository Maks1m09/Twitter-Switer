<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Like</title>
    <jsp:include page="_header.jsp"/>
</head>
<body>

    <div class="form-floating">
        <div class="container">
            <div class="row justify-content-center">
                <div class="col-sm-3">

                    <form class="text-center" action="/addLike" method="post"><%-- add --%>
                        <br>
                        <input type="number" name="idPost" required placeholder="idPost">
                        <br><br>
                        <button type="submit" class="btn btn-success">add</button>
                    </form>

                    <br>

                    <form class="text-center" action="/deleteLike" method="post"><%-- delete --%>
                        <br><br>
                        <input type="number" name="idPost" required placeholder="idPost">
                        <br><br>
                        <button type="submit" class="btn btn-danger">delete</button>
                    </form>

                    <%
                        if (request.getAttribute("getText") != null)  {
                    %>
                    <div class="alert alert-success" role="alert">
                        <% out.print (request.getAttribute("getText")); %>
                    </div>
                    <%
                        }
                    %>

                </div>
            </div>
        </div>
    </div>

</body>
</html>
