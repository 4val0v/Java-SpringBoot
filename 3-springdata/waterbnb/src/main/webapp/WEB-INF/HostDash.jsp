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
<div class="col-sm-12>
	
    <!-- CHOOSE WHEN (WITH SCOPED VAR) -->
    <c:set var="salary" scope="session" value="${2000*2}"/>
    <c:choose>
        <c:when test="${salary <= 0}">Salary is very low to survive.</c:when>
        <c:when test="${salary > 1000}">Salary is very good.</c:when>
        <c:otherwise>No comment!</c:otherwise>
    </c:choose>

    <!-- RANGED FOR LOOP OVER LIST -->
    <c:forEach items=${list} var="item" begin="1" end="5" varStatus="loop">
        ${loop.count} (starts at 1)
        ${item}
        ${loop.index} (starts at 0)
    </c:forEach>

    <!-- NUMBER FORMATTING --> <c:set var="balance" value="9500.60" />
    <fmt:setLocale value="en_US"/>
    <fmt:formatNumber value="${balance}" type="currency"/> $9,500.60
    <fmt:formatNumber value="${balance}" type="number" maxIntegerDigits="3" /> 500.6
    <fmt:formatNumber value="${balance}" type="number" maxFractionDigits="1" /> 9,500.6
    <fmt:formatNumber value="${balance}" type="number" groupingUsed="false" /> 9500.6
    <fmt:formatNumber value="${balance}" type="percent" maxIntegerDigits="2" /> 60%
    <fmt:formatNumber value="${balance}" type="number" pattern"###.###E0" /> 9.5006E3

    <!-- INT ONLY NUMBER PARSING --> <c:set var="balance" value="9500.60" />
    <fmt:parseNumber value="${balance}" var="val" type="number" integerOnly="true" />
    ${val} 9500

    <!-- DATE FORMATTING -->
    <c:set var="now" value="<%=new java.util.Date()%>" />
    <fmt:formatDate type="time" value="${now}" />
    <fmt:formatDate type="date" value="${now}" />
    <fmt:formatDate type="both" value="${now}" />
    <fmt:formatDate type="both" dateStyle="short" timeStyle="short" value="${now}" />
    <fmt:formatDate type="both" dateStyle="medium" timeStyle="medium" value="${now}" />
    <fmt:formatDate type="both" dateStyle="long" timeStyle="long" value="${now}" />
    <fmt:formatDate pattern="yyyy-MM-dd" value="${now}" />

    <!-- TIMEDELTA: Milliseconds to Days -->
	<c:set var="now" value="<%=new java.util.Date()%>" />
	<c:set var="then" value="${u.createdAt}" />
	<c:set var="age" value="${((now.getTime() - then.getTime())) / (60*60*24*1000)}" />
	<fmt:formatNumber value="${age}" type="number" maxFractionDigits="0" />

    <!-- STRING MANIPULATION --> <c:set var="string" value="String."/>
    ${fn:toUpperCase(string)}
    ${fn:toLowerCase(string)}
    ${fn:split(string, ' ')}
    ${fn:join(string, ' ')}
    ${fn:length(string)}
    ${fn:contains(string, 'r')}
    ${fn:containsIgnoreCase(string, 'R')}

</div>
</div>
</div>
</body>
</html>