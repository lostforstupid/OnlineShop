<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="init.jsp"></jsp:include>
<jsp:include page="header.jsp"></jsp:include>
<c:if test="${role == ADMIN}">
</c:if>
<section>
    <div class="container">
        <div class="row">
            <jsp:include page="categories.jsp"></jsp:include>
            <div class="col-sm-9 padding-right">
                <jsp:include page="products.jsp"></jsp:include>



