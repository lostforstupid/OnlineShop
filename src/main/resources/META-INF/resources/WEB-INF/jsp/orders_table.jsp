<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="blocking" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="editing" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="deleting" uri="http://www.springframework.org/tags/form" %>
<%--@elvariable id="order" type=""--%>
<div class="table-responsive cart_info">
    <table class = "table table-condensed">
        <tr class = "cart_menu">
            <th>Date and time</th>
            <th>User</th>
            <th>Status</th>
            <th>Products</th>
        </tr>
        <c:forEach var = "order" items = "${orderList}">
            <tr class = "cart_product">
                <td>"${order.dateAndTime}"</td>
                <td>"${order.user.username}"</td>
                <td>"${order.status}"</td>
                <td></td>
            </tr>
        </c:forEach>
    </table>
</div>