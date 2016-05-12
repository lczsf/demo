<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://"
            + request.getServerName() + ":" + request.getServerPort()
            + path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <base href="<%=basePath%>">

    <title>Uikit Test</title>
    <meta http-equiv="pragma" content="no-cache">
    <meta http-equiv="cache-control" content="no-cache">
    <meta http-equiv="expires" content="0">
    <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
    <meta http-equiv="description" content="This is my page">
    <link rel="stylesheet" type="text/css" href="uikit/css/uikit.gradient.min.css">
    <link rel="stylesheet" type="text/css" href="uikit/css/components/form-advanced.css">
    <link rel="stylesheet" type="text/css" href="uikit/css/components/notify.gradient.min.css">
    <script type="text/javascript" src="js/jquery.js"></script>
    <script type="text/javascript" src="uikit/js/components/notify.js"></script>
    <script type="text/javascript" src="js/template/address.js"></script>
</head>
<body>
<div
        style="width:800px;margin-top:10px;margin-left: auto;margin-right: auto;text-align: center;">
    <h2>Uikit Test</h2>
</div>
<div style="width:800px;margin-left: auto;margin-right: auto;">
    <fieldset class="uk-form">
        <legend>Uikit表单渲染测试</legend>
        <div class="uk-form-row">
            <input type="text" class="uk-width-1-1">
        </div>
        <div class="uk-form-row">
            <input type="text" class="uk-width-1-1 uk-form-success">
        </div>
        <div class="uk-form-row">
            <input type="text" class="uk-width-1-1 uk-form-danger">
        </div>
        <div class="uk-form-row">
            <input type="text" class="uk-width-1-1">
        </div>
        <div class="uk-form-row">
            <select id="form-s-s">
                <option>---请选择---</option>
                <option>是</option>
                <option>否</option>
            </select>
        </div>
        <div class="uk-form-row">
            <input type="date" id="form-h-id"/>
        </div>
    </fieldset>
    <fieldset class="uk-form">
        <legend>基于Restful架构风格的资源请求测试</legend>
        <button class="uk-button uk-button-primary uk-button-large" id="btnGet">获取人员GET</button>
        <button class="uk-button uk-button-primary uk-button-large" id="btnAdd">添加人员POST</button>
        <button class="uk-button uk-button-primary uk-button-large" id="btnUpdate">更新人员PUT</button>
        <button class="uk-button uk-button-danger uk-button-large" id="btnDel">删除人员DELETE</button>
        <button class="uk-button uk-button-primary uk-button-large" id="btnList">查询列表PATCH</button>
    </fieldset>
    <div id="list">
        <table id="info" class='uk-table'>
        </table>
    </div>
</div>
</body>
</html>