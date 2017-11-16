<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page import="java.io.*,java.util.*,java.sql.*" %>
<%@ page import="javax.servlet.http.*,javax.servlet.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<!DOCTYPE html>
<html lang="en">
<head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta http-equiv="X-UA-Compatible" content="ie=edge">
        <title>TITLE</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
</head>
<body>
<div class=container>
<div class=row>

<div class="text-right" style="margin: 2% 0">
<h4>
<c:if test="${user == null}">
<a href="/login">Login/Join</a>
</c:if>
<c:if test="${user != null}">
<p>Hello, ${user.first}!</p>
<div>
	<form method="POST" action="/logout">
		<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
		<input type="submit" value="Logout" />
	</form>
</div>
</c:if>
</h4>
</div>

<div class="col-sm-12" style="margin: 15% 0">

    <div class="text-center">
    <h4>Find places to swim and sleep on WaterBnB!</h4>
	<form method="POST" action="/search/q" class=form-inline>
	<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
	    <div class="form-group">
	        <input type="text" class="form-control input-lg" name=location placeholder="Location">
	    </div>
        <div class="form-group">
            <button type="submit" class="btn btn-primary">Search</button>
        </div>
    </form>
    </div>

</div>
</div>
</div>
</body>
</html>