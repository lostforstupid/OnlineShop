<!DOCTYPE html>

<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Cart</title>
</head>
<body>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<h1>List of products</h1>

<div>
    <table border="5" width="65%">
        <tr>
            <th>Id</th>
            <th>Name</th>
            <th>Price</th>
            <th>Count</th>
        </tr>
        <%--@elvariable id="products" type="java.util.List"--%>
        <c:forEach items="${products}" var="product"><%--@elvariable id="productService" type=""--%>
            <tr>
                <td>${product.id}</td>
                <td>${product.name}</td>
                <td>${product.price}</td>
                <td>Infinity</td>
                <td>
                    <form:form action="/cart/${product.id}/delete" method="post">
                        <input type="submit" value="Delete"/>
                    </form:form>
                </td>
            </tr>
        </c:forEach>
    </table>
</div>

</body>
</html>