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
                        <c:forEach items="${products}" var="product">
                            <tr>
                                <td class="cart_product">
                                    <a href=""><img src="" alt=""></a>
                                </td>
                                <td class="cart_description">
                                    <h4><a href="">${product.name}</a></h4>
                                    <p>Web ID: ${product.id}</p>
                                </td>
                                <td class="cart_price">
                                    <p>$${product.price}</p>
                                </td>
                                <td class="cart_quantity">
                                    <div class="cart_quantity_button">
                                        <a class="cart_quantity_up" href=""> + </a>
                                        <input class="cart_quantity_input" type="text" name="quantity" value="1"
                                               autocomplete="off" size="2">
                                        <a href= "/cart/${product.id}/delete" class="cart_quantity_down"> - </a>
                                    </div>
                                </td>
                                <td class="cart_total">
                                    <p class="cart_total_price">$59</p>
                                </td>
                                <td class="cart_delete">
                                    <a class="cart_quantity_delete" href=""><i class="fa fa-times"></i></a>
                                </td>
                            </tr>
                        </c:forEach>
                    </c:otherwise>
                </c:choose>

                </tbody>
            </table>
        </div>
    </div>
</section>
<!--/#cart_items-->