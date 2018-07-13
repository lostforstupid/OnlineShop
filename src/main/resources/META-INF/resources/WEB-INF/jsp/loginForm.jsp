<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<div class="container">
    <div class="row">
        <div class="col-sm-4 col-sm-offset-1">
            <div class="login-form"><!--login form-->
                <h2>Login to your account</h2>
                <form method="POST" action="${contextPath}/login" class="form-signin">
                    <div class="form-group ${error != null ? 'has-error' : ''}">
                        <span>${message}</span>
                        <input name="username" type="text" class="form-control" placeholder="Username"
                               autofocus="true"/>
                        <input name="password" type="password" class="form-control" placeholder="Password"/>
                        <span>${error}</span>
                        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                        <span>
                        <input type="checkbox" class="checkbox">
						Keep me signed in
                        </span>
                        <button class="btn btn-default" type="submit">Log In</button>
                        <h4 class="text-center"><a href="${contextPath}/registration">Create an account</a></h4>
                    </div>

                </form>
            </div><!--/login form-->
        </div>
        <div class="col-sm-1">
            <%--<h2 class="or">OR</h2>--%>
        </div>
    </div>
</div>
