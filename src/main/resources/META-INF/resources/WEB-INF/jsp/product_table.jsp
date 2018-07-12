<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="blocking" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="editing" uri="http://www.springframework.org/tags/form" %>
<%--@elvariable id="product" type=""--%>
<div class="table-responsive cart_info">
    <table class = "table table-condensed">
        <tr class = "cart_menu">
            <th>Name</th>
            <th>Price</th>
            <th>Edit</th>
        </tr>
        <c:forEach var = "product" items = "${productList}">
            <editing:form action = "products/${product.id}/edit" method = "get">
                <tr class = "cart_product">
                    <td>"${product.name}"</td>
                    <td>"${product.price}"</td>
                    <td><button type="submit" class="btn btn-default">Edit</button></td>
                </tr>
            </editing:form>
        </c:forEach>
    </table>
</div>