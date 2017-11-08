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
        <title>Dojos & Ninjas</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <link rel="stylesheet" type="text/css" href="/css/style.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

</head>
<body>
<div class=container>
<div class=row>

	<div class="col-md-4 outer">

    <div class="row well">
        <fieldset>
        <legend><h3>Add a Dojo</h3></legend>
        <form:form method="POST" action="/dojos/new" modelAttribute="dojo">
            <p>
            <form:label path="name">Name<br>
            <form:input path="name"/><br>
            <small style=color:red><form:errors path="name"/></small>
            </form:label>
            </p>
            <p><input class="btn btn-primary" type="submit" value="Add Dojo"/></p>
        </form:form>
        </fieldset>
    </div>

    <div class="row well">
        <fieldset>
        <legend><h3>Add a Ninja</h3></legend>
        <form:form method="POST" action="/ninjas/new" modelAttribute="ninja">
            <p>
            <form:label path="dojo">
            <form:select path="dojo">
                <form:option value="0" label="Select Dojo"/>
                <c:forEach items="${dojos}" var="d">
                <form:option value="${d.id}" label="${d.name}"/>
                </c:forEach>
            </form:select><br>
            <small style=color:red><form:errors path="dojo"/></small>
            </form:label>
            </p>
            <p>
            <form:label path="firstName">First Name<br>
            <form:input path="firstName"/><br>
            <small style=color:red><form:errors path="firstName"/></small>
            </form:label>
            </p>
            <p>
            <form:label path="lastName">Last Name<br>
            <form:input path="lastName"/><br>
            <small style=color:red><form:errors path="lastName"/></small>
            </form:label>
            </p>
            <p>
            <form:label path="age">Age<br>
            <form:input path="age"/><br>
            <small style=color:red><form:errors path="age"/></small>
            </form:label>
            </p>
            <p><input class="btn btn-primary" type="submit" value="Add Ninja"/></p>
        </form:form>
        </fieldset>
    </div>
    </div>
    
	<div class="col-md-4 text-center">
    <h1>Meet Our Ninjas</h1><hr>
        <c:forEach items="${dojos}" var="d">
        <div class="panel-group">
            <div class="panel panel-default">
                <div class="panel-heading">
                    <h4 class="panel-title">
                    <a data-toggle="collapse" href="#collapse${d.id}">${d.name}</a>
                    </h4>
                </div>
                <div id="collapse${d.id}" class="panel-collapse collapse">
                    <ul class="list-group">
                        <c:forEach items="${ninjas}" var="n">
                        <c:if test="${d.id == n.dojo.id}">
                        <li class="list-group-item">
                            ${n.firstName} ${n.lastName} - ${n.age}
                        </li>
                        </c:if>
                        </c:forEach>
                    </ul>
                </div>
            </div>
        </div>
        </c:forEach>
    </div>
	
</div>
</div>
</body>
</html>