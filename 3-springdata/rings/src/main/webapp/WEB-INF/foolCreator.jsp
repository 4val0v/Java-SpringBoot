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
<div class="col-sm-8"><p>&nbsp;</p>
	
	<p class=text-right><a href="/bind_in_darkness">Back</a></p>
	
	<h2 class=text-center>Welcome, Ilúvatar!</h2>
	<table class="table table-striped table-bordered">
		<thead>
			<tr>
				<td><strong>Name</strong></td>
				<td><strong>Guilds</strong></td>
				<td><strong>Age</strong></td>
				<td><strong>Destroy</strong></td>
				<td><strong>Promote</strong></td>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${users}" var="u">
			<tr>
				<td>${u.username}</td>
				<td>
					<c:forEach items="${u.guilds}" var="g">
						<a href="/guild/${g.id}">${g.name}</a><br>
					</c:forEach>
				</td>
				<td>
					<c:set var="now" value="<%=new java.util.Date()%>" />
					<c:set var="then" value="${u.createdAt}" />
					<c:set var="age" value="${((now.getTime() - then.getTime())) / (60*60*24*1000)}" />
					<fmt:formatNumber value="${age}" type="number" maxFractionDigits="0" />
				</td>
				<c:if test="${u.level != 'Admin'}">
					<td><a href="/fool_updater/${u.id}/destroy">Destroy</a></td>
					<td><a href="/fool_updater/${u.id}/promote">Promote</a></td>
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

<div class=row>

<div class="col-sm-4"><p>&nbsp;</p>
	<h4>Assign User to Guild</h4>
	<form method="POST" action="/fool_assigner">
		<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
		<div class=form-group>
            <select class="form-control input-md" name=u_id>
				<option value="0">Select a User</option>
				<c:forEach items="${users}" var="u">
				<c:if test="${u.level != 'Admin'}">
				<option value="${u.id}">${u.username}</option>
				</c:if>
                </c:forEach>
			</select>
		</div>
		<div class=form-group>
            <select class="form-control input-md" name=g_id>
				<option value="0">Select a Guild</option>
				<c:forEach items="${guilds}" var="g">
                <option value="${g.id}">${g.name}</option>
                </c:forEach>
			</select>
		</div>
		<div class=form-group>
			<input type="submit" value="Join" class="btn btn-danger btn-md"/>
		</div>
	</form>
</div>

<div class="col-sm-4"><p>&nbsp;</p>
	<h4>Create Guild</h4>
	<form:form method="POST" action="/fool_creator" modelAttribute="guild">
	<div class=form-group>
		<form:input path="name" cssClass="form-control input-md" placeholder="name"/>
	</div>
	<p>
		<input type="submit" value="Create Guild" class="btn btn-warning btn-md"/>
		&nbsp;<strong style="color: red"><form:errors path="name"/></strong>
	</p>
	</form:form>
</div>
	
</div>
</div>
</body>
</html>