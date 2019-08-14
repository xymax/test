<%@ page contentType="text/html;charset=UTF-8" language="java"  isELIgnored="false" pageEncoding="UTF-8" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Title</title>
    <meta http-equiv="content-type" content="text/html" charset="UTF-8">
    <script type="text/javascript">
        function chooseItem(row,obj){
            row = parseInt(row);
        }
        function operateData(param){
            //得到页面所有的checkbox对象
            var selItem = document.getElementsByName("selItem");
            var index=0;  //对操作数量进行定义
            for(var i=0;i<selItem.length;i++){
                //得到一个具体的checkbox对象
                if(selItem[i].checked){
                    index++;
                }
            }
            if(index==0){
                alert('请选择要操作的对象数据!');
            }else if(index==1 && param=='checkboxupdate'){
                //修改
                userinfoForm.action='modifyInfoShow.action';
                userinfoForm.submit();
            }else if(index>=1 && param=='delete'){
                //删除
                userinfoForm.action='deleteIds.action';
                userinfoForm.submit();
            }else{
                alert(param+'只能选择一条记录进行操作！');
            }
        }
        //选中最上面一个复选框，则下面的自动全部选择
        function checkall(){
            var selItem = document.getElementsByName("selItem");
            var chooseAll = document.getElementsByName("chooseAll")[0].checked;
            for(var i=0;i<selItem.length;i++){
                selItem[i].checked=chooseAll;
            }
        }
    </script>


</head>
<body>

    <form action="queryitemsbyname.action" name="userinfoForm" method="post">
        <table border="0" align="right">
            <tr>
                <td>
                    <input type="button" name="addbtn" value="新增" onclick="window.location.href='./jsp/addItems.jsp'" class="btn"/>
                    <input type="button" name="modbtn" value="修改" onclick="operateData('checkboxupdate')" class="btn"/>
                    <input type="button" name="delbtn" value="删除" onclick="operateData('delete')" class="btn"/>
                    <input type="button" name="delbtn" value="查询" onclick="window.location.href='queryitemsbyname.action'" class="btn"/>
                </td>
            </tr>
        </table>
        商品列表
        <table width="100%" border="1">
            <tr>
                <td>
                    查询条件
                    <input type="text" name="itemsCustom.name">
                    <input type="submit" value="名称查询">
                </td>
            </tr>
        </table>
        <table width="100%" border="1">
            <tr>
                <td>
                    <input type="checkbox"  name="chooseAll" onclick="checkall();"/>
                </td>
                <td>商品名称</td>
                <td>商品价格</td>
                <td>生产日期</td>
                <td>商品描述</td>
                <td>操作</td>
            </tr>
            <c:forEach items="${itemsListKey}" var="items">
                <tr>
                    <td>
                        <input type="checkbox" name="selItem" value="${items.id }">
                    </td>
                    <td>${items.name}</td>
                    <td>${items.price}</td>
                    <td><fmt:formatDate value="${items.createtime}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
                    <td>${items.detail}</td>
                    <td>
                        <a href="modifyInfoShow.action?id=${items.id}">修改</a>
                        <a href="deleteByid.action?id=${items.id}">删除</a>
                    </td>
                </tr>
            </c:forEach>
        </table>
    </form>
</body>
</html>
