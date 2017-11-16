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
        <title>User Dashboard</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
</head>
<body>
<div class=container>
<div class=row>

<div class="col-sm-6" style="margin: 3% 0">
	
	<h2>Admin Settings</h2>
	
	<table class="table table-striped table-bordered">
		<thead>
			<tr>
				<td><strong>Username</strong></td>
				<td><strong>Email</strong></td>
				<td><strong>Level</strong></td>
				<td><strong>Promote</strong></td>
				<td><strong>Delete</strong></td>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${users}" var="u">
			<c:if test="${u.level != 3}">
			<tr>
				<td>${u.username}</td>
				<td>${u.email}</td>
				<td>${u.level}</td>
				<td>
				<c:choose>
					<c:when test="${u.level == 1}">
						<a href="/admin/user${u.id}/promote">Promote</a>
					</c:when>
					<c:when test="${u.level == 2}">
						<c:if test="${user.level == 3}">
						<a href="/admin/user${u.id}/demote">Demote</a>
						</c:if>
						<c:if test="${user.level == 2}">
							Admin
						</c:if>
					</c:when>
				</c:choose>
				</td>
				<td>
				<c:choose>
					<c:when test="${u.level == 1}">
						<a href="/admin/user${u.id}/delete">Delete</a>
					</c:when>
					<c:when test="${u.level == 2}">
						<c:if test="${user.level == 3}">
						<a href="/admin/user${u.id}/delete">Delete</a>
						</c:if>
					</c:when>
				</c:choose>
				</td>
			</tr>
			</c:if>
			</c:forEach>
		</tbody>
	</table>
	
</div>


<div class="col-sm-2" style="margin: 3% 0">

	<form method="POST" action="/logout">
		<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
		<input type="submit" value="Logout" />
	</form><br>
	
	<c:if test="${user.level == 2}">
	<form method=GET action=/dashboard>
		<input type="submit" value="Dashboard" />
	</form>
	</c:if>

</div>

	
</div>
</div>
</body>
</html>