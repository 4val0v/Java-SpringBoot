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
        <title>Dashboard</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
</head>
<body>
<div class=container>
<div class=row>

<div class="col-sm-6" style="margin: 3% 0">
	
	<h2>Welcome, ${user.username}!</h2>
	<p>First Name: ${user.first}</p>
	<p>Last Name: ${user.last}</p>
	<p>Email: ${user.email}</p>
	<p>Sign up date: <fmt:formatDate type="date" value="${user.createdAt}"/></p>
	<p>Last sign in: <fmt:formatDate type="both" dateStyle="short" timeStyle="short" value="${user.lastLogin}"/></p>

</div>

<div class="col-sm-2" style="margin: 3% 0">

	<form method="POST" action="/logout">
		<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
		<input type="submit" value="Logout" />
	</form><br>
	
	<c:if test="${user.level == 2}">
	<form method=GET action=/admin>
		<input type="submit" value="Settings" />
	</form>
	</c:if>

</div>

	
</div>
</div>
</body>
</html>