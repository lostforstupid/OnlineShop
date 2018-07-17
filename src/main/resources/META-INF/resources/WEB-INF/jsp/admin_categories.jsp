<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="col-sm-3">
    <div class="left-sidebar">

        <div class="panel panel-default">
            <div class="panel-heading">
                <h4 class="panel-title"><a href = "<c:url value="/users"/>" >Users</a></h4>
            </div>
        </div>

        <div class="panel panel-default">
            <div class="panel-heading">
                <h4 class="panel-title"><a href="<c:url value="/catalog"/>">Products</a></h4>
            </div>
        </div>

        <div class="panel panel-default">
            <div class="panel-heading">
                <h4 class="panel-title"><a href="<c:url value="/orders"/>">Orders</a></h4>
            </div>
        </div>
    </div>
</div>