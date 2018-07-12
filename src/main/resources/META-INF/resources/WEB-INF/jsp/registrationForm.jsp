<%--@elvariable id="userJSP" type=""--%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<div class="container">
    <div class="col-sm-4 col-sm-offset-1">
        <h2>New User Signup!</h2>
        <form:form method="POST" action="registration" modelAttribute="userJSP" class="form-signin">
            <spring:bind path="username">
                <div class="form-group ${status.error ? 'has-error' : ''}">
                    <form:input type="text" path="username" class="form-control" placeholder="Username"
                                autofocus="true"/>
                    <form:errors path="username"/>
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
            <button class="btn btn-lg btn-primary btn-block" type="submit">Submit</button>
        </form:form>
    </div>
    <div class="col-sm-1">
    </div>
    <div class="signup-form"><!--sign up form-->

    </div><!--/sign up form-->
</div>
