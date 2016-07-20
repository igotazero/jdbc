<%@ taglib prefix="c" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Add product &middot; Marketplace</title>
    <link href="css/top_pannel.css" rel="stylesheet">
    <link href="css/base.css" rel="stylesheet">
    <link href="css/form.css" rel="stylesheet">
    <link href="css/add.css" rel="stylesheet">
    <script type='text/javascript' src='tools/jquery-3.0.0.min.js'></script>
    <script type='text/javascript' src='tools/validation.js'></script>
    <script type='text/javascript' src='tools/checkbox.js'></script>
</head>
<body>
<div class="container">
    <div class="panel">
        <div class="logo left"><img src="res/images/logo2.png" height="30px" width="30px"></div>
        <div class="item left">|</div>
        <div class="item left"><a href="board">Board</a></div>
        <div class="image right"><a href="<c:url value="/logout" />"><img src="res/images/exit.png"></a></div>
        <div class="item right"><a href="user_page">qwerty</a></div>
        <div class="item right">$ 1.000.000</div>
    </div>
    <div class="background">
        <h3>Add/edit product</h3>
        </br>
        <form onsubmit="return validate()">
            <div class="form_row">
                <div>Name</div>
                <div><input class="styled mess required" type="text" name="title"></div>
            </div>
            </br>
            <div class="form_row">
                <div>Description</div>
                <div><textarea class="mess required" name="description" rows="3"></textarea></div>
            </div>
            </br>
            <div class="form_row">
                <div>Start price</div>
                <div><input class="styled mess required" type="number" name="start_price" min="0" step="0.1"></div>
            </div>
            </br>
            <div class="form_row">
                <div></div>
                <div>Buy it now<input type="checkbox" name="buy_it_now" onchange="labelsVisible(this);"></div>
            </div>
            </br>
            <div class="form_row">
                <div>Gap</div>
                <div><input class="styled" type="number" name="gap" min="0" step="0.1"></div>
            </div>
            </br>
            <div class="form_row">
                <div>Time left</div>
                <div><input class="styled" type="number" name="time_left" min="0"></div>
            </div>
            </br>
            <div class="form_row right">
                <div><button type="submit">Publish / Save</button></div>
            </div>
        </form>
    </div>
</div>
</body>
</html>