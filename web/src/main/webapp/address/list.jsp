<%--
  Created by IntelliJ IDEA.
  User: wb-lichao.x
  Date: 2016/5/6
  Time: 17:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Title</title>

    <table border=1 width="100%">
        <tr>
            <td align="center"><h2>address_id</h2></td>
            <td align="center"><h2>address_content</h2></td>
        </tr>
        <c:forEach items="${addressVos}" var="addressVo">
            <tr>
                <td align="center">${addressVo.address.id}</td>
                <td align="center">${addressVo.address.content}</td>
            </tr>
        </c:forEach>
    </table>
</head>
<body>

</body>
</html>
