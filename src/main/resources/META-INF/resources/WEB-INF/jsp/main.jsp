<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="init.jsp"/>
<jsp:include page="header.jsp"/>
<c:if test="${role == ADMIN}">
    <jsp:include page="add_product.jsp"></jsp:include>
</c:if>
<section>
    <div class="container">
        <div class="row">
            <jsp:include page="categories.jsp"/>
            <div class="col-sm-9 padding-right">
                <jsp:include page="products.jsp"/>



