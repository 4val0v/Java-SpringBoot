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

    <div class="col-sm-4">
        <h2>Add Employee</h2>
        <form:form method="POST" action="/admin/add" modelAttribute="employee" class="form-horizontal"><br>
            <p>
                <form:label path="first_name" class="control_label">
                    First Name <form:input path="first_name"/>
                </form:label>
            </p>
            <p>
                <form:label path="last_name" class="control_label">
                    Last Name <form:input path="last_name"/>
                </form:label>
            </p>
            <p><input class="btn btn-primary" type=submit value="Add">
            &nbsp; <small style=color:red>${name}</small></p>
        </form:form>

        <p class=text-center><a href="/">Return to Directory</a></p>

    </div>

    <div class="col-sm-4">
        <h2>New Team</h2>
        <form method=post action=/admin/promote class=form-horizontal>
            <p><strong>Promote to Manager</strong>
                <label for=manager class=control-label>
                    <select class="form-control" name=m_id>
                        <c:forEach items="${employees}" var="e">
                        <option value="${e.id}">${e.first_name} ${e.last_name}</option>
                        </c:forEach>
                    </select>
                </label>
            </p>
            <p><strong>Select Employees</strong> <small>(Hold ⌘ to highlight)</small>
                <label for=manager class=control-label>
                    <select multiple class="form-control" name=e_ids style="height: 200px; width: 200px">
                        <c:forEach items="${employees}" var="e">
                        <option value="${e.id}">${e.first_name} ${e.last_name}</option>
                        </c:forEach>
                    </select>
                </label>
            </p>
            <p><input class="btn btn-primary" type=submit value="Create Team"></p>
        </form>
    </div>
	
</div>
</div>
</body>
</html>