<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Authorization</title>
    <jsp:include page="_header.jsp"/>
<body>

    <div class="container">
        <div class="row justify-content-center">
            <div class="col-sm-3">

                <form class="text-center" action="/authorization" method="post">
                    <br>
                    <h3 class="text-center">Authorization</h3>
                    <br>
                    <input type="text" name="login" required placeholder="login">
                    <br><br>
                    <input type="password" name="password" required placeholder="password">
                    <br><br>
                    <button type="submit" class="btn btn-success">ok</button>
                </form>

            </div>
        </div>
    </div>

</body>
</html>