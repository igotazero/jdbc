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
    <link href="css/errors.css" rel="stylesheet">
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
    <core:if test="${not empty bidErr}"><div class="err">${bidErr}</div></core:if>
    <core:if test="${not empty upMsg}"><div class="msg">${upMsg}</div></core:if>
    <core:if test="${fn:length(tableItemList) > 0}">
        <table>
            <tr id="header">
                <th>ID</th>
                <th>Title</th>
                <th>Description</th>
                <th>Price</th>
                <th>Bid inc.</th>
                <th>Best offer</th>
                <th>Bidder / Buyer</th>
                <th>Stop date</th>
            </tr>
            <core:forEach items="${tableItemList}" var="tableItem" varStatus="sataus">
                <tr <core:if test="${tableItem.inCart == '1'}">class="incard"</core:if>>
                    <td class="cell_left">${tableItem.id}</td>
                    <td class="cell_left">${tableItem.title}</td>
                    <td class="cell_left">${tableItem.description}</td>
                    <td>${tableItem.price}</td>
                    <td>${tableItem.bidInc}</td>
                    <td>${tableItem.bestOffer}</td>
                    <td>${tableItem.bidder}</td>
                    <td>${tableItem.stopDate}</td>
                </tr>
            </core:forEach>
        </table>
    </core:if>
    <div><h3>My cart</h3></div>
    <core:if test="${not empty upMsgDeals}"><div class="msg">${upMsgDeals}</div></core:if>
    <core:if test="${fn:length(cartItemList) > 0}">
        <table>
            <tr id="header">
                <th>ID</th>
                <th>Title</th>
                <th>Description</th>
                <th>Deal date</th>
                <th>Seller</th>
                <th>Total Price</th>
            </tr>
            <core:forEach items="${cartItemList}" var="cardItem" varStatus="sataus">
                <tr>
                    <td class="cell_left">${cardItem.productId}</td>
                    <td class="cell_left">${cardItem.title}</td>
                    <td class="cell_left">${cardItem.description}</td>
                    <td>${cardItem.dealTime}</td>
                    <td>${cardItem.seller}</td>
                    <td>${cardItem.bidPrice}</td>
                </tr>
            </core:forEach>
        </table>
    </core:if>
    <div class="ants"/>
</div>
</body>
</html>