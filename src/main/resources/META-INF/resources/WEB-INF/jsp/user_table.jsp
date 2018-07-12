<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="blocking" uri="http://www.springframework.org/tags/form" %>
<%--@elvariable id="user" type=""--%>
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
                <td>"${user.role}"</td>
                <td>"${user.address}"</td>
                <td>
                    <blocking:form action = "block" method = "post" modelAttribute = "user">

                        <button type="submit" class="btn btn-default" href = "/admin/users/block">
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
            </tr>
        </c:forEach>
    </table>
</div>