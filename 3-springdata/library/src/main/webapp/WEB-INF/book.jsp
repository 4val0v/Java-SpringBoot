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
	
		<p>&nbsp;</p>
		<p><strong><c:out value="${book.title}"/></strong></p>
		<p>Description: <c:out value="${book.description}"/></p>
		<p>Language: <c:out value="${book.language}"/></p>
		<p>Length: <c:out value="${book.numberOfPages}"/> pages</p>
		<p class=text-right><a href="/${idx}/edit">Edit</a>
		<p class=text-right><a href="/${idx}/delete">Delete</a>
		<p class=text-right><a href="/">Go Back</a></p>

	</div>
	<div class=col-sm-4></div>
	
</div>
</div>
</body>
</html>