<%@ taglib prefix="spring" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>

<head>
    <title>Index Page</title>
</head>

<body>

<%--@elvariable id="userJSP" type=""--%>
<spring:form method="post"  modelAttribute="userJSP" action="enter">

    Name: <spring:input path="username"/> <br/>
    Password: <spring:input path="password"/> <br/>
    <spring:button>Sign in</spring:button>

</spring:form>

</body>

</html>
