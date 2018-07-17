<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--@elvariable id="userJSP" type=""--%>
<jsp:include page="init.jsp"/>
<jsp:include page="header.jsp"/>
<section>
    <div>
        <div class="col-sm-4 col-sm-offset-1">
            <div class="login-form">
                <h2>Profile</h2>
                <c:if test="${pageContext.request.userPrincipal.name != null}">
                <form method="GET" action="${contextPath}/user/edit" class="form-signin">
                    <h2>Username: ${pageContext.request.userPrincipal.name}</h2>
                    <button class="btn btn-default" type="submit">Edit</button>
                </form>
                </c:if>
            </div>
        </div>
        <div class="col-sm-1">
        </div>
    </div>
    </form>
    </div>
</section>
</body>
</html>
