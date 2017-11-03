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

	<div class="col-md-4"></div>
	<div class="col-md-4">
		<fieldset>
		<form action=/send method=POST>
	    <legend>Dojo Survey</legend>
	    <p>
	        Your Name:<br>
	        <input type=text name=name>
	    </p>
	    <p>
	        Dojo Location:<br>
	        <input list=dojo name=dojo>
	        <datalist id=dojo>
	            <option value="Silicon Valley">
	            <option value="Seattle">
	            <option value="Los Angeles">
	            <option value="Dallas">
	            <option value="Washington DC">
	            <option value="Chicago">
	            <option value="Tulsa">
	        </datalist>
	    </p>
	    <p>
	        Favorite Stack:<br>
	        <input list=stack name=stack>
	        <datalist id=stack>
	            <option value=".NET/C#">
	            <option value="Ruby on Rails">
	            <option value="Python">
	            <option value="MEAN">
	            <option value="Java">
	            <option value="iOS Swift">
	        </datalist>
	    </p>
	    <p>
	        Comment (Optional):<br>
	        <textarea name=comment rows=5 cols=50></textarea>
	    </p>
	    <p><input type=submit value="Button"></p>
	    </form>
	    </fieldset>
	</div>
	<div class="col-md-4"></div>

</div>
</div>
</body>
</html>