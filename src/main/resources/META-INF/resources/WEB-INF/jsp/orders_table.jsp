<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="blocking" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="editing" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="deleting" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="show" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="formatDate" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="formatTime" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="edit" uri="http://www.springframework.org/tags/form" %>
<%--@elvariable id="order" type=""--%>

<div class="container">
    <table class = "table table-condensed orders-table">
        <tr>
            <th>User</th>
            <th>Date</th>
            <th>Time</th>
            <th>Status</th>
            <th>Products</th>
        </tr>
    </table>
        <c:forEach var = "order" items = "${orderList}">
            <table class = "orders-table">
                <tr>
                    <%--<edit:form action = "/orders/${order.id}/edit" method="get"--%>
                        <td class = "username">"${order.user.username}"</td>
                        <td class = "date"><formatDate:formatDate value = "${order.dateAndTime}" pattern = "dd.MM.yyyy"/></td>
                        <td class = "time"><formatTime:formatDate value = "${order.dateAndTime}" pattern = "hh:mm:ss"/></td>
                        <td class = "status">"${order.status}"</td>
                        <td class = "button">
                            <button class = "btn btn-default" onclick = "show(${order.id})">Show products</button>
                        </td>
                        <td class = "button">
                            <button class = "btn btn-default">Edit</button>
                        </td>
                    <%--</edit:form>--%>
                </tr>
            </table>

            <div id = "div${order.id}" style = "display: none;">

                <table class = "products">
                    <tr>
                        <th>Product</th>
                        <th>Quantity</th>
                        <th></th>
                    </tr>
                        <c:forEach var = "productInOrder" items = "${order.productsInOrder}">
                            <tr>
                                <td class = "name">${productInOrder.product.name}</td>
                                <td class = "quantity">${productInOrder.quantity}</td>
                            </tr>
                        </c:forEach>
                </table>
            </div>

        </c:forEach>
</div>