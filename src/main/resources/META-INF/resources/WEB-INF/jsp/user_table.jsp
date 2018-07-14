<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="blocking" uri="http://www.springframework.org/tags/form" %>

<div class="table-responsive cart_info">
    <table class = "table table-condensed">
        <tr class = "cart_menu">
            <th>Username</th>
            <th>Role</th>
            <th>Address</th>
            <th>Block</th>
        </tr>
        <c:forEach var = "user" items = "${userList}">
            <tr class = "cart_product">
                <td>"${user.username}"</td>
                <td>"${user.roleEnum}"</td>
                <td>"${user.address}"</td>
                <td>
                    <blocking:form action = "users/${user.id}/block" method = "post">

                        <c:if test = "${user.roleEnum != 'ADMIN'}">
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