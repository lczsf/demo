<%--
  Created by IntelliJ IDEA.
  User: wb-lichao.x
  Date: 2016/5/13
  Time: 10:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>userInfo</title>
    <meta http-equiv="pragma" content="no-cache">
    <meta http-equiv="cache-control" content="no-cache">
    <meta http-equiv="expires" content="0">
    <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
    <meta http-equiv="description" content="This is my page">
    <link rel="stylesheet" type="text/css" href="../uikit/css/uikit.gradient.min.css">
    <link rel="stylesheet" type="text/css" href="../uikit/css/components/form-advanced.css">
    <link rel="stylesheet" type="text/css" href="../uikit/css/components/notify.gradient.min.css">
    <link rel="stylesheet" type="text/css" href="../uikit/fonts/fontawesome-webfont.ttf">
    <link rel="stylesheet" type="text/css" href="../uikit/fonts/fontawesome-webfont.woff">
    <link rel="stylesheet" type="text/css" href="../uikit/fonts/fontawesome-webfont.woff2">
    <script type="text/javascript" src="../js/jquery.js"></script>
    <script type="text/javascript" src="../uikit/js/components/notify.js"></script>
    <script type="text/javascript" src="../js/template/common/common.js"></script>
    <script type="text/javascript" src="../js/template/user.js"></script>
</head>
<body>
<div style="width:800px;margin-top:10px;margin-left: auto;margin-right: auto;text-align: center;">
    <h2>User Information</h2>
    <div style="width:800px;margin-left: auto;margin-right: auto;">
        <fieldset class="uk-form">
            <legend align="left">Condition</legend>
            Age:<input id="age" type="text" placeholder="">
            <button id="btnList" class="uk-button">Query</button>
        </fieldset>
    </div>
    <div id="list">
        <table id="info" class='uk-table'>
        </table>
    </div>
    <div id="page">
        <ul id="pageList" class="uk-pagination uk-pagination-right">
            <li><a href=""><i class="uk-icon-angle-double-left"></i></a></li>
        </ul>
    </div>
</div>
</body>
</html>
