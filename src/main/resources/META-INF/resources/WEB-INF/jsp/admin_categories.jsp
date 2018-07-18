<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="users" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="catalog" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="orders" uri="http://www.springframework.org/tags/form" %>

<div class="col-sm-3">
    <br>
    <br>
    <br>
    <div class="left-sidebar">

                    <users:form action = "/users" method="get">
                        <button class="orange admin-menu-button">Users</button>
                    </users:form>

                    <catalog:form action = "/catalog" method="get">
                        <button class="orange admin-menu-button">Products</button>
                    </catalog:form>

                    <orders:form action = "/orders" method="get">
                        <button class="orange admin-menu-button">Orders</button>
                    </orders:form>
    </div>
</div>