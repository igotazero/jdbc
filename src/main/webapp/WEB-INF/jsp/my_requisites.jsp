<%@ taglib prefix="c" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>My requisites &middot; Marketplace</title>
    <link href="css/top_pannel.css" rel="stylesheet">
    <link href="css/base.css" rel="stylesheet">
    <link href="css/my_requisites.css" rel="stylesheet">
</head>
<body>
<div class="cover">
    <div class="panel">
        <div class="logo left"><img src="res/images/logo2.png" height="30px" width="30px"></div>
        <div class="item left">|</div>
        <div class="item left"><a href="board">Board</a></div>
        <div class="item left"><a href="add">Add product</a></div>
        <div class="image right"><a href="<c:url value="/logout" />"><img src="res/images/exit.png"></a></div>
        <div class="item right"><a href="user_page">${pageContext.request.userPrincipal.name}</a></div>
        <div class="item right">$ 1.000.000</div>
    </div>
    <h3>My requisites</h3> (<a id="nobr" href="change">change</a>)</br>
    <div class="table">
        <div class="row">
            <div class="cell first">Login:</div>
            <div class="cell">${login}</div>
        </div>
        <div class="row">
            <div class="cell first">Full name:</div>
            <div class="cell">${fullName}</div>
        </div>
        <div class="row">
            <div class="cell first">Billing adress:</div>
            <div class="cell">${address}</div>
        </div>
        <div class="row">
            <div class="cell first">Balance:</div>
            <div class="cell money">$ 1.000.000</div>
        </div>
    </div>
    </br>
    <div class="ants"/>
</div>
</body>
</html>