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
    <div class="col-sm-6">
        <p>&nbsp;</p>
        <h1>What is your question?</h1>
        
        <form method=post action=/questions/new class=form-horizontal>
            <p><textarea class=form-control name=q cols=50></textarea><br><small style=color:red>${qe}</small></p>
            <p>Tag 1: <input type=text name=t1> <small style=color:red>${te} ${te2}</small></p>
            <p>Tag 2: <input type=text name=t2></p>
            <p>Tag 3: <input type=text name=t3></p>
            <p class=text-right><input class="btn btn-primary" type=submit value="Ask a Question!"></p>
        </form>

        <h4 class=text-center><a href="/questions/">Back to Questions</a></h4>

    </div>
    <div class=col-sm-1></div>
    <div class=col-sm-1></div>
    <div class=col-sm-1></div>
	
</div>
</div>
</body>
</html>