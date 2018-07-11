<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<!DOCTYPE html>
<html lang="en"><jsp:include page="init.jsp"></jsp:include>
<jsp:include page="header.jsp"></jsp:include>
<section>
    <div>
        <jsp:include page="registrationForm.jsp"></jsp:include>
    </div>
    ${userJSP.name} Hi
</section>
</body>
</html>
</html>
