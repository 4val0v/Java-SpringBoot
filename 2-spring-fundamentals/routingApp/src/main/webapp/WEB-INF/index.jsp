<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
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
        <title>Students</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
</head>

<body>

<div class=container>
<div class=row><div class=col-md-12>&nbsp;</div></div>
<div class=row>

	<div class="col-md-4"></div>
	<div class="col-md-4">
	
	<h1>Students Page!</h1>
	
	<form action="/students/new" method="post">
		<input placeholder="First Name:" type="text" name="firstName" />
		<input placeholder="Stack:" type="text" name="stack" />
		<input type="submit" value="Create Student"/>
	</form>
	
	<h4>
		<c:forEach items="${students}" var="student">
			<p>${ student.firstName } : ${ student.stack }</p>
		</c:forEach>
	</h4>
	
	</div>
	<div class="col-md-4"></div>
	
</div>
</div>
</body>
</html>