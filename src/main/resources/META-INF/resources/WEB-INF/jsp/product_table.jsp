<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="blocking" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="editing" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="deleting" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="add" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="filter" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%--@elvariable id="product" type=""--%>

<div class = "container">
    <div class = "login-form">
            <table>
                <tr>
                    <td>
                        <h3 class = "navbar-header">Products</h3><br><br>
                        <add:form action = "/products/add" method="get">
                            <button class="btn btn-default" type = "submit">Add product</button>
                        </add:form>
                    </td>
                    <td>
                            <select id = "category" style = "width: 250px;" onchange = "filter(${fn:length(productList)})">
                                <option value = "ALL">ALL</option>
                                <option value = "STAR_TREK">STAR_TREK</option>
                                <option value = "STAR_WARS">STAR_WARS</option>
                                <option value = "WARHAMMER_40000">WARHAMMER_40000</option>
                                <option value = "START_CITIZEN">START_CITIZEN</option>
                                <option value = "EVE_ONLINE">EVE_ONLINE</option>
                                <option value = "ELITE_DANGEROUS">ELITE_DANGEROUS</option>
                            </select>
                    </td>
                </tr>
            </table>
    </div>
    <table class = "table table-condensed">
        <tr>
            <th>Image</th>
            <th>Name</th>
            <th>Price</th>
            <th>Category</th>
            <th>Edit</th>
        </tr>
        <c:forEach var = "product" items = "${productList}">
                <tr display = "block" id = "tr${product.id}">
                    <td><img style = "height: 40px;" src = "${pageContext.request.contextPath}/images/products/${product.imageLink}"></td>
                    <td>${product.name}</td>
                    <td>$${product.price}</td>
                    <td><p id = "${product.id}">${product.category}</p></td>
                    <td>
                        <div class = "login-form">
                            <editing:form action = "${pageContext.request.contextPath}/products/${product.id}/edit" method = "get">
                                <button type="submit" class="btn btn-default ">Edit</button>
                            </editing:form>
                        </div>
                    </td>
                </tr>
        </c:forEach>
    </table>
</div>

<script>
    function filter(size) {
        var categoryBox = document.getElementById("category");
        var category = (categoryBox.options[categoryBox.selectedIndex]).value;

        if (category == 'ALL') {
            for (var i = 1; i <= size; i++) {
                document.getElementById('tr' + i.toString()).style.display = 'block';
            }
        } else {
            for (var i = 1; i <= size; i++) {

                if ((document.getElementById(i.toString())).innerText == category) {
                    document.getElementById('tr' + i.toString()).style.display = 'block';
                } else {
                    document.getElementById('tr' + i.toString()).style.display = 'none';
                }
            }
        }
    }

</script>