<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html>
<html lang="en">
<head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta http-equiv="X-UA-Compatible" content="ie=edge">
        <title>Ninja Money</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <link rel="stylesheet" href="style.css">
</head>
<body>

<div class=container>

<header>
	<h3>Your Gold ${gold}</h3>
</header>

<section>

	<div>
		<h3>Farm</h3>
		<p>(earns 10-20 gold)</p>
		<form action='getmoney/' method=POST>
			<input type=hidden name=location value=farm>
			<input type=submit value="Find Gold!">
		</form>
	</div>

	<div>
		<h3>Cave</h3>
		<p>(earns 5-10 gold)</p>
		<form action='getmoney/' method=POST>
			<input type=hidden name=location value=cave>
			<input type=submit value="Find Gold!">
		</form>
	</div>

	<div>
		<h3>House</h3>
		<p>(earns 2-5 gold)</p>
		<form action='getmoney/' method=POST>
			<input type=hidden name=location value=house>
			<input type=submit value="Find Gold!">
		</form>
	</div>

	<div>
		<h3>Casino</h3>
		<p>(earns/takes 0-50 gold)</p>
		<form action='getmoney/' method=POST>
			<input type=hidden name=location value=casino>
			<input type=submit value="Find Gold!">
		</form>
	</div>

</section>

<footer>
    <h3>Activities</h3>
    <textarea>${activities}</textarea>
</footer>

</div>

</body>
</html>