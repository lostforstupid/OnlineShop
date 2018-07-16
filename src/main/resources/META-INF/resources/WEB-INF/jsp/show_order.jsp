<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="formatDate" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="formatTime" uri="http://java.sun.com/jsp/jstl/fmt" %>

<jsp:include page="init.jsp"></jsp:include>
<jsp:include page="header.jsp"></jsp:include>

<div class = "container">
    <div>
        <p><b>User:</b>    ${order.user.username}</p>
        <p><b>Order date:</b>    <formatDate:formatDate value = "${order.dateAndTime}" pattern = "dd.MM.yyyy"/></p>
        <p><b>Order time:</b>    <formatTime:formatDate value = "${order.dateAndTime}" pattern = "hh:mm"/></p>
        <p><b>Status:</b>    ${order.status}</p>
    </div>
    <table>
        <tr>
            <th>Product</th>
            <th>Quantity</th>
        </tr>
        <c:forEach var = "productInOrder" items = "${productsInOrder}">
            <tr>
                <td>${productInOrder.product.name}</td>
                <td>${productInOrder.quantity}</td>
            </tr>
        </c:forEach>
    </table>
</div>