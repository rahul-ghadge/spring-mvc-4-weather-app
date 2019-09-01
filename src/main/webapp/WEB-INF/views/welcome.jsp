<%-- 
 <%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
 --%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title><spring:message code="label.heading"/></title>
</head>

<body>

<a href="?locale=en">English </a> | <a href="?locale=fr">French </a>
	<div align="center">
		 <form:form role="form" action="weather.htm"
			modelAttribute="weather"> 
			<br>
			<br>
			<h3><spring:message code="label.weather"/></h3>
			<spring:message code="label.city"/> <input type="text" name="city" placeholder="Enter city">
			<br>
			<br>
			
			<br>
			<input type="submit" value="Submit">

		 </form:form> 
	</div>

</body>
</html> 

