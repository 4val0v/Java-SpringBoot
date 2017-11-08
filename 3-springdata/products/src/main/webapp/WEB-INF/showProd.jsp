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
		<h3><strong>${product.name}</strong></h3>
		<p>Description: ${product.description}</p>
		<p>Price: ${product.price}</p>
		<hr>
		<p><strong>Categories:</strong></p>
		<ul>
			<c:forEach items="${product.categories}" var="c">
			<li>${c.name}</li>
			</c:forEach>
		</ul>
		<p class=text-right><a href="/">View All</a></p>

	</div>

	<div class=col-sm-4>

		<p>&nbsp;</p>

		<form method="POST" action="/products/${product.id}/add">
			<h4>Add to Category:</h4>
			<p>
			<select name="category">
				<option value="0">Select</option>
				<c:forEach items="${categories}" var="c">
				<option value="${c.id}">${c.name}</option>
				</c:forEach>
			</select>
			</p>
			<p><input class="btn btn-primary" type="submit" value="Add"/></p>
		</form>

	</div>
	<div class=col-sm-4></div>
	
</div>
</div>
</body>
</html>