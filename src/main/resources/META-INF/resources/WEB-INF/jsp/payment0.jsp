<%--@elvariable id="message" type=""--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="init.jsp"/>
<jsp:include page="header.jsp"/>
<section>
    <div>
        <div class="container">
            <div class="row">
                <div class="col-sm-4 col-sm-offset-1">
                    <div class="login-form"><!--login form-->
                        <h2>To pay for your order - click on the button and in any convenient way for you</h2>
                        <form method="POST" action="${contextPath}/cart/order" class="form-signin">
                            <span class="message-success">${message}</span>
                            <%--@elvariable id="isPaid" type=""--%>
                            <c:choose>
                                <c:when test="${isPaid == false}">
                                    <button class="btn btn-default" type="submit">PAY</button>
                                </c:when>
                                <c:otherwise>
                                    <button class="btn btn-disabled" type="submit" disabled="disabled">PAY</button>
                                </c:otherwise>
                            </c:choose>
                            <h4 class="text-left"><a href="${contextPath}/cart">Back to the cart</a></h4>
                        </form>
                    </div><!--/login form-->
                </div>
            </div>
        </div>
    </div>
</section>
</body>
</html>
