<%@ page language="java" %>
<%@taglib  prefix="spring" uri="http://www.springframework.org/tags" %>

<div id="error-form">
	<h1 id="error-title"><spring:message  code="error.title" /></h1> 
	<div id="error-content">
		<spring:message code="error.content" />		
		<p id="error-back-button" class="clearfix" style="margin-top: 2em;">
			<a style="float: left;" class="button" href="<c:url value='' />"><spring:message code="back" /></a>
		</p>
	</div>
</div>
