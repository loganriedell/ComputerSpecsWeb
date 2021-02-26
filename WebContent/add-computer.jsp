<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add New Computer</title>
</head>
<body>
	<form action="addComputerServlet" method="post">
		CPU: <input type="text" name="cpu">
		GPU: <input type="text" name="gpu">
		OS: <input type="text" name="os">
		<input type="submit" value="Add Computer">
	</form>

</body>
</html>