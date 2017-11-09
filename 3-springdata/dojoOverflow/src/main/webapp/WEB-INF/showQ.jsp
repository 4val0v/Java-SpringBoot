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

    <div class="col-sm-4">
        <p>&nbsp;</p>
        <h1>${q.question}</h1>
        <p>Tags: 
            <c:forEach items="${ts}" var="t">
            ${t.tag.subject} 
            </c:forEach>
        </p>

        <table class="table table-striped table-bordered">
                <thead>
                    <tr>
                        <td><strong>Answers</strong></td>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach items="${as}" var="a">
                    <tr>
                        <td>${a.answer}</td>
                    </tr>
                    </c:forEach>
                </tbody>
            </table>

        <h4 class=text-center><a href="/questions/">Back to Questions</a></h4>

    </div>
    <div class=col-sm-4>

        <p>&nbsp;</p>

        <h3>Add an answer:</h3>
        <form method=post action=/questions/${q.id}/add class=form-horizontal>
            <p><textarea class=form-control name=a cols=50></textarea>
                <br><small style=color:red>${ae}</small></p>
            <p class=text-right><input class="btn btn-primary" type=submit value="Answer It!"></p>
        </form>

    </div>

    <div class=col-sm-4></div>
	
</div>
</div>
</body>
</html>