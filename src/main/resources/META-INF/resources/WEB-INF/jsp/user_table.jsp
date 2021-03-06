<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="blocking" uri="http://www.springframework.org/tags/form" %>

<div class="container">
    <div class = "login-form">
    <h3 class = "navbar-header">Users</h3>
    <table class = "table table-condensed admin-table">
        <tr>
            <th>Username</th>
            <th>Role</th>
            <th>Address</th>
            <th>Block</th>
        </tr>
        <c:forEach var = "user" items = "${userList}">
            <tr>
                <td>"${user.username}"</td>
                <td>"${user.role}"</td>
                <td>"${user.address}"</td>
                <td>
                    <blocking:form action = "users/${user.id}/block" method = "post">

                        <c:if test = "${user.role != 'ADMIN'}">
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
                        </c:if>

                    </blocking:form>

                </td>
            </tr>
        </c:forEach>
    </table>
        </div>
</div>