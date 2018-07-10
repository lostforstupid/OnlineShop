<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="buy" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="addproduct" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html; charset=US-ASCII"
         pageEncoding="US-ASCII"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">
    <style>
        table-add-product, .table-add-product tr, .table-add-product td {border: none;}
        .product-name {width: 200px;}
        .product-price {width: 70px;}
        .td1 {width: 210px;}
        .td2 {width: 80px;}
    </style>
</head>
<body>
    <h1>Add product</h1>
    <%--@elvariable id="product" type=""--%>
    <addproduct:form action = "catalog" method = "post" modelAttribute = "product">
        <table class = "table-add-product">
            <tr>
                <td class = "td1"><label>Product name:</label></td>
                <td class = "td2"><label>Price:</label></td>
                <td class = "td3"></td>
            </tr>
            <tr>
                <td><addproduct:input class = "product-name" path = "name"/></td>
                <td><addproduct:input class = "product-price" path = "price"/></td>
                <td><input class = "add-product" type = "submit" value = "Add product"/></td>
            </tr>
        </table>
    </addproduct:form>
</body>
</html>