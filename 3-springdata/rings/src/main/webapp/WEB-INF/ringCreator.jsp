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

<div class="col-sm-4"><p>&nbsp;</p>
	<h4>Forge a Ring of Power</h4>
	<form:form method="POST" action="/ring_creator.exe" modelAttribute="ring">
	<div class=form-group>
		<form:input path="title" cssClass="form-control input-lg" placeholder="Name"/>
	</div>
	<p>
		<input type="submit" value="Forge Ring" class="btn btn-warning btn-lg"/>
		&nbsp;<strong style="color: red"><form:errors path="title"/></strong>
	</p>
	</form:form>
</div>

<div class="col-sm-4"><p>&nbsp;</p>
	<p><a href="/bind_in_darkness">Back</a></p>
</div>
	
</div>
</div>
</body>
</html>