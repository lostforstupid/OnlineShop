<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="buy" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="editproduct" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="addproduct" uri="http://www.springframework.org/tags/form" %>
<%--@elvariable id="product" type=""--%>

<jsp:include page="init.jsp"></jsp:include>
<jsp:include page="header.jsp"></jsp:include>

<div class="container">
    <div class="row">
        <div class="col-sm-4 col-sm-offset-1">
            <div class="login-form">
                <div class="login-form">
                    <h2>Edit product</h2>
                        <editproduct:form action = "/products" method = "post" enctype="multipart/form-data" modelAttribute = "product" class="form_signin form_register" id="jform" name = "form_register">
                        <input type="file" class="btn btn-default" name="file" id="upload_hidden" style="position: absolute; display: block; overflow: hidden; width: 0; height: 0; border: 0; padding: 0;"
                           onchange="document.getElementById('upload_visible').value = this.value;" >
                        <input type="text" readonly="1" id="upload_visible"
                           onclick="document.getElementById('upload_hidden').click();" placeholder="Click here to upload image" value = "${product.imageLink}"/>
                        <div class="form-group ${status.error ? 'has-error' : ''}">
                            <editproduct:input type = "text" path = "name" placeholder="Product name" value = "${product.name}"/>
                                <form:errors path="name"/>
                                    <div class="form-group ${status.error ? 'has-error' : ''}">
                                <editproduct:input class = "product-price" path = "price" placeholder="Price" value = "${product.price}"/>
                            <form:errors path="price"/>
                            <button type="submit" class="btn btn-default">Save product</button>
                        </editproduct:form>
                </div>
            </div>
        </div>
    </div>
</div>
<br>
<br>
<br>

        <script>
            var jVal;
            function validate(){
                jVal = {
                    'productName' : function() {
                        $('body').append('');
                        var productNameInfo = $('#productNameInfo');
                        var ele = $('#product_name');
                        if((ele.val().length < 2)||(ele.val().length > 32)) {
                            jVal.errorProductName = true;
                            productNameInfo.removeClass('hint_green').addClass('hint_red').html('must be 2 - 32 characters').show();
                        } else {
                            jVal.errorProductName = false;
                            productNameInfo.removeClass('hint_red').addClass('hint_green').html('correct').show();
                        }
                    },
                    'productPrice' : function() {
                        $('body').append('<div id="productPriceInfo" class="info"></div>');
                        var productPriceInfo = $('#productPriceInfo');
                        var ele = $('#product_price');
                        if(!((ele.val().length <= 7)&&(ele.val().length > 0)&&(parseInt(ele.val())>=1))) {
                            jVal.errorPrice = true;
                            productPriceInfo.removeClass('hint_green').addClass('hint_red').html('must be 1 - 7 positive digits').show();
                        } else {
                            jVal.errorPrice = false;
                            productPriceInfo.removeClass('hint_red').addClass('hint_green').html('correct').show();
                        }
                    },
                    'sendIt' : function (){
                        if((!jVal.errorProductName)&&(!jVal.errorPrice)) {
                            $('#jform').submit();
                        }
                    }
                };
// ====================================================== //
                $('#send').click(function (){
                    var obj = $.browser.webkit ? $('body') : $('html');
                    obj.animate({ scrollTop: $('#jform').offset().top }, 750, function (){
                        jVal.errorProductName = true;
                        jVal.errorPrice = true;
                        jVal.productName();
                        jVal.productPrice();
                        jVal.sendIt();
                    });
                    return false;
                });


                $('#product_name').change(jVal.productName);
                $('#product_price').change(jVal.productPrice);
            };

            document.getElementById("product_name").addEventListener('keyup', validateName);
            document.getElementById("product_price").addEventListener('keyup', validatePrice);
            function validateName() {
                jVal.productName();
            }
            function validatePrice() {
                jVal.productPrice();
            }

        </script>

    </div>
</div>