<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
<head>
<%@ page isELIgnored="false" %>
<meta charset="UTF-8">
<title>Add Student</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/style.css?version=1">
	<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0/dist/css/bootstrap.min.css">
</head>
<body>
	<div class="container">
		<div align="center">
			<h2>Add / Update Student</h2>
			<table class="table table-light table-hover">
				<form:form modelAttribute="student" action="saveStudent" method="post">
					<form:hidden path="id" />
					<tr>
						<td class="studentprop">FirstName:</td>
						<td><form:input path="firstName" size="30" /></td>
						<td><form:errors path="firstName" class="error" /></td>
					</tr>

					<tr>
						<td class="studentprop">LastName:</td>
						<td><form:input path="lastName" size="30" /></td>
						<td><form:errors path="lastName" class="error" /></td>
					</tr>

					<tr>
						<td class="studentprop">Grade:</td>
						<td><form:input path="grade" size="30" /></td>
						<td><form:errors path="grade" class="error" /></td>
					</tr>

					<tr>
						<td></td>
						<td align="center"><form:button class="btn btn-info">Submit</form:button></td>
						<td></td>
					</tr>
				</form:form>
			</table>
		</div>
	</div>
</body>
</html>