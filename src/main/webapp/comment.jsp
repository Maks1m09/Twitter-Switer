<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import = "by.tms.model.UserRole" %>

<html>
<head>
    <title>Comment</title>
    <jsp:include page="_header.jsp"/>

</head>
<body>

    <div class="form-floating">
        <div class="container">
            <div class="row justify-content-center">
                <div class="col-sm-3">
                    <form class="text-center" action="/addComment" method="post">
                        <br>
                        <input type="number" name="idPost" required placeholder="idPost">
                        <br><br>
                        <input type="text" name="text" required placeholder="text">


                        <c:if test="${user.role == UserRole.ADMIN_ROLE}">
                            <br><br>
                            <input type="text" name="userName"  placeholder="userName">
                        </c:if>
                                   <br> <br>
                        <button type="submit" class="btn btn-success">add</button>
                    </form>

                </div>

                <div class="col-sm-3">
                    <form class="text-center" action="/updateComment" method="post"><%-- update --%>
                        <br>
                        <input type="number" name="idPost" required placeholder="idPost">
                        <br><br>
                        <input type="number" name="idComment" required placeholder="idComment">
                        <br><br>
                        <input type="text" name="text" required placeholder="text">
                        <br><br>


                        <%--                        Как вкинуть провепрку на роль--%>
                        <c:if test="${user.role == UserRole.ADMIN_ROLE}">
                            <input type="text" name="userName"  placeholder="userName">
                            <br><br>
                        </c:if>


                        <button type="submit" class="btn btn-warning">edit</button>
                    </form>

                </div>

                <div class="col-sm-3">

<%--                    <form class="text-center" action="/addComment" method="post">--%>
<%--                        <br>--%>
<%--                        <input type="number" name="idPost" required placeholder="idPost">--%>
<%--                        <br><br>--%>
<%--                        <input type="text" name="text" required placeholder="text">--%>
<%--                        <br><br>--%>


<%--&lt;%&ndash;                        Как вкинуть провепрку на роль&ndash;%&gt;--%>
<%--                        <c:if test="${user != null}">--%>
<%--                            <input type="text" name="userName"  placeholder="userName">--%>
<%--                            <br><br>--%>
<%--                        </c:if>--%>


<%--                        <br><br>--%>
<%--                        <button type="submit" class="btn btn-success">add</button>--%>
<%--                    </form>--%>

<%--                    <br>--%>
    <%--                <c:if test="${post != null}">--%>
<%--                    <form class="text-center" action="/updateComment" method="post">&lt;%&ndash; update &ndash;%&gt;--%>
<%--                        <br>--%>
<%--                        <input type="number" name="idPost" required placeholder="idPost">--%>
<%--                        <br><br>--%>
<%--                        <input type="number" name="idComment" required placeholder="idComment">--%>
<%--                        <br><br>--%>
<%--                        <input type="text" name="text" required placeholder="text">--%>
<%--                        <br><br>--%>


<%--                        &lt;%&ndash;                        Как вкинуть провепрку на роль&ndash;%&gt;--%>
<%--                        <c:if test="${user != null}">--%>
<%--                            <input type="text" name="userName"  placeholder="userName">--%>
<%--                            <br><br>--%>
<%--                        </c:if>--%>


<%--                        <button type="submit" class="btn btn-warning">edit</button>--%>
<%--                    </form>--%>

<%--                    <br>--%>

                    <form class="text-center" action="/deleteComment" method="post"><%-- delete --%>
                        <br>
                        <input type="number" name="idPost" required placeholder="idPost">
                        <br><br>
                        <input type="number" name="idComment" required placeholder="idComment">
                        <br><br>


                        <%--                        Как вкинуть провепрку на роль--%>
                        <c:if test="${user.role == UserRole.ADMIN_ROLE}">
                            <input type="text" name="userName"  placeholder="userName">
                            <br><br>
                        </c:if>


                        <button type="submit" class="btn btn-danger">delete</button>
                    </form>
    <%--                </c:if>--%>

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

