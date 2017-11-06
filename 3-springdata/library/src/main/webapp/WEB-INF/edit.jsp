<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
    
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
	<div class="col-sm-4 text-center">
	
		<p>&nbsp;</p>
		<form:form method="POST" action="/${idx}/edit" modelAttribute="book">
		    <p>
		    <form:label path="title">Title<br>
		    <form:input path="title"/><br>
		    <small style=color:red><form:errors path="title"/></small>
		    </form:label>
		    </p>
		    <p>
		    <form:label path="description">Description<br>
		    <form:textarea path="description"/><br>
		    <small style=color:red><form:errors path="description"/></small>
		    </form:label>
		    </p>
		    <p>
		    <form:label path="language">Language<br>
		    <form:input path="language"/><br>
		    <small style=color:red><form:errors path="language"/></small>
		    </form:label>
		    </p>
		    <p>
		    <form:label path="numberOfPages">Pages<br>
		    <form:input type="number" path="numberOfPages"/><br>
		    <small style=color:red><form:errors path="numberOfPages"/></small>
		    </form:label>
		    </p>
		    <p><input class="btn btn-primary" type="submit" value="Submit"/></p>
		    
		</form:form>

	</div>
	<div class=col-sm-4></div>
	
</div>
</div>
</body>
</html>