<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html>
<html lang="en">
<head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta http-equiv="X-UA-Compatible" content="ie=edge">
        <title>Fortran Dashboard</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
</head>
<body>
<div class=container>

	<nav class="navbar navbar-default">
		<div class="container-fluid">
		<div class=navbar-header>
			<a class=navbar-brand href="/">Fortran!</a>
		</div>
		<ul class="nav navbar-nav">
			<li><a href="/m/38/0553/0733">Setup</a></li>
			<li><a href="/m/38/0483/0345">Forms</a></li>
			<li><a href="/m/38/0553/0342">Cards</a></li>
			<li><a href="/m/26/0553/0348">Advanced</a></li>
			<li><a href="/m/26/0483/2342">Binary</a></li>
		</ul>
		</div>
	</nav>

<div class=row>

	<div class=col-sm-1></div>
	<div class=col-sm-1></div>
	<div class="col-sm-8">
		<input type=checkbox> Assignment completed
		<textarea style="width:100%; height:200px">${content}</textarea>
	</div>
	<div class=col-sm-1></div>
	<div class=col-sm-1></div>
	
</div>
</div>
</body>
</html>