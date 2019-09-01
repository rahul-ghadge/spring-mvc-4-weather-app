
 <%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<title>Weather App</title>
</head>
<body>

	<div align="center">
		 <form:form role="form" action="weather.htm"
			modelAttribute="weather"> 
			<br>
			<br>
			<h3>Weather page</h3>
			City : <input type="text" name="city" placeholder="Enter city">
			<br>
			<br>
			
			<br>
			<input type="submit" value="Submit">

		 </form:form> 
	</div>

</body>
</html> 

