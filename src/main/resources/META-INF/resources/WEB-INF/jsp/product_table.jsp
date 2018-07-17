<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="blocking" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="editing" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="deleting" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="add" uri="http://www.springframework.org/tags/form" %>
<%--@elvariable id="product" type=""--%>

<div class = "container">
    <div class = "login-form">
        <add:form action = "/products/add" method="get">
            <h3 class = "navbar-header">Products</h3><br>
            <button style="margin-left: 40px;" class="btn btn-default" type = "submit">Add product</button>
        </add:form>
    <table class = "table table-condensed">
        <tr>
            <th>Image</th>
            <th>Name</th>
            <th>Price</th>
            <th>Edit</th>
        </tr>
        <c:forEach var = "product" items = "${productList}">
                <tr>
                    <td><img style = "height: 40px;" src = "${pageContext.request.contextPath}/images/products/${product.imageLink}"></td>
                    <td>"${product.name}"</td>
                    <td>"${product.price}"</td>
                        <editing:form action = "products/${product.id}/edit" method = "get">
                            <td><button type="submit" class="btn btn-default">Edit</button></td>
                        </editing:form>
                </tr>
        </c:forEach>
    </table>
    </div>
</div>