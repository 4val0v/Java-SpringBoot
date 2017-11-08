<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<!DOCTYPE html>
<html lang="en">
<head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta http-equiv="X-UA-Compatible" content="ie=edge">
        <title>Shop Product Categories</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
</head>
<body>
<div class=container>
<div class=row>

<div class="col-sm-4">
	<p>&nbsp;</p>
	<h3>New Product</h3>
	<form:form method="POST" action="/products/new" modelAttribute="product">
		<p>
		<form:label path="name">Name<br>
		<form:input path="name"/><br>
		<small style=color:red><form:errors path="name"/></small>
		</form:label>
		</p>
		<p>
		<form:label path="description">Description<br>
		<form:textarea path="description"/><br>
		<small style=color:red><form:errors path="description"/></small>
		</form:label>
		</p>
		<p>
		<form:label path="price">Price<br>
		<form:input path="price"/><br>
		<small style=color:red><form:errors path="price"/></small>
		</form:label>
		</p>
		<p><input class="btn btn-primary" type="submit" value="Add Product"/></p>
	</form:form>
</div>

<div class="col-sm-4">
	<p>&nbsp;</p>
	<h3>Shop Categories</h3>
	<ul>
		<c:forEach items="${categories}" var="c">
		<li><a href="/categories/${c.id}">${c.name}</a></li>
		</c:forEach>
	</ul>
	<hr>
	<h4>All Products</h4>
	<ul>
		<c:forEach items="${products}" var="p">
		<li><a href="/products/${p.id}">${p.name}</a></li>
		</c:forEach>
	</ul>
</div>

<div class="col-sm-4">
	<p>&nbsp;</p>
	<h3>New Category</h3>
	<form:form method="POST" action="/categories/new" modelAttribute="category">
		<p>
		<form:label path="name">Name<br>
		<form:input path="name"/><br>
		<small style=color:red><form:errors path="name"/></small>
		</form:label>
		</p>
		<p><input class="btn btn-primary" type="submit" value="Add Category"/></p>
	</form:form>
</div>
	
</div>
</div>
</body>
</html>