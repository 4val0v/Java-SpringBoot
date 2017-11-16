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

<c:choose>
<c:when test="${p.host == user}">

    <div class="col-sm-8" style="margin: 2% 0">

            <h4>Update Pool Info</h4>    
            <form:form method="POST" action="/host/pools/${p.id}/edit" modelAttribute="pool">

                <div class=form-group>
                    Location<br>
                    <form:input path="location" cssClass="form-control input-sm" placeholder="${p.location}"/>
                </div>
                <div class=form-group>
                    Description<br>
                    <form:input path="description" cssClass="form-control input-sm" placeholder="${p.description}"/>
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
                </div>
                <p><input type="submit" value="Update" class="btn btn-primary btn-sm"/></p>

            </form:form>

    </div>

</c:when>
<c:otherwise>

    <div class="col-sm-8" style="margin: 2% 0">
        <div class="col-sm-6">
        <h4>${p.location}</h4>
        <p>${p.description}</p>
        </div>
        <div class="col-sm-6">
        <strong>Email</strong>: ${p.host.email}<br>
        <strong>Name</strong>: ${p.host.first} ${p.host.last}<br>
        <strong>Pool Size</strong>: ${p.size}<br>
        <fmt:setLocale value="en_US"/>
        <strong>Cost</strong>: <fmt:formatNumber value="${p.cost}" type="currency"/>
        </div>
    </div>

</c:otherwise>
</c:choose>

    <div class="col-sm-4" style="margin: 2% 0">
        <h4><a href="/">Home</a></h4>
            <c:if test="${user != null}">
				<div>
					<form method="POST" action="/logout">
						<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
						<input type="submit" value="Logout" />
					</form>
				</div>
            </c:if>
        </h4>
    </div>
    
</div>

<div class=row>
    <div class=col-sm-8>
        <strong>Reviews (${p.avgRating}/5)</strong>
        <c:if test="${user != null}">
         | <a href="/pools/${p.id}/review">Leave a Review</a>
        </c:if>
    </div>
</div>

<div class=row>
    <div class=col-sm-8>
        <c:forEach items="${reviews}" var="r">
            <hr>
            <p>${r.author.first} ${r.author.last}
            <br>Rating: ${r.rating}</p>
            <p>${r.details}</p>
        </c:forEach>
    </div>
</div>
    
</div>
</div>
</div>
</body>
</html>