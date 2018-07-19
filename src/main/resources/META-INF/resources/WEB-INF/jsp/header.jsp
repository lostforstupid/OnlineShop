<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<header>
    <div class="header-middle"><!--header-middle-->
        <div class="container">
            <div class="row">
                <div class="col-sm-4">
                    <div class="logo pull-left">
                        <a href="/welcome"><img src="${pageContext.request.contextPath}/images/content/logo.png" /></a>
                    </div>
                    <div class="btn-group pull-right">
                        <div class="btn-group">
                            <button type="button" class="btn btn-default dropdown-toggle usa" data-toggle="dropdown">
                                English <!-- ADD HERE LANGUAGE SWITCHER-->
                                <span class="caret"></span>
                            </button>
                            <ul class="dropdown-menu">
                                <li><a href="#">Canada</a></li>
                                <li><a href="#">UK</a></li>
                            </ul>
                        </div>

                    </div>
                </div>
                <div class="col-sm-8">
                    <div class="shop-menu pull-right">
                        <ul class="nav navbar-nav">
                            <c:if test="${pageContext.request.remoteUser != null}">
                                <li><a href="/cart"><img src="${pageContext.request.contextPath}/images/content/cart.png" /> Cart</a></li>
                                <li><a href="/profile"><img src="${pageContext.request.contextPath}/images/content/profile.png" /> Profile</a></li>
                                <li><a href="/logout"><img src="${pageContext.request.contextPath}/images/content/logout.png" /> Logout</a></li>
                            </c:if>
                            <c:if test="${pageContext.request.remoteUser == null}">
                                <li><a href="login"><img src="${pageContext.request.contextPath}/images/content/login.png" /> Login</a></li>
                            </c:if>
                        </ul>
                    </div>
                </div>
            </div>
        </div>
    </div><!--/header-middle-->

    <div class="header-bottom"><!--header-bottom-->
        <div class="container">
            <div class="row">
                <div class="col-sm-9">
                    <div class="navbar-header">
                        <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
                            <span class="sr-only">Toggle navigation</span>
                            <span class="icon-bar"></span>
                            <span class="icon-bar"></span>
                            <span class="icon-bar"></span>
                        </button>
                    </div>

                </div>
            </div>
        </div>
    </div><!--/header-bottom-->
</header><!--/header-->