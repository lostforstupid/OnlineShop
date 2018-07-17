<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="buy" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="editproduct" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="addproduct" uri="http://www.springframework.org/tags/form" %>
<%--@elvariable id="product" type=""--%>

<jsp:include page="init.jsp"></jsp:include>
<jsp:include page="header.jsp"></jsp:include>

<div class="container">
    <div class="row">
        <div class="col-sm-4 col-sm-offset-1">
            <div class="login-form">
                <div class="login-form">
                    <h2>Edit product</h2>
                        <editproduct:form action = "/products/${product.id}/save" method = "post" enctype="multipart/form-data" modelAttribute = "product">
                        <input type="file" class="btn btn-default" name="file" id="upload_hidden" style="position: absolute; display: block; overflow: hidden; width: 0; height: 0; border: 0; padding: 0;"
                           onchange="document.getElementById('upload_visible').value = this.value;" >
                        <input type="text" readonly="1" id="upload_visible"
                           onclick="document.getElementById('upload_hidden').click();" placeholder="Click here to upload image" />
                        <div class="form-group ${status.error ? 'has-error' : ''}">
                            <editproduct:input type = "text" path = "name" placeholder="Product name" value = "${product.name}"/>
                                <form:errors path="name"/>
                                    <div class="form-group ${status.error ? 'has-error' : ''}">
                                <editproduct:input class = "product-price" path = "price" placeholder="Price" value = "${product.price}"/>
                            <form:errors path="price"/>
                            <button type="submit" class="btn btn-default">Save product</button>
                        </editproduct:form>
                </div>
            </div>
        </div>
    </div>
</div>
<br>
<br>
<br>