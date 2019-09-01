<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title><spring:message code="label.heading" /></title>

<spring:url value="/res/css/style.css" var="cssUrl" />
<spring:url value="/res/css/bootstrap.min.css" var="bootstrapUrl" />
<spring:url value="/res/js/jquery-3.4.1.js" var="jqueryUrl" />
<spring:url value="/res/js/script.js" var="scriptUrl" />

<link href="${cssUrl}" rel="stylesheet" />
<link href="${bootstrapUrl}" rel="stylesheet" />
<script src="${jqueryUrl}"></script>
<script src="${scriptUrl}"></script>

</head>
<body>

<div class="locale">
	<a href="?locale=en">English </a> |
	<a href="?locale=fr">French </a>
</div>

	<c:forEach items="${weatherInfoModels}" var="weatherInfoModel">
	
		<c:if test="${weatherInfoModel.cod eq 200}">
			<table border="2" width="50%" cellpadding="2">

				<tr>
					<th>Weather details of ${weatherInfoModel.name}</th>
				</tr>
				<tr>
					<td>Id : ${weatherInfoModel.id}</td>
				</tr>
				<tr>
					<td>City : ${weatherInfoModel.name}</td>
				</tr>
				<tr>
					<td>Code : ${weatherInfoModel.cod}</td>
				</tr>
				<tr>
					<td>Latitude : ${weatherInfoModel.coord.lat}</td>
				</tr>
				<tr>
					<td>Longitude : ${weatherInfoModel.coord.lon}</td>
				</tr>

			</table>
		</c:if>

		<c:if test="${weatherInfoModel.cod ne 200}">
			<h1>Something wrong happened</h1>
		</c:if>

	</c:forEach>


</body>
</html>