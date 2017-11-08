<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
    
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
		<h3><strong>${category.name}</strong></h3>
		<hr>
		<p><strong>Products:</strong></p>
		<ul>
			<c:forEach items="${category.products}" var="p">
			<li>${p.name}</li>
			</c:forEach>
		</ul>
		<p class=text-right><a href="/">View All</a></p>

	</div>

	<div class=col-sm-4>

		<p>&nbsp;</p>

		<form method="POST" action="/categories/${category.id}/add">
			<h4>Assign to Product:</h4>
			<p>
			<select name="product">
				<option value="0">Select</option>
				<c:forEach items="${products}" var="p">
				<option value="${p.id}">${p.name}</option>
				</c:forEach>
			</select>
			</p>
			<p><input class="btn btn-primary" type="submit" value="Assign"/></p>
		</form>

	</div>
	<div class=col-sm-4></div>
	
</div>
</div>
</body>
</html>