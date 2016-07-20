<%@ taglib prefix="c" uri="http://www.springframework.org/tags" %>
<%@ page contentType="text/html; charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Sign in &middot; Marketplace</title>
    <link href="css/base.css" rel="stylesheet">
    <link href="css/top_pannel.css" rel="stylesheet">
    <link href="css/form.css" rel="stylesheet">
    <script type='text/javascript' src='tools/jquery-3.0.0.min.js'></script>
    <script type='text/javascript' src='tools/validation.js'></script>
</head>
<body>
<div class="container">
    <div class="panel">
        <div class="item left"><a href="board.htm">Board</a></div>
        <div class="item left"><a href="registration.htm">Registration</a></div>
    </div>
    <div class="background">
        <img src="res/images/logo.png">
        <c:url value="/j_spring_security_check" var="loginUrl" />
        <form action="${loginUrl}" method="POST" onsubmit="return validate()">
            <div class="form_row">
                <div><input class="mess required login coincidence" type="text" name="j_username" placeholder="login"></div>
            </div>
            </br>
            <div class="form_row">
                <div><input class="mess required coincidence" type="password" name="j_password" placeholder="password"></div>
            </div>
            </br>
            <div class="form_row">
                <div><button type="submit">Log in</button></div>
            </div>
        </form>
    </div>
</div>
</body>
</html>