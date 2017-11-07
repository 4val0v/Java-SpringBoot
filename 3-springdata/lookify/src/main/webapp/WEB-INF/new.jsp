<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
    
<!DOCTYPE html>
<html lang="en">
<head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta http-equiv="X-UA-Compatible" content="ie=edge">
        <title>Lookify</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
</head>
<body>
<div class=container>
<div class=row>

	<div class=col-sm-4></div>
	<div class="col-sm-4 text-center">
	
		<p>&nbsp;</p>
		<p class=text-right><a href="/dashboard">Dashboard</a></p>
		<form:form method="POST" action="/songs/new" modelAttribute="song">
		    <p>
		    <form:label path="title">Song Title<br>
		    <form:input path="title"/><br>
		    <small style=color:red><form:errors path="title"/></small>
		    </form:label>
		    </p>
		    <p>
		    <form:label path="artist">Artist<br>
		    <form:input path="artist"/><br>
		    <small style=color:red><form:errors path="artist"/></small>
		    </form:label>
		    </p>
		    <p>
		    <form:label path="rating">Rating<br>
		    	<form:input path="rating"/><br>
		    	<small style=color:red><form:errors path="rating"/></small>
		    </form:label>
		    </p>
		    <p><input class="btn btn-primary" type="submit" value="Add Song"/></p>
		    
		</form:form>

	</div>
	<div class=col-sm-4></div>
	
</div>
</div>
</body>
</html>