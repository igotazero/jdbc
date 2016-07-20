<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Board &middot; Marketplace</title>
    <link href="css/top_pannel.css" rel="stylesheet">
    <link href="css/base.css" rel="stylesheet">
    <link href="css/table.css" rel="stylesheet">
    <link href="css/board.css" rel="stylesheet">
</head>
<body>
<div class="panel">
    <div class="logo left"><img src="res/images/logo2.png" height="30px" width="30px"></div>
    <div class="item left">|</div>
    <div class="item left"><a href="add.htm">Add product</a></div>
    <div class="image right"><a href="login.htm"><img src="res/images/exit.png"></a></div>
    <div class="item right"><a href="user_page.htm">qwerty</a></div>
    <div class="item right">$ 1.000.000</div>
</div>
<div class="cover">
    <div class="border">
        Find products
        <form id="span">
            <input id="search" type="text" name="find"/>
            by
            <select name="select">
                <option>ID</option>
                <option>Name</option>
                <option>Description</option>
            </select>
            <button type="submit">ok</button>
        </form>
    </div>
    <h3>Actual products</h3>
    <table>
        <tr id="header">
            <th>ID</th>
            <th>Title</th>
            <th>Description</th>
            <th>Price</th>
            <th>Bid inc.</th>
            <th>Best offer</th>
            <th>Bidder</th>
            <th>Stop date</th>
            <th>Bidding</th>
        </tr>
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Description</th>
            <th>Price</th>
            <th>Bid inc.</th>
            <th>Best offer</th>
            <th>Bidder</th>
            <th>Stop date</th>
            <th>Bidding</th>
        </tr>
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Description</th>
            <th>Price</th>
            <th>Bid inc.</th>
            <th>Best offer</th>
            <th>Bidder</th>
            <th>Stop date</th>
            <th>Bidding</th>
        </tr>
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Description</th>
            <th>Price</th>
            <th>Bid inc.</th>
            <th>Best offer</th>
            <th>Bidder</th>
            <th>Stop date</th>
            <th>Bidding</th>
        </tr>
    </table>
</div>
</body>
</html>