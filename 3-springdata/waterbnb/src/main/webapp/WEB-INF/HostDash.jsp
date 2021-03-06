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

    <div class="col-sm-8" style="margin: 2% 0">

        <h3>Current Listings</h3>
        <table class="table table-striped table-bordered">
            <thead>
                <tr>
                    <td><strong>Location</strong></td>
                    <td><strong>Pool Size</strong></td>
                    <td><strong>Cost</strong></td>
                    <td><strong>Details</strong></td>
                </tr>
            </thead>
            <tbody>
                <fmt:setLocale value="en_US"/>
                <c:forEach items="${user.pools}" var="p">
                <tr>
                    <td>${p.location}</td>
                    <td>${p.size}</td>
                    <td>
                        <fmt:formatNumber value="${p.cost}" type="currency"/>
                    </td>
                    <td>
                        <a href="/host/pools/${p.id}">${p.avgRating} - See more</a>
                    </td>
                </tr>
                </c:forEach>
            </tbody>
        </table>

	<div class="col-sm-6">
	       <fieldset>
            <legend>New Listing</legend>

            <form:form method="POST" action="/host/dashboard/new" modelAttribute="pool">

                <div class=form-group>
                    Location<br>
                    <form:input path="location" cssClass="form-control input-sm"/>
                </div>
                <div class=form-group>
                    Description<br>
                    <form:input path="description" cssClass="form-control input-sm"/>
                </div>
                <div class=form-group>
                    Cost ($)<br>
                    <form:input path="cost" cssClass="form-control input-sm"/>
                </div>
                <div class=form-group>Pool Size<br>
                    <form:select path="size" cssClass="form-control input-sm">
                        <form:option value="small" label="small"/>
                        <form:option value="medium" label="medium"/>
                        <form:option value="large" label="large"/>
                    </form:select>
                    <form:hidden path="host" value="${user.id}"/>
                </div>
                <p><input type="submit" value="Add Listing" class="btn btn-primary btn-sm"/></p>

            </form:form>

        </fieldset>
	</div>
	
	<div class="col-sm-4">
        <p>
        <p><form:errors path="location"/></p>
        <p><form:errors path="description"/></p>
        <p><form:errors path="cost"/></p>
        <p><form:errors path="size"/></p>
        
    </div>

    </div>

    <div class="col-sm-4" style="margin: 2% 0">
	<form method="POST" action="/logout">
		<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
		<input type="submit" value="Logout" />
	</form>
    </div>

</div>
</div>
</body>
</html>