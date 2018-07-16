<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--@elvariable id="userJSP" type=""--%>
<jsp:include page="init.jsp"/>
<jsp:include page="header.jsp"/>
<section>
    <div>
        <c:if test="${pageContext.request.userPrincipal.name != null}">
        <div class="col-sm-4 col-sm-offset-1">
            <div class="login-form">
                <h3>Profile</h3>

                    <form method="GET" action="${contextPath}/user/edit" class="form-signin">
                        <h2>Username: ${pageContext.request.userPrincipal.name}</h2>
                        <button class="btn btn-default" type="submit">Edit</button>
                    </form>
            </div>
            <div class="login-form">
                    <form method="GET" action="${contextPath}/user/edit" class="form-signin">
                        <h3>Your orders</h3>
                        <c:choose>
                            <%--@elvariable id="products" type="java.util.List"--%>
                            <c:when test="${products.size() <= 0}">
                                <tr>
                                    <td class="cart_description">
                                        <h4><a href=""> You didn't add any product yet :( </a></h4>
                                    </td>
                                </tr>
                            </c:when>
                            <c:otherwise>
                                <c:forEach items="${products}" var="item">
                                    <tr>
                                        <td><a href="${item.product.imageLink}"><img src="" alt=""></a></td>
                                        <td><h4><a href="">${item.product.name}</a></h4></td>
                                        <td><p>Web ID: ${item.id}</p></td>
                                        <td><p>$${item.product.price}</p></td>
                                        <td><p>${item.quantity}</p></td>
                                    </tr>
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
