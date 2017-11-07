<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
    
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
	<div class="col-sm-4">
	
		<p>&nbsp;</p>
		<p class=text-right><a href="/dashboard">Dashboard</a></p>
		<h3>The Top 10</h3>
		<c:forEach items="${topten}" var="song">
		    <p>${song.rating} - 
		    <a href="/songs/${song.id}">${song.title}</a>
		     - ${song.artist}</p>
		</c:forEach>

	</div>
	<div class=col-sm-4></div>
	
</div>
</div>
</body>
</html>