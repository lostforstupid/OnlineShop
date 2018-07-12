<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="blocking" uri="http://www.springframework.org/tags/form" %>
<%--@elvariable id="user" type=""--%>
<table>
    <tr>
        <th>Username</th>
        <th>Role</th>
        <th>Blocked</th>
        <th>Address</th>
    </tr>
    <tr>
        <c:forEach var = "user" items = "${userList}">
            <td>"${user.username}"</td>
            <td>"${user.role}"</td>
            <td>
                <blocking:form action = "block" method = "post" modelAttribute = "user">

                    <button type="submit" class="btn btn-default">
                        <c:choose>
                            <c:when test="${user.isBlocked == 'false'}">
                                Block
                            </c:when>
                            <c:otherwise>
                                Unblock
                            </c:otherwise>
                        </c:choose>
                    </button>

                </blocking:form>
            </td>
            <td>"${user.address}"</td>
        </c:forEach>
    </tr>
</table>