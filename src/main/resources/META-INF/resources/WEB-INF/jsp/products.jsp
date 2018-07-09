<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="buy" uri="http://www.springframework.org/tags/form" %>
<%@ page language="java" contentType="text/html; charset=US-ASCII"
         pageEncoding="US-ASCII"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">
    <title>Products</title>
</head>
<body>
<h1>Catalog</h1>
<table style="width:100%">
        <c:forEach var="product" items="${productList}">
            <tr>
                <th>${product.name}</th>
                <th>${product.price}</th>
                <th><input type = text></th>
                <th><buy:form><button type = "submit">Add to cart</button></buy:form></th>
            </tr>
        </c:forEach>
</table>
</body>
</html>