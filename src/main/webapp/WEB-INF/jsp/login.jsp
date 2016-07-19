<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Sign in &middot; Marketplace</title>
    <link href="../../css/base.css" rel="stylesheet">
    <link href="../../css/top_pannel.css" rel="stylesheet">
    <link href="../../css/form.css" rel="stylesheet">
    <script type='text/javascript' src='../../tools/jquery-3.0.0.min.js'></script>
    <script type='text/javascript' src='../../tools/validation.js'></script>
</head>
<body>
<div class="container">
    <div class="panel">
        <div class="item left"><a href="board.jsp">Board</a></div>
        <div class="item left"><a href="login.do">Registration</a></div>
    </div>
    <div class="background">
        <img src="../../res/images/logo.png">
        <form method="GET" onsubmit="return validate()">
            <div class="form_row">
                <div><input class="mess required login coincidence" type="text" name="login" placeholder="login"></div>
            </div>
            </br>
            <div class="form_row">
                <div><input class="mess required coincidence" type="password" name="password" placeholder="password"></div>
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