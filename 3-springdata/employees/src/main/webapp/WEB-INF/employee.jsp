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
    
    <div class="col-sm-4"></div>
    <div class="col-sm-4">
        
        <h2>${employee.first_name} ${employee.last_name}</h2>
        <h4>Manager: ${employee.manager.first_name} ${employee.manager.last_name}</h4>
        <table class="table table-striped table-bordered">
        <thead><tr><td>
            <strong>Teammates</strong>>
        </td></tr></thead>
        <tbody>
            <c:forEach items="${employee.manager.employees}" var="e">
            <c:if test="${e != employee}">
        <tr><td>
            <a href="/employee/${e.id}">${e.first_name} ${e.last_name}</a>
        </td></tr>
            </c:if>
            </c:forEach>
        </tbody>
        </table>

    </div>
    <div class="col-sm-4"></div>
	
</div>
</div>
</body>
</html>