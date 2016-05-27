<jsp:include page="../../top.jsp"/>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://"
            + request.getServerName() + ":" + request.getServerPort()
            + path + "/";
%>
<!DOCTYPE html>
<html lang="en-gb" dir="ltr" class="uk-height-1-1">

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Login layout example - UIkit documentation</title>
    <link rel="stylesheet" href="<%=basePath%>uikit/css/uikit.docs.min.css">
    <script src="<%=basePath%>js/jquery.js"></script>
    <script src="<%=basePath%>uikit/js/uikit.min.js"></script>
    <script src="<%=basePath%>js/template/auth.js"></script>

</head>

<body id="all" class="uk-height-1-1">

<div class="uk-vertical-align uk-text-center uk-height-1-1" align="center">
    <div class="uk-vertical-align-middle" style="width: 250px;">

        <img class="uk-margin-bottom" width="140" height="120" src="<%=basePath%>resource/img/girl.png"/>
        <form class="uk-form">
            <div class="uk-form-row">
                <input class="uk-width-1-1 uk-form-large" type="text" id="name">
            </div>
            <div class="uk-form-row">
                <input class="uk-width-1-1 uk-form-large" type="text" id="password" placeholder="Password">
            </div>
            <div class="uk-form-row">
                <a id="loginOn" class="uk-width-1-1 uk-button uk-button-primary uk-button-large">Login</a>
            </div>
            <div class="uk-form-row uk-text-small">
                <label class="uk-float-left"><input type="checkbox"> Remember Me</label>
                <a class="uk-float-right uk-link uk-link-muted" href="#">Forgot Password?</a>
            </div>
        </form>

    </div>
</div>

</body>

</html>