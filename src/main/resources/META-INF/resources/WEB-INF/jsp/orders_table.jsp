<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="blocking" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="editing" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="deleting" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="show" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="formatDate" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="formatTime" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%--@elvariable id="order" type=""--%>

<div class="container">
    <table class = "table table-condensed">
        <tr>
            <th>User</th>
            <th>Date</th>
            <th>Time</th>
            <th>Status</th>
            <th>Products</th>
        </tr>
    </table>
        <c:forEach var = "order" items = "${orderList}">
            <table>
                <tr>
                    <td>"${order.user.username}"</td>
                    <td><formatDate:formatDate value = "${order.dateAndTime}" pattern = "dd.MM.yyyy"/></td>
                    <td><formatTime:formatDate value = "${order.dateAndTime}" pattern = "hh:mm:ss"/></td>
                    <td>"${order.status}"</td>
                    <td>
                        <%--<show:form action = "orders/${order.id}" method = "get"/>--%>
                            <button class = "btn btn-default" onclick = "show(${order.id})">Show products</button>
                        <%--</show:form>--%>
                    </td>
                </tr>
            </table>

            <div id = "div${order.id}" style = "display: none;">
                <table>
                    <tr>
                        <th>Product</th>
                        <th>Quantity</th>
                    </tr>
                        <%--<c:forEach var = "productInOrder" items = "${productsInOrder}">--%>
                        <tr>
                            <td><%--${productInOrder.product.name}--%> Product8</td>
                            <td><%--${productInOrder.quantity}--%> 5</td>
                        </tr>
                        <tr>
                            <td><%--${productInOrder.product.name}--%> Product23</td>
                            <td><%--${productInOrder.quantity}--%> 40</td>
                        </tr>
                        <%--</c:forEach>--%>
                </table>
            </div>

        </c:forEach>
</div>