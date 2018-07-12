<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="buy" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="addproduct" uri="http://www.springframework.org/tags/form" %>
    <%--@elvariable id="product" type=""--%>

<div class="container">
    <div class="row">
        <div class="col-sm-4 col-sm-offset-1">
            <div class="login-form">
                <div class="login-form">
                    <h2>Edit product</h2>
                        <addproduct:form action = "save" method = "post" modelAttribute = "product">
                            <addproduct:input type = "text" path = "name" value = "${product.name}"/>
                            <addproduct:input class = "product-price" path = "price" value = "${product.price}"/>
                            <button type="submit" class="btn btn-default">Save product</button>
                        </addproduct:form>
                </div>
            </div>
        </div>
    </div>
</div>
<br>
<br>
<br>