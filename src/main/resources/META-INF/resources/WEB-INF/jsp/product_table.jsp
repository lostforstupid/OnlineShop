<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="blocking" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="editing" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="deleting" uri="http://www.springframework.org/tags/form" %>
<%--@elvariable id="product" type=""--%>
<div class = "container">
    <table class = "table table-condensed">
        <tr>
            <th>Image</th>
            <th>Name</th>
            <th>Price</th>
            <th>Edit</th>
            <th>Delete</th>
        </tr>
        <c:forEach var = "product" items = "${productList}">
                <tr>
                    <td><img style = "height: 30px;" src = "${pageContext.request.contextPath}/images/products/${product.imageLink}"></td>
                    <td>"${product.name}"</td>
                    <td>"${product.price}"</td>
                    <editing:form action = "products/${product.id}/edit" method = "get">
                        <td><button type="submit" class="btn btn-default">Edit</button></td>
                    </editing:form>
                    <deleting:form action = "products/${product.id}/delete" method = "post">
                        <td><button type="submit" class="btn btn-default">Delete</button></td>
                    </deleting:form>
                </tr>
        </c:forEach>
    </table>
</div>