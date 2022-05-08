
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import = "by.tms.model.UserRole" %>
<html>
<head>
    <title>Post</title>
    <jsp:include page="_header.jsp"/>
</head>
<body>

    <div class="form-floating">
        <div class="container">
            <div class="row justify-content-center">
                <div class="col-sm-3">
                    <form class="text-center" action="/addPost" method="post">
                        <br>
                        <input type="text" name="text" required placeholder="text">
                        <br><br>


                        <c:if test="${user.role == UserRole.ADMIN_ROLE}">
                        <input type="text" name="userName"  placeholder="userName">
                            <br><br>
                        </c:if>


                        <button type="submit" class="btn btn-success">add</button>
                    </form>
                    <br>
                    <%--                 <c:if test="${post != null}">--%>
                    <form class="text-center" action="/updatePost" method="post"><%-- update --%>
                        <br>
                        <input type="text" name="text" required placeholder="text">
                        <br><br>
                        <input type="number" name="idPost" required placeholder="idPost">
                        <br><br>

                        <c:if test="${user.role == UserRole.ADMIN_ROLE}">
                        <input type="text" name="userName"  placeholder="userName">
                            <br><br>
                        </c:if>


                        <button type="submit" class="btn btn-warning">edit</button>
                    </form>
                </div>
                <div class="col-sm-3">



                    <form class="text-center" action="/deletePost" method="post"><%-- delete --%>
                        <br>
                        <input type="number" name="idPost" required placeholder="idPost">
                        <br><br>
                        <c:if test="${user.role == UserRole.ADMIN_ROLE}">
                        <input type="text" name="userName"  placeholder="userName">
                            <br><br>
                        </c:if>
                        <button type="submit" class="btn btn-danger">delete</button>
                    </form>

                    <c:if test="${user.role == UserRole.ADMIN_ROLE}">
             <form class="text-center" action="/addOrNo" method="post"><%-- delete --%>
                        <br><br>
<%--             <c:if test="${user != null}">--%>
              <input type="number" name="idPost"  placeholder="idPost">
                        <br><br>
                        <input type="text" name="userName"  placeholder="userName">
                        <br><br>
                        <button type="submit" class="btn btn-primary">publish</button>
                            <br><br>
<%--             </c:if>--%>

                    </form>
            </c:if>
                    <br>

                    <%
                        if (request.getAttribute("getText") != null)  {
                    %>
                    <div class="alert alert-success" role="alert">
                        <%       out.print (request.getAttribute("getText"));  %>
                    </div>
                    <% }
                    %>

                </div>
            </div>
        </div>
    </div>

</body>
</html>
