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
        <title>Company Team Site</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
</head>
<body>
<div class=container>
<div class=row>

	<div class="col-sm-4"><br><p>&nbsp;</p>
        <table class="table table-striped table-bordered">
        <thead>
            <tr><td><h4>Employee Directory</h4></td></tr>
        </thead>
        <tbody>
        <c:forEach items="${all}" var="a">
        <tr><td>
            <a href="/employee/${a.id}">${a.first_name} ${a.last_name}</a>
        </td></tr>
        </c:forEach>
        </tbody>
        </table>
    </div>

    <div class="col-sm-4"><br><p>&nbsp;</p>
        <table class="table table-striped table-bordered">
        <thead>
            <tr><td><h4>Managers</h4></td></tr>
        </thead>
        <tbody>
        <c:forEach items="${managers}" var="m">
            <tr><td>
            <a href="/manager/${m.id}">${m.first_name} ${m.last_name}</a>
            </td></tr>
        </c:forEach>
        </tbody>
        </table>
	</div>
    
    <div class="col-sm-4">
        <br><p class=text-right><a href=/admin>Admin</a></p>
        <table class="table table-striped table-bordered">
        <thead>
            <tr><td><h4>Associates</h4></td></tr>
        </thead>
        <tbody>
        <c:forEach items="${employees}" var="e">
            <tr><td>
            <a href="/employee/${e.id}">${e.first_name} ${e.last_name}</a>
            </td></tr>
        </c:forEach>
        </tbody>
        </table>
	</div>
	
</div>
</div>
</body>
</html>