<%@ taglib prefix="c" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="core" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>My profile &middot; Marketplace</title>
    <link href="css/top_pannel.css" rel="stylesheet">
    <link href="css/base.css" rel="stylesheet">
    <link href="css/table.css" rel="stylesheet">
</head>
<body>
<div class="panel">
    <div class="logo left"><img src="res/images/logo2.png" height="30px" width="30px"></div>
    <div class="item left">|</div>
    <div class="item left"><a href="board">Board</a></div>
    <div class="item left"><a href="add">Add product</a></div>
    <div class="item left"><a href="my_requisites">My requisites</a></div>
    <div class="image right"><a href="<c:url value="/logout" />"><img src="res/images/exit.png"></a></div>
    <div class="item right"><a href="user_page">${pageContext.request.userPrincipal.name}</a></div>
    <div class="item right">$ 1.000.000</div>
</div>
<div class="cover">
    <h3>My products</h3>
        <core:if test="${fn:length(productList) > 0}">
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
                <core:forEach items="${productList}">
                    <tr>
                        <td>${product.id}</td>
                        <td>${product.name}</td>
                        <td>${product.description}</td>
                        <td>${product.price}</td>
                        <td>${product.gap}</td>
                        <td>-</td>
                        <td>-</td>
                        <td>${product.startBiddingDate + product.hours}</td>
                    </tr>
                </core:forEach>
            </table>
        </core:if>
    <div><h3>Pending payment</h3></div>
    <div class="ants"/>
</div>
</body>
</html>