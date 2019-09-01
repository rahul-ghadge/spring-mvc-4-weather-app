<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
<meta charset="ISO-8859-1">
<title>500 Error Page</title>
</head>
<body>
	<h2>Application Error, please contact support.</h2>

	<h3>Debug Information:</h3>

	Requested URL= ${url}
	<br>
	<br> Exception= ${exception.message}
	<br>
	<br>


</body>
</html>