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
        <title>Dojo Overflow</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
</head>
<body>
<div class=container>
<div class=row>

    <div class=col-sm-1></div>
    <div class=col-sm-1></div>
    <div class=col-sm-1></div>
    <div class="col-sm-4">
        <p>&nbsp;</p>
        <h1 class=text-center>Question Dashboard</h1>
        
        <table class="table table-striped table-bordered">
            <thead>
                <tr>
                    <td><strong>Question</strong></td>
                    <td><strong>Tags</strong></td>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${qs}" var="q">
                <tr>
                    <td><a href="/questions/${q.id}">${q.question}</a></td>
                    <td>
                        <c:forEach items="${q.tags}" var="t">
                            ${t.subject} 
                        </c:forEach>
                    </td>
                </tr>
                </c:forEach>
            </tbody>
        </table>
        <p>&nbsp;</p>
        <h4 class=text-center><a href="/questions/new">Add a New Question</a></h4>

    </div>
    <div class=col-sm-1></div>
    <div class=col-sm-1></div>
    <div class=col-sm-1></div>
	
</div>
</div>
</body>
</html>