<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="features_items"><!--features_items-->
    <h2 class="title text-center">Products</h2>

    <c:forEach var="product" items="${productList}">

        <div class="col-sm-4">
            <div class="product-image-wrapper">
                <div class="single-products parent-product">
                    <div class="productinfo text-center min-size image-fix-size">
                        <div class="border-for-image">
                            <img class="border-for-img"
                                 src="${pageContext.request.contextPath}/images/products/${product.imageLink}" alt=""/>
                        </div>
                        <h2>$${product.price}</h2>
                        <p>${product.name}</p>
                        <div class="for-cart">
                            <a href="#" class="btn btn-default add-to-cart"><i class="fa fa-shopping-cart"></i>Add
                                to cart</a>
                        </div>
                    </div>
                    <div class="product-overlay">
                        <div class="overlay-content">
                            <h2>$${product.price}</h2>
                            <p>${product.name}</p>
                            <a href="cart/${product.id}/add" class="btn btn-default add-to-cart"><i
                                    class="fa fa-shopping-cart"></i>Add to cart</a>
                        </div>
                    </div>
                </div>
            </div>
        </div>

    </c:forEach>

</div>
<!--features_items-->