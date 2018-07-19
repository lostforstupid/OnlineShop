<%@ page contentType="text/html; charset=UTF-8" pageEncoding="utf-8" %>
<%@ page session="false"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--@elvariable id="userJSP" type=""--%>
<jsp:include page="init.jsp"/>
<jsp:include page="header.jsp"/>
<section>
    <div>
        <c:if test="${pageContext.request.userPrincipal.name != null}">
            <div class="col-sm-4 col-sm-offset-1">
                <div class="login-form">
                    <h3><spring:message code="label.profile"/></h3>

                    <form method="GET" action="${pageContext.request.contextPath}/edit" class="form-signin">
                        <h2><spring:message code="label.userName"/>: ${userJSP.username} </h2>
                        <h2><spring:message code="label.address"/>: ${userJSP.address} </h2>
                        <button class="btn btn-default" type="submit"><spring:message code="label.edit"/></button>
                    </form>
                </div>
                <div class="login-form">
                    <form method="GET" action="${pageContext.request.contextPath}/edit" class="form-signin">
                        <h3><spring:message code="label.yourOrders"/></h3>
                        <c:choose>
                            <%--@elvariable id="products" type="java.util.List"--%>
                            <c:when test="${products.size() <= 0}">
                                <tr>
                                    <td class="cart_description">
                                        <h4><a href=""> <spring:message code="message.buy.error"/> </a></h4>
                                    </td>
                                </tr>
                            </c:when>
                            <c:otherwise>
                                <c:forEach items="${products}" var="item">
                                    <h4><spring:message code="label.name"/>: <a href="">${item.product.name}</a></h4>
                                    <p>Web ID: ${item.id}</p>
                                    <p><spring:message code="label.price"/>: $${item.product.price}</p>
                                    <p><spring:message code="label.quantity"/>: ${item.quantity}</p>
                                </c:forEach>
                            </c:otherwise>
                        </c:choose>
                    </form>
                </div>
            </div>
        </c:if>
    </div>
    </form>
    </div>
</section>
</body>
</html>
