<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="buy" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="addproduct" uri="http://www.springframework.org/tags/form" %>
    <%--@elvariable id="product" type=""--%>

<div class="container">
    <div class="row">
        <div class="col-sm-4 col-sm-offset-1">
            <div class="login-form"><!--/form for adding a product-->
                <h2>Add product</h2>
                <!--<form action="catalog">-->
                    <addproduct:form action = "catalog" method = "post" modelAttribute = "product">
                        <addproduct:input type = "text" path = "name"/>
                        <addproduct:input class = "product-price" path = "price"/>
                        <button type="submit" class="btn btn-default">Add product</button>
                    </addproduct:form>
                <!--</form>-->
            </div>
        </div>
    </div>
</div>
<br>
<br>
<br>