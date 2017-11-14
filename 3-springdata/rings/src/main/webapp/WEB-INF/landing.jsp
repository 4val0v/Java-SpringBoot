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

<div class=col-sm-4></div>

<div class="col-sm-4"><p>&nbsp;</p>

	<h1 class=text-center><big><strong>Rings</strong> of <strong>Power</strong></big></h1>
	
	<h2>Login</h2>
    
	<form method="POST" action="/">
		<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
 		<div class=form-group>
			<input type="text" name="username" class="form-control input-lg" placeholder=Username />
		</div>
		<div class="form-group">
			<input type="password" name="password" class="form-control input-lg" placeholder=Password />
		</div>
		<p>
			<input type="submit" value="Bind in Darkness" class="btn btn-danger btn-lg"/>
			<c:if test="${error != null}">&nbsp;
			<span style="color:red"><strong>${error}</strong>
			</c:if>
		</p>
		
	</form>
	
	<h2>Join</h2>
    
	<form:form method="POST" action="/register" modelAttribute="user">
		<div class=form-group>
			<form:input path="username" cssClass="form-control input-lg" placeholder="Username"/>
			<strong style="color: red"><form:errors path="username"/></strong>
		</div>
		<div class=form-group>
			<form:input path="email" cssClass="form-control input-lg" placeholder="Email"/>
			<strong style="color: red"><form:errors path="email"/></strong>
		</div>
		<div class=form-group>
			<form:password path="password" cssClass="form-control input-lg" placeholder="Password"/>
			<strong style="color: red"><form:errors path="password"/></strong>
		</div>
		<div class=form-group>
			<form:password path="passwordConfirmation" cssClass="form-control input-lg" placeholder="Confirmation"/>
			<strong style="color: red"><form:errors path="passwordConfirmation"/></strong>
		</div>
		<p><input type="submit" value="Bind in Darkness" class="btn btn-warning btn-lg"/></p>
	</form:form>

</div>

<div class=col-sm-4></div>
	
</div>
</div>
</body>
</html>