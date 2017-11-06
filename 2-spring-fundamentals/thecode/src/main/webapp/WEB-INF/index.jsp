<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html>
<html lang="en">
<head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta http-equiv="X-UA-Compatible" content="ie=edge">
        <title>The Code</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
</head>
<body>
<div class=container>
<div class=row>

	<div class=col-sm-4></div>
	<div class="col-sm-4 text-center">
		<p>&nbsp;</p>
		<p>&nbsp;</p>
		<h1>The Code</h1>
		<p>&nbsp;</p>
		<h3 style="color:red">${flash}</h3>
		<h4>What is the code?</h4>
		<form action='/check' method=POST>
			<p><input type=text name=attempt></p>
			<p><input type=submit value="Try Code"></p>
		</form>
	</div>
	<div class=col-sm-4></div>
	
</div>
</div>
</body>
</html>