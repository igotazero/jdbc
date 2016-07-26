<%@ taglib prefix="c" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="core" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
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
    <c:url var="isAuth" value="${pageContext.request.userPrincipal.authenticated}" />
    <core:choose>
        <core:when test="${isAuth}">
            <div class="item left"><a href="add">Add product</a></div>
        </core:when>
        <core:otherwise>
            <div class="item left"><a href="login">Login</a></div>
            <div class="item left"><a href="registration">Registration</a></div>
        </core:otherwise>
    </core:choose>
    <core:if test="${isAuth}">
        <div class="image right"><a href="<c:url value="/logout" />"><img src="res/images/exit.png"></a></div>
        <div class="item right"><a href="user_page">${pageContext.request.userPrincipal.name}</a></div>
        <div class="item right">$ 1.000.000</div>
    </core:if>
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
    <core:if test="${not empty bidErr}">
        <div class="bid_err">${bidErr}</div>
    </core:if>
    <h3>Actual products</h3>
    <core:if test="${fn:length(tableItemList) > 0}">
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
                <th style="width: 120px;">Bidding</th>
            </tr>
            <core:forEach items="${tableItemList}" var="tableItem" varStatus="sataus">
                <tr>
                    <td class="cell_left">${tableItem.id}</td>
                    <td class="cell_left">${tableItem.title}</td>
                    <td class="cell_left">${tableItem.description}</td>
                    <td>${tableItem.price}</td>
                    <td>${tableItem.bidInc}</td>
                    <td>${tableItem.bestOffer}</td>
                    <td>${tableItem.bidder}</td>
                    <td>${tableItem.stopDate}</td>
                    <td class="cell_left">
                        <core:choose>
                        <core:when test="${tableItem.buyNow == '1'}">
                                <form id="row" action="buy.do" method="POST">
                                    <button name="buyButton" value="${tableItem.id}" type="submit" class="fullsize"
                                            <core:if test="${(empty pageContext.request.userPrincipal) ||
                                             (pageContext.request.userPrincipal.name == tableItem.sellerLogin)}">
                                                disabled="true"
                                            </core:if>
                                    >
                                        Buy it now!</button>
                                </form>
                        </core:when>
                            <core:otherwise>
                                <form action="bid.do" method="post">
                                    <input class="bid" type="number" name="bidValue"/>
                                    <button class="bid" type="submit" name="bidButton" value="${tableItem.id}"
                                            <core:if test="${(empty pageContext.request.userPrincipal) ||
                                             (pageContext.request.userPrincipal.name == tableItem.sellerLogin)}">
                                                disabled="true"
                                            </core:if>
                                    >Bid!</button>
                                    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                                </form>
                            </core:otherwise>
                        </core:choose>
                    </td>
                </tr>
            </core:forEach>
        </table>
    </core:if>
</div>
</body>
</html>