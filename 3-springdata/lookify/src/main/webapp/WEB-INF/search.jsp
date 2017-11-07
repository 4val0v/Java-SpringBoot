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

	<div class=col-sm-1></div>
	<div class=col-sm-1></div>
	<div class="col-sm-8">
	
		<p>&nbsp;</p>
		
		<nav class="navbar">
		  <div class="container-fluid">
		    <div class="navbar-header">
		      <a class="navbar-brand" href="/dashboard">Lookify</a>
		    </div>
		    <ul class="nav navbar-nav">
		      <li><a href="/songs/new">Add New</a></li>
		      <li><a href="/search/top10">Top Songs</a></li>
		    </ul>
		    <form method="POST" action="/search" class="navbar-form navbar-left">
		      <div class="form-group">
		        <input type="text" class="form-control" name=artist value="Artist">
		      </div>
		      <button type="submit" class="btn btn-primary">Search</button>
		    </form>
		  </div>
		</nav>
		
		<table class="table">
			<tr>
			<td><strong>Song</strong></td>
			<td><strong>Artist</strong></td>
			<td><strong>Rating</strong></td>
			<td><strong>Actions</strong></td>
			</tr>
		<c:forEach items="${songs}" var="song">
		    <tr>    
		    <td><a href="/songs/${song.id}"><c:out value="${song.title}"/></a></td>
		    <td><c:out value="${song.artist}"/></td>
		    <td><c:out value="${song.rating}"/></td>
		    <td><a href="/songs/${song.id}/delete">Delete</a></td>
		    </tr>
		</c:forEach>
		</table>

	</div>
	<div class=col-sm-1></div>
	<div class=col-sm-1></div>
	
</div>
</div>
</body>
</html>