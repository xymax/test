<%--
  Created by IntelliJ IDEA.
  User: 比特科技
  Date: 2019/6/26
  Time: 19:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>EditPage</title>
    <meta http-equiv="content-type" content="text/html" charset="UTF-8">
</head>
<body>
        <form action="editSubmit.action?id=${itemsKey.id}" method="post">
            <table width="100%" border="1">
                <tr>
                    <td>商品名称</td>
                    <td>
                        <input type="text" name="name" value="${itemsKey.name}">
                    </td>
                </tr>
                <tr>
                    <td>商品价格</td>
                    <td>
                        <input type="text" name="price" value="${itemsKey.price}">
                    </td>
                </tr>
                <tr>
                    <%--这里需要：自定义属性编辑器--%>
                    <td>生产日期</td>
                    <td>
                        <input type="text" name="createtime" value="<fmt:formatDate value="${itemsKey.createtime}" pattern="yyyy-MM-dd HH:mm:ss"/>">
                    </td>
                </tr>
                <tr>
                    <td>商品描述</td>
                    <td>
                        <textarea name="detail">${itemsKey.detail}</textarea>
                    </td>
                </tr>
                <tr>
                    <td colspan="2">
                        <input type="submit" value="提交">
                    </td>
                </tr>
            </table>
        </form>
</body>
</html>
