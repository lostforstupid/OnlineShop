<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="buy" uri="http://www.springframework.org/tags/form" %>
<%@ page language="java" contentType="text/html; charset=US-ASCII"
         pageEncoding="US-ASCII"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">
    <title>Products</title>
    <style>
        table, tr, td {border: 1px solid grey; border-collapse: collapse;}
        table {width: 60%;}
        td {padding: 5px 0px 5px 0px;}
        td.count, td.buy {width: 15%; text-align: center;}
        td.name, td.price {padding-left: 10px;}
        td.name {width: 45%;}
        td.price {width: 25%;}
    </style>
</head>
<body>
<h1>Catalog</h1>
<table>
        <c:forEach var="product" items="${productList}">
            <tr>
                <td class = "name">${product.name}</td>
                <td class = "price">${product.price}</td>
                <td class = "count"><input type = "text" size = 5></td>
                <td class = "buy">
                    <buy:form>
                        <button type = "submit">Add to cart</button>
                    </buy:form>
                </td>
            </tr>
        </c:forEach>
</table>
</body>
</html>