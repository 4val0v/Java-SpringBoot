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

    <div class="col-sm-6" style="margin: 2% 0">

        <h4>Find your pool!</h4>
        <form method="POST" action="/search/q" class=form-inline>
        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
            <div class="form-group">
                <input type="text" class="form-control" name=location placeholder="Location">
            </div>
            <div class="form-group">
                <button type="submit" class="btn btn-primary">Search</button>
            </div>
        </form><p>&nbsp;</p>
        <h4>Your search of <strong>${search}</strong> found <strong>${pools.size()}</strong> pools.</h4>

        <table class="table table-striped table-bordered">
            <thead>
                <tr>
                    <td><strong>Location</strong></td>
                    <td><strong>Pool Size</strong></td>
                    <td><strong>Cost</strong></td>
                    <td><strong>Rating</strong></td>
                </tr>
            </thead>
            <tbody>
                <fmt:setLocale value="en_US"/>
                <c:forEach items="${pools}" var="p">
                <tr>
                    <td>${p.location}</td>
                    <td>${p.size}</td>
                    <td>
                        <fmt:formatNumber value="${p.cost}" type="currency"/>
                    </td>
                    <td>
                        ${p.avgRating}/5 - <a href="/pools/${p.id}">details</a>
                    </td>
                </tr>
                </c:forEach>
            </tbody>
        </table>

    </div>

    <div class="col-sm-4" style="margin: 2% 0">

        <h4>
            <a href="/">Home</a>
            <c:if test="${user.level > 0}">
             | <a href="/logout">Logout</a>
            </c:if>
        </h4>

    </div>

</div>
</div>
</div>
</body>
</html>