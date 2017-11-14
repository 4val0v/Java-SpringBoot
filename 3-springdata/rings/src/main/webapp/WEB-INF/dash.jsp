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
	
	<h2>Welcome, ${user.username}.</h2>
	<p>Welcome to your awesome magical ring finder. Put a ring on. Only good things will happen. Maybe it'll make you live forever, go invisible, turn your inherent hunger for riches or power into an insatiable curse that eventually dooms your entire species.</p>
	<form method="POST" action="/bind_in_darkness" class=form-inline>
		<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
		<input type="hidden" name="u_id" value="${user.id}"/>
		<div class=form-group>
            <select class="form-control input-md" name=r_id>
				<option value="0">Select a Ring of Power</option>
				<c:forEach items="${avail_rings}" var="r">
                <option value="${r.id}">${r.title}</option>
                </c:forEach>
			</select>
			<input type="submit" value="Bind Yourself in Darkness" class="btn btn-danger btn-md"/>
		</div>
	</form>
	<hr>
	<table class="table table-striped table-bordered">
		<thead>
			<tr>
				<td><strong>Rings You Possess</strong></td>
				<td><strong>Action</strong></td>
			</tr>
		</thead>
		<tbody>
			<c:choose>
				<c:when test="${user_rings.isEmpty()}">
				<tr>
					<td>None yet! Don't you want more power?</td>
					<td>&nbsp;</td>
				</tr>
				</c:when>
			</c:choose>
			<c:forEach items="${user_rings}" var="r">
			<tr>
				<td>${r.title}</td>
				<td>[<a href="#">Lose Ring</a>]</td>
			</tr>
			</c:forEach>
		</tbody>
	</table>

</div>

<div class="col-sm-4"><p>&nbsp;</p>
	<form id="logoutForm" method="POST" action="/logout">
		<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
		<input type="submit" value="Flee to Safety" class="btn btn-default btn-md"/>
	</form><br>

	<c:if test="${user.level == 'Admin'}">
	<div class="well well-sm col-sm-8">
		<h4>Powerful Ainur Settings</h4>
		<p>
			<a href="/ring_creator.exe">Ring Creator</a><br>
			<a href="/fool_creator">User/Guild Creator</a>
		</p>
	</div>
	</c:if>

</div>
	
</div>
</div>
</body>
</html>