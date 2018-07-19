<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="col-sm-3">
    <div class="left-sidebar">
        <h2>Category</h2>
        <div class="panel-group category-products" id="accordian"><!--category-productsr-->
            <form action="${pageContext.request.contextPath}/welcome">
            <c:forEach var="category" items="${categories}">

                            <script>
                                document.write('<div class="panel panel-default">');
                                    document.write('<div class="panel-heading">');
                                    document.write('<h4 class="panel-title">');
                                    document.write('<input type=submit class="category-button" name="category" value="${category}"/>');
                                    document.write('</h4>');
                                    document.write('</div>');
                                    document.write('</div>');

                            </script>

            </c:forEach>
            </form>
        </div><!--/category-products-->
    </div>
</div>
