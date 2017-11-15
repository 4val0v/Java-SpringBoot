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
        <title>Login & Registration</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
</head>
<body>
<div class=container>
<div class=row>

<div class=col-sm-4></div>

<div class="col-sm-4"><p>&nbsp;</p>

	<c:if test="${logout != null}">
	<p class=text-center>
		<strong>${logout}</strong>
		<br>Please come back again soon.
	</p>
    </c:if>
	
	<h3>Login</h3>
    
	<form method="POST" action="/" class=form-inline>
		<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
 		<div class=form-group>
			<input type="text" name="username" class="form-control input-sm" placeholder=Email />
		</div>
		<div class="form-group">
			<input type="password" name="password" class="form-control input-sm" placeholder=Password />
		</div>
		<div class="form-group input-group-btn">
			<button type="submit" class="btn btn-primary btn-sm"><i class="glyphicon glyphicon-circle-arrow-right"></i></button>
		</div>
		<c:if test="${error != null}">
		<p style="color:red"><small>${error}</small></p>
    		</c:if>
		
	</form>
	
	<h3>Register</h3>
    
	<form:form method="POST" action="/register" modelAttribute="user">
		<div class=form-group>
			<form:input path="username" cssClass="form-control input-sm" placeholder="Email"/>
			<small style="color: red"><form:errors path="username"/></small>
		</div>
		<div class=form-group>
			<form:input path="first" cssClass="form-control input-sm" placeholder="First Name"/>
			<small style="color: red"><form:errors path="first"/></small>
		</div>
		<div class=form-group>
			<form:input path="last" cssClass="form-control input-sm" placeholder="Last Name"/>
			<small style="color: red"><form:errors path="last"/></small>
		</div>
		<div class=form-group>
			<form:password path="password" cssClass="form-control input-sm" placeholder="Password"/>
			<small style="color: red"><form:errors path="password"/></small>
		</div>
		<div class=form-group>
			<form:password path="passwordConfirmation" cssClass="form-control input-sm" placeholder="Confirmation"/>
			<small style="color: red"><form:errors path="passwordConfirmation"/></small>
		</div>
		<p><input type="submit" value="Register" class="btn btn-primary btn-sm"/></p>
	</form:form>

</div>

<div class=col-sm-4></div>
	
</div>
</div>
</body>
</html>