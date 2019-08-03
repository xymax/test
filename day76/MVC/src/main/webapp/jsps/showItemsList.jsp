<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <table border="1" align="center">
        <tr>
            <th>ItemsId</th>
            <th>ItemsName</th>
            <th>ItemsPrice</th>
        </tr>

        <c:forEach items="${itemsListKey}" var="items">
            <tr>
                <td>${items.itemsId}</td>
                <td>${items.itemsName}</td>
                <td>${items.itemsPrice}</td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>
