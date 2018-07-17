<%--@elvariable id="userJSP" type=""--%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<div class="container">
    <div class="col-sm-4 col-sm-offset-1">

      <h2>New User Signup!</h2>
        <form:form method="POST" action="registration" modelAttribute="userJSP" class="form-signin form_register" id="jform" name = "form_register">
            <spring:bind path="username">
                <div class="form-group ${status.error ? 'has-error' : ''}">
                    <form:input type="text" path="username" name="username" id="username" minLength="6" maxlength="32" class="form-control form_margin" placeholder="Username"
                                autofocus="true" required="true" oninput="validate()"/> <span id="nameInfo" class="form_hint" style="background: #46b8da" >Enter username</span>
                    <form:errors path="username"/>
                </div>
            </spring:bind>
            <spring:bind path="address">
                <div class="form-group ${status.error ? 'has-error' : ''}">
                    <form:input type="text" path="address" name="address" id="address" minLength="10" class="form-control form_margin" placeholder="Address"
                                autofocus="true" required="true" oninput="validate()"/> <span id="addressInfo" class="form_hint" style="background: #46b8da" >Enter address</span>
                    <form:errors path="address"/>
                </div>
            </spring:bind>
            <spring:bind path="password">
                <div class="form-group ${status.error ? 'has-error' : ''}">
                    <form:input type="password" path="password" name="password" minLength="8" maxlength="32" id="password" class="form-control form_margin"
                                placeholder="Password" required="true" oninput="validate()"/> <span id="passwordInfo" class="form_hint" style="background: #46b8da">Enter password</span>
                    <form:errors path="password"/>
                </div>
            </spring:bind>
            <button class="btn btn-lg btn-primary btn-block" type="submit" id="send">Submit</button>
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
            'userName' : function() {
                $('body').append('');
                var nameInfo = $('#nameInfo');
                var ele = $('#username');
                if((ele.val().length < 6)||(ele.val().length > 32)) {
                    jVal.errorUsername = true;
                    nameInfo.removeClass('hint_green').addClass('hint_red').html('must be 6 - 32 characters').show();
                } else {
                    jVal.errorUsername = false;
                    nameInfo.removeClass('hint_red').addClass('hint_green').html('Username correct').show();
                }
            },
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
            'password' : function() {
                $('body').append('<div id="passwordInfo" class="info"></div>');
                var aboutInfo = $('#passwordInfo');
                var ele = $('#password');
                if((ele.val().length < 8)||(ele.val().length > 32)) {
                    jVal.errorPassword = true;
                    aboutInfo.removeClass('hint_green').addClass('hint_red').html('must be 8 - 32 characters').show();
                } else {
                    jVal.errorPassword = false;
                    aboutInfo.removeClass('hint_red').addClass('hint_green').html('Password correct').show();
                }
            },
            'sendIt' : function (){
                if((!jVal.errorUsername)&&(!jVal.errorAddress)&&(!jVal.errorPassword)) {
                    $('#jform').submit();
                }
            }
        };
// ====================================================== //
        $('#send').click(function (){
            var obj = $.browser.webkit ? $('body') : $('html');
            obj.animate({ scrollTop: $('#jform').offset().top }, 750, function (){
                jVal.errorUsername = true;
                jVal.errorAddress = true;
                jVal.errorPassword = true;
                jVal.userName();
                jVal.address();
                jVal.password();
                jVal.sendIt();
            });
            return false;
        });
        $('#username').change(jVal.userName);
        $('#address').change(jVal.address);
        $('#password').change(jVal.password);
    };

    document.getElementById("username").addEventListener('keyup', validateName);
    document.getElementById("address").addEventListener('keyup', validateAddress);
    document.getElementById("password").addEventListener('keyup', validatePassword);
    function validateName() {
        jVal.userName();
    }
    function validateAddress() {
        jVal.address();
    }
    function validatePassword() {
        jVal.password();
    }
</script>