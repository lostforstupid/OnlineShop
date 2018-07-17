<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="formatDate" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="formatTime" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="editorder" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="editproducts" uri="http://www.springframework.org/tags/form" %>
<%--@elvariable id="order" type=""--%>
<%--@elvariable id="productsInOrder" type=""--%>

<jsp:include page="init.jsp"></jsp:include>
<jsp:include page="header.jsp"></jsp:include>

<div class = "container">
    <editorder:form action = "save" method = "post" modelAttribute = "order">
        <p>"${order.user.username}"</p>
        <editorder:select path = "status" cssStyle = "width: 150px;">
            <editorder:option value = "NEW"></editorder:option>
            <editorder:option value = "PREPAID"></editorder:option>
            <editorder:option value = "DELIVERED"></editorder:option>
        </editorder:select>
    </editorder:form>
    <editproducts:form action = "/products_in_order/${order.id}/save" method="post" modelAttribute = "productsInOrder">
        <c:forEach items = "${productsInOrder}" var = "productInOrder" varStatus = "i">
            <%--<editproducts:input value = "${order.productsInOrder[${i.index}].product.name}" path = "product.name"></editproducts:input>--%>
            <editproducts:input value = "${productInOrder.quantity}" path = "${productInOrder.quantity}"></editproducts:input>
        </c:forEach>
    </editproducts:form>
    <button class = "btn btn-default">Save</button> <!-- this button should submit 2 forms (in JS) -->
</div>