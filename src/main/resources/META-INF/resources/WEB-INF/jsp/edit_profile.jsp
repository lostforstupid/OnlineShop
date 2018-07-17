<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--@elvariable id="userJSP" type=""--%>
<jsp:include page="init.jsp"/>
<jsp:include page="header.jsp"/>
<section>
    <div>
        <div class="col-sm-4 col-sm-offset-1">
            <div class="login-form"><!--login form-->
                <h2>Edit your profile!</h2>
                <%--@elvariable id="userJSP" type=""--%>
                    <form:input type="text" path="username" class="form-control" placeholder="First name"
                                autofocus="true"/>
                <form:form method="POST" action="user/edit" modelAttribute="userJSP" class="form-signin">
                    <spring:bind path="name">
                        <div class="form-group ${status.error ? 'has-error' : ''}">
                            <form:input type="text" path="name" class="form-control" placeholder="First name"
                                        autofocus="true"/>
                            <form:errors path="username"/>
                        </div>
                    </spring:bind>
                    <spring:bind path="surname">
                        <div class="form-group ${status.error ? 'has-error' : ''}">
                            <form:input type="text" path="surname" class="form-control" placeholder="Second name"
                                        autofocus="true"/>
                            <form:errors path="surname"/>
                        </div>
                    </spring:bind>
                    <spring:bind path="address">
                        <div class="form-group ${status.error ? 'has-error' : ''}">
                            <form:input type="text" path="address" class="form-control" placeholder="Address"
                                        autofocus="true"/>
                            <form:errors path="address"/>
                        </div>
                    </spring:bind>
                    <spring:bind path="password">
                        <div class="form-group ${status.error ? 'has-error' : ''}">
                            <form:input type="password" path="password" class="form-control"
                                        placeholder="Password"/>
                            <form:errors path="password"/>
                        </div>
                    </spring:bind>
                    <spring:bind path="confirmPassword">
                        <div class="form-group ${status.error ? 'has-error' : ''}">
                            <form:input type="password" path="confirmPassword" class="form-control"
                                        placeholder="Confirm password"/>
                            <form:errors path="confirmPassword"/>
                        </div>
                    </spring:bind>
                    <button class="btn btn-lg btn-primary btn-block" type="submit">Submit</button>
                </form:form>
            </div><!--/login form-->
        </div>
        <div class="col-sm-1">
            <%--<h2 class="or">OR</h2>--%>
        </div>
    </div>
    </form>
    </div>
</section>
</body>
</html>
