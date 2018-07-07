<%--
  Created by IntelliJ IDEA.
  User: goponenko
  Date: 07.07.2018
  Time: 15:29
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Registration</title>
</head>
<body>
<%--@elvariable id="userJSP" type=""--%>
Sorry, but your username/password is wrong!
<spring:form method="post"  modelAttribute="userJSP" action="enter">

    Name: <spring:input path="username"/> <br/>
    Password: <spring:input path="password"/> <br/>
    <spring:button>Sign in</spring:button>

</spring:form>
</body>
</html>
