<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Registration &middot; Marketplace</title>
    <link href="../../css/base.css" rel="stylesheet">
    <link href="../../css/top_pannel.css" rel="stylesheet">
    <link href="../../css/form.css" rel="stylesheet">
    <link href="../../css/registration.css" rel="stylesheet">
    <script type='text/javascript' src='../../tools/jquery-3.0.0.min.js'></script>
    <script type='text/javascript' src='../../tools/validation.js'></script>
</head>
<body>
<div class="container">
    <div class="panel">
        <div class="logo left"><img src="../../res/images/logo2.png" height="30px" width="30px"></div>
        <div class="item left">|</div>
        <div class="item left"><a href="board.jsp">Board</a></div>
        <div class="item left"><a href="/login.do">Login</a></div>
    </div>
    <div class="background">
        <h3>Registration</h3>
        </br>
        <form method="GET" onsubmit="return validate()">
            <div class="form_row">
                <div>Login</div>
                <div><input class="mess required login coincidence" type="text" name="login"></div>
            </div>
            </br>
            <div class="form_row">
                <div>Password</div>
                <div><input class="mess required password coincidence" type="password" name="password"></div>
            </div>
            </br>
            <div class="form_row">
                <div>Re-enter password</div>
                <div><input class="mess required password" type="password" name="re_password"></div>
            </div>
            </br>
            <div class="form_row">
                <div>Full name</div>
                <div><input class="mess required" type="text" name="full_name"></div>
            </div>
            </br>
            <div class="form_row">
                <div>Billing address</div>
                <div><textarea class="mess address required" name="address" rows="3"></textarea></div>
            </div>
            </br>
            <div class="form_row right">
                <div><button type="submit">Submit</button></div>
            </div>
        </form>
    </div>
</div>
</body>
</html>