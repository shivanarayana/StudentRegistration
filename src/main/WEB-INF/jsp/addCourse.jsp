<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add Employee</title>
</head>
<jsp:include page="menu.jsp" />
<body>
	<h3 style="color: red;">Add New Employee</h3>

	<div id="addCourse">
		<form:form action="/addCourse" method="post"
			modelAttribute="course">
			<p>
				<label>Enter Employee Id</label>
				<form:input path="courseId" />
			</p>
			<p>
				<label>Enter Name</label>
				<form:input path="courseName" />
			</p>
			<input type="SUBMIT" value="Submit" />
		</form:form>
	</div>
</body>
</html>
