<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<!DOCTYPE html>
<html lang="en">
<head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta http-equiv="X-UA-Compatible" content="ie=edge">
        <title>RINGS OF POWER</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
</head>
<body>

<div class=container>
<div class=row>
<div class="col-sm-6"><p>&nbsp;</p>
	
	<p class=text-right><a href="/fool_creator">Back</a></p>
	
	<h2 class=text-center>${guild.name}</h2>
	<p class=text-right>Team Count: ${guild.users.size()}</p>
	<table class="table table-striped table-bordered">
		<thead>
			<tr>
				<td><strong>Name</strong></td>
				<td><strong>Age</strong></td>
				<td><strong>Destroy</strong></td>
				<td><strong>Update</strong></td>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${guild.users}" var="u">
			<tr>
				<td>${u.username}</td>
				<td>${u.createdAt}</td>
				<c:if test="${u.level != 'Admin'}">
					<td><a href="/fool_updater/${u.id}/destroy">Destroy</a></td>
					<td><a href="/fool_updater/${u.id}">Update</a></td>
				</c:if>
				<c:if test="${u.level == 'Admin'}">
					<td>Immortal</td>
					<td>Elevated</td>
				</c:if>
			</tr>
			</c:forEach>
		</tbody>
	</table>

</div>
</div>
</div>

</body>
</html>