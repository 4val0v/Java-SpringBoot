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

    <div class="col-sm-4" style="margin: 2% 0">

        <fieldset>
            <legend>Review ${p.location}</legend>

            <form:form method="POST" action="/pools/${p.id}/review" modelAttribute="review">

                <div class=form-group>
                    <form:textarea path="details" cssClass="form-control input-sm"/>
                </div>
                <div class="form-group col-sm-4">
                    <form:select path="rating" cssClass="form-control input-sm" placeholder="Rating">
                        <form:option value="5" label="5"/>
                        <form:option value="4" label="4"/>
                        <form:option value="3" label="3"/>
                        <form:option value="2" label="2"/>
                        <form:option value="1" label="1"/>
                    </form:select>
                    <form:hidden path="author" value="${user.id}"/>
                    <form:hidden path="pool" value="${p.id}"/>
                </div>
                <div class="form-group col-sm-8">
                		<input type="submit" value="Submit Review" class="btn btn-primary btn-sm"/>
                </div>

            </form:form>

        </fieldset>

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