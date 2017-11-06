<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html>
<html lang="en">
<head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta http-equiv="X-UA-Compatible" content="ie=edge">
        <title>Books</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
</head>
<body>
<div class=container>
<div class=row>

	<div class=col-sm-4></div>
	<div class="col-sm-4">
	
		<h3 class=text-center>Library</h3>
		<table class="table">
			<tr>
			<td><strong>Title</strong></td>
			<td><strong>Edit</strong></td>
			<td><strong>Delete</strong></td>
			</tr>
		<c:forEach items="${books}" var="book" varStatus="loop">
		    <tr>    
		    <td><a href="/${loop.index}"><c:out value="${book.title}"/></a></td>
		    <td><a href="/${loop.index}/edit">Edit</a></td>
		    <td><a href="/${loop.index}/delete">Delete</a></td>
		    </tr>
		</c:forEach>
		</table>
		<p class=text-center><a href="/add">Add a Book</a>

	</div>
	<div class=col-sm-4></div>
	
</div>
</div>
</body>
</html>