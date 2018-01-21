<%@page import="org.springframework.context.i18n.LocaleContextHolder"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<!DOCTYPE html>
<html>
<c:set var="resourcesBase" value="${pageContext.request.contextPath}/resources" />
<c:set var="cssBase" value="${resourcesBase}/css" />
<c:set var="jsBase" value="${resourcesBase}/js" />
<c:set var="imgBase" value="${resourcesBase}/img" />

<head>
<title>Spring MVC</title>
</head>


<body>
	<h1>CABECERA</h1>
	<div id="body-wrapper">
		<div id="base-body">
			<tiles:insertAttribute name="body" />
		</div>
	</div>
	<h2>PIE DE PAGINA</h2>
</body>

</html>