<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html>
<html lang="en">
<head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta http-equiv="X-UA-Compatible" content="ie=edge">
        <title>Home Page</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
</head>
<body>
<div class=container>
<div class=row><div class=col-md-12>&nbsp;</div></div>
<div class=row>

	<div class=col-md-4></div>
	<div class=col-md-4>

		<fieldset>
		    <legend>Submitted Information</legend>
		    <p>Your Name: ${name}</p>
		    <p>Dojo Location: ${dojo}</p>
		    <p>Favorite Stack: ${stack}</p>
		    <p>Comment: ${comment}</p>
		    <p><a href="/">Go Back</a></p>
		</fieldset>

	</div>
	<div class=col-md-4></div>

</div>
</div>
</body>
</html>