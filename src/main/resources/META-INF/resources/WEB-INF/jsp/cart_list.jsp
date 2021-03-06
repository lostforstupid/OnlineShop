<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<section id="cart_items">
    <div class="container">
        <div class="breadcrumbs">
            <ol class="breadcrumb">
                <li><a href="#">Home</a></li>
                <li class="active">Shopping Cart</li>
            </ol>
        </div>
        <div class="table-responsive cart_info">
            <table class="table table-condensed">
                <thead>
                <tr class="cart_menu">
                    <td class="image">Item</td>
                    <td class="description"></td>
                    <td class="price">Price</td>
                    <td class="quantity">Quantity</td>
                    <td class="total">Total</td>
                    <td></td>
                </tr>
                </thead>
                <tbody>
                <c:choose>
                    <%--@elvariable id="products" type="java.util.List"--%>
                    <c:when test="${products.size() <= 0}">
                        <tr>
                            <td class="cart_description">
                                <h4><a href=""> You didn't add any product yet :( </a></h4>
                            </td>
                        </tr>
                    </c:when>
                    <c:otherwise>
                        <c:forEach items="${products}" var="item">
                            <tr>
                                <td class="cart_product">
                                    <a href=""><img class = "cart_img" src="${pageContext.request.contextPath}/images/products/${item.product.imageLink}" alt=""></a>
                                </td>
                                <td class="cart_description">
                                    <h4><a href="">${item.product.name}</a></h4>
                                    <p>Web ID: ${item.id}</p>
                                </td>
                                <td class="cart_price">
                                    <p>$${item.product.price}</p>
                                </td>
                                <td class="cart_quantity">
                                    <div class="cart_quantity_button">
                                        <a class="cart_quantity_up" href="/cart/${item.id}/inc"> + </a>
                                        <input class="cart_quantity_input" type="text" name="quantity"
                                               value=${item.quantity} size="2" readonly="readonly">
                                        <a href="/cart/${item.id}/decrement" class="cart_quantity_down"> - </a>
                                    </div>
                                </td>
                                <td class="cart_total">
                                    <p class="cart_total_price">$42</p>
                                </td>
                                <td class="cart_delete">
                                    <a class="cart_quantity_delete" href="/cart/${item.id}/delete"><i
                                            class="fa fa-times"></i></a>
                                </td>
                            </tr>
                        </c:forEach>
                    </c:otherwise>
                </c:choose>
                </tbody>
            </table>
            <div class="login-form">
                <form method="GET" action="${contextPath}/cart/payment" class="form-signin">
                    <h4>Final price: 000 $</h4>
                    <c:choose>
                        <c:when test="${products.size() <= 0}">
                            <button class="btn btn-default" type="submit" disabled = "disabled">Order</button>
                        </c:when>
                        <c:otherwise>
                            <button class="btn btn-disabled" type="submit" >Order</button>
                        </c:otherwise>
                    </c:choose>
                </form>
            </div>
        </div>
    </div>
</section>
<!--/#cart_items-->