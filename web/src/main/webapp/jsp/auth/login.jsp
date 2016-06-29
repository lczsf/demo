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
    <%--<script src="<%=basePath%>js/template/auth.js"></script>--%>

</head>

<body id="all" class="uk-height-1-1">

<div class="uk-vertical-align uk-text-center uk-height-1-1" align="center">
    <div class="uk-vertical-align-middle" style="width: 250px;">

        <img class="uk-margin-bottom" width="140" height="120" src="<%=basePath%>resource/img/girl.png"/>
        <form action="../j_spring_security_check" method="post">
            <div class="uk-form-row">
                USERNAME:<input type="text" name="j_username" value="${sessionScope['SPRING_SECURITY_LAST_USERNAME']}"/>
            </div>
            <div class="uk-form-row">
                PASSWORD:<input type="password" name="j_password" value="" />
            </div>
            <div class="uk-form-row">
                <input type="submit" value="Login">
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