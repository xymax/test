<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c"  uri="http://java.sun.com/jstl/core_rt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>UserInfo</title>
</head>
<body>
    <form action="" method="post">
        <table width="100%" border="1">
            <tr>
                <td>UserId</td>
                <td>UserName</td>
                <td>UserSex</td>
                <td>UserAddress</td>
            </tr>
            <c:forEach items="${userListKey}" var="users">
                <tr>
                    <td>${users.id}</td>
                    <td>${users.username}</td>
                    <td>${users.sex}</td>
                    <td>${user.address}</td>
                </tr>
            </c:forEach>
        </table>
    </form>
</body>
</html>
