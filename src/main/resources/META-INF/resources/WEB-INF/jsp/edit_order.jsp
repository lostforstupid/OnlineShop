<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="formatDate" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="formatTime" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="editorder" uri="http://www.springframework.org/tags/form" %>
<%--@elvariable id="order" type=""--%>

<jsp:include page="init.jsp"></jsp:include>
<jsp:include page="header.jsp"></jsp:include>

<div class = "container">
    <editorder:form action = "save" method = "post" modelAttribute = "order">
        <editorder:input type = "text" path = "name" value = "${order.user.username}"/>
        <!--status-->
        <button class = "btn btn-default">Save</button>
    </editorder:form>
</div>