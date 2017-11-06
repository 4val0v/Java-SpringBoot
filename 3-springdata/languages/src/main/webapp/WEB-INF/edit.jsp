<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
    
<!DOCTYPE html>
<html lang="en">
<head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta http-equiv="X-UA-Compatible" content="ie=edge">
        <title>Languages</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
</head>
<body>
<div class=container>
<div class=row>

	<div class=col-sm-4></div>
	<div class="col-sm-4 text-center">
	
		<p>&nbsp;</p>
		<form:form method="POST" action="/${idx}/edit" modelAttribute="language">
		    <p>
		    <form:label path="name">Language<br>
		    <form:input path="name"/><br>
		    <small style=color:red><form:errors path="name"/></small>
		    </form:label>
		    </p>
		    <p>
		    <form:label path="creator">Creator<br>
		    <form:input path="creator"/><br>
		    <small style=color:red><form:errors path="creator"/></small>
		    </form:label>
		    </p>
		    <p>
		    <form:label path="currentVersion">Version<br>
		    <form:input path="currentVersion"/><br>
		    <small style=color:red><form:errors path="currentVersion"/></small>
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