<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--@elvariable id="userJSP" type=""--%>
<jsp:include page="init.jsp"/>
<jsp:include page="header.jsp"/>
<section>

    <div class="container">
        <div class="col-sm-4 col-sm-offset-1">
            <h2>Edit your profile!</h2>
            <form:form method="POST" action="edit" modelAttribute="userJSP" class="form-signin form_register" id="jform" name = "form_register">
                <spring:bind path="firstName">
                    <div class="form-group ${status.error ? 'has-error' : ''}">
                        <form:input type="text" path="firstName" name="firstName" id="firstName" minLength="1" maxlength="32" class="form-control form_margin" placeholder="Username"
                                    autofocus="true" required="true" oninput="validate()"/> <span id="firstNameInfo" class="form_hint" style="background: #46b8da" >Enter username</span>
                        <form:errors path="firstName"/>
                    </div>
                </spring:bind>
                <spring:bind path="address">
                    <div class="form-group ${status.error ? 'has-error' : ''}">
                        <form:input type="text" path="address" name="address" id="address" minLength="10" class="form-control form_margin" placeholder="Address"
                                    autofocus="true" required="true" oninput="validate()"/> <span id="addressInfo" class="form_hint" style="background: #46b8da" >Enter address</span>
                        <form:errors path="address"/>
                    </div>
                </spring:bind>
                <button class="btn btn-default" type="submit" id="send">Submit</button>
                <form:form method="GET" action="/profile">
                    <button class="btn btn-default" type="submit">Cancel</button>
                </form:form>
            </form:form>
        </div>
        <div class="col-sm-1">
        </div>
        <div class="signup-form"><!--sign up form-->

        </div><!--/sign up form-->
    </div>

    <script>
        var jVal;
        function validate(){
            jVal = {
                'address' : function() {
                    $('body').append('<div id="addressInfo" class="info"></div>');
                    var aboutInfo = $('#addressInfo');
                    var ele = $('#address');
                    if(ele.val().length < 10) {
                        jVal.errorAddress = true;
                        aboutInfo.removeClass('hint_green').addClass('hint_red').html('at least 10 characters').show();
                    } else {
                        jVal.errorAddress = false;
                        aboutInfo.removeClass('hint_red').addClass('hint_green').html('Address correct').show();
                    }
                },
                'firstName' : function() {
                    $('body').append('<div id="firstNameInfo" class="info"></div>');
                    var aboutInfo = $('#firstNameInfo');
                    var ele = $('#firstName');
                    if(ele.val().length < 1) {
                        jVal.errorFirstName = true;
                        aboutInfo.removeClass('hint_green').addClass('hint_red').html('at least 1 characters').show();
                    } else {
                        jVal.errorFirstName = false;
                        aboutInfo.removeClass('hint_red').addClass('hint_green').html('First name correct').show();
                    }
                },
                'sendIt' : function (){
                    if((!jVal.errorFirstName)&&(!jVal.errorAddress)) {
                        $('#jform').submit();
                    }
                }
            };
// ====================================================== //
            $('#send').click(function (){
                var obj = $.browser.webkit ? $('body') : $('html');
                obj.animate({ scrollTop: $('#jform').offset().top }, 750, function (){
                    jVal.errorAddress = true;
                    jVal.address();
                    jVal.errorFirstName = true;
                    jVal.firstName()
                    jVal.sendIt();
                });
                return false;
            });
            $('#address').change(jVal.address);
            $('#firstName').change(jVal.firstName);
        };

        document.getElementById("address").addEventListener('keyup', validateAddress);
        function validateAddress() {
            jVal.address();
        }

        document.getElementById("firstName").addEventListener('keyup', validateAddress);
        function validateAddress() {
            jVal.firstName();
        }
    </script>
</section>
</body>
</html>
