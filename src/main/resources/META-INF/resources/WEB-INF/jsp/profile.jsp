<%@ page contentType="text/html; charset=UTF-8" pageEncoding="utf-8" %>
<%@ page session="false"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--@elvariable id="userJSP" type=""--%>
<jsp:include page="init.jsp"/>
<jsp:include page="header.jsp"/>

<c:if test="${pageContext.request.userPrincipal.name != null}">
<script>
    var orderId = -2;
    var isOrder = true;
</script>

    <section>
        <table class="table-profile min-width-for-table">
            <tr class="tr-allorders-table">
                <td class="profile-orders-table"><h3><spring:message code="label.profile"/></h3></td>
                <td class="orders-table"><h3><spring:message code="label.yourOrders"/></h3></td>
            </tr>
            <tr>
                <td class="profile-table td-with-orders">
                    <div class="login-form">

                        <form method="GET" action="${pageContext.request.contextPath}/edit" class="form-signin">
                            <table>
                                <tr>
                                    <td><h2><spring:message code="label.userName"/>: </h2></td>
                                    <td><h2>${userJSP.username}</h2></td>
                                </tr>
                                <tr>
                                    <td><h2><spring:message code="label.address"/>: </h2></td>
                                    <td><h2> ${userJSP.address} </h2></td>
                                </tr>
                            </table>
                            <button class="btn btn-default" type="submit">Edit</button>
                        </form>
                    </div>
                </td>
                <td class="orders-table td-with-orders">
                    <table class="min-width-for-table">
                        <div class="login-form">
                              <c:choose>
                                    <%--@elvariable id="products" type="java.util.List"--%>
                                    <c:when test="${products.size() <= 0}">
                                        <tr>
                                            <td class="cart_description">
                                                <h4><a href=""> <spring:message code="message.buy.error"/> </a></h4>
                                            </td>
                                        </tr>
                                    </c:when>
                                    <c:otherwise>
                                        <table class="order-table-border table-width">
                                            <tr>
                                            <td class="table-center-left td-for-orders heavy-weight"><spring:message code="label.orderID"/></td>
                                            <td class="table-center-left td-for-orders heavy-weight"><spring:message code="label.status"/></td>
                                            <td class="table-center-left td-for-orders heavy-weight"><spring:message code="label.products"/></td></tr>
                                        </table>

                                            <c:forEach items="${products}" var="item">
                                                <table class="order-table-border table-width">
                                                <script>

                                                    if(${item.order.id}!=orderId){
                                                        orderId = ${item.order.id};
                                                        isOrder = true;
                                                        document.write('<tr>');
                                                        document.write('<td class="td-for-orders">${item.order.id}</td>');
                                                        document.write('<td class="td-for-orders">${item.order.status}</td>');
                                                        document.write(' <td class="td-for-orders"><button class="btn btn-primary btn-hover" onclick="showSpoiler(${item.order.id})">Show products</button></td>');
                                                        document.write(' </tr>');
                                                    }

                                                </script>
                                                </table>
                                              <table  class="hidden${item.order.id}" style="display: none">
                                                <tr>
                                                <script>

                                                if(isOrder){
                                                    document.write('<td class="table-center td-in-orders">Image</td>\n' +
                                                        '<td class="table-center td-in-orders"><spring:message code="label.name"/></td>\n' +
                                                        '<td class="table-center td-in-orders">Web ID</td>\n' +
                                                        '<td class="table-center td-in-orders"><spring:message code="label.price"/></td>\n' +
                                                        '<td class="table-center td-in-orders"><spring:message code="label.quantity"/></td></tr>');
                                                    document.write(' <tr class="hidden${item.order.id}" style="display: none">');
                                                    isOrder = false;
                                                }
                                                </script>
                                                    <td class="td-in-orders products-in-order-center"><img class="table-image"
                                                                                  src="${pageContext.request.contextPath}/images/products/${item.product.imageLink}"
                                                                                  alt=""/></td>
                                                    <td class="td-in-orders products-in-order-center">${item.product.name}</td>
                                                    <td class="td-in-orders products-in-order-center">${item.id}</td>
                                                    <td class="td-in-orders products-in-order-center">$${item.product.price}</td>
                                                    <td class="td-in-orders products-in-order-center">${item.quantity}</td>
                                                </tr>
                                              </table>
                                            </c:forEach>
                                    </c:otherwise>
                                </c:choose>

                        </div>
                    </table>
                </td>
            </tr>

        </table>
    </section>
</c:if>

</body>
</html>
<script type="text/javascript">
    var orderId ="";
    function showSpoiler(id) {
        var d = document;
        var allElem = d.querySelectorAll('.hidden'+id);

        for(var i = 0; i < allElem.length; i++){
            if (allElem[i].style.display === "none") allElem[i].style.display = ""; else allElem[i].style.display = "none";
        }

    }

    function saveOrder(newOrderId){
        orderId = newOrderId;
        alert(orderId);
    }
    function isTheSameOrderId(newOrderId) {
        return orderId === newOrderId;
    }

</script>