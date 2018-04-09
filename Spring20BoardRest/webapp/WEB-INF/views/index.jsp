<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html>
<html>
<head><title>홈페이지</title></head>
<body>
	<h1>홈페이지</h1>
	<div>현재 언어 : ${ pageContext.response.locale }</div>
	<a href="<c:url value='/board/board-list.do'/>"><spring:message code="list"/></a><br>
	<a href="<c:url value='/admin/users-list.do'/>"><spring:message code="userlist"/></a><br>
	<sec:authorize access="!hasRole('ADMIN') and !hasRole('USER')">
		<a href="<c:url value='/join.do'/>"><spring:message code="signA"/></a><br>
		<a href="<c:url value='/login.do'/>"><spring:message code="login"/></a><br>
	</sec:authorize>
	<sec:authorize access="hasRole('ADMIN') or hasRole('USER')">
		<a href="<c:url value='/users-modify.do'/>"><spring:message code="edituserI"/></a>
		<a href="<c:url value='/logout.do'/>"><spring:message code="logout"/></a><br>
	</sec:authorize>
	<a href="index.do?lang=ko"><spring:message code="label.ko"/></a>
	<a href="index.do?lang=en"><spring:message code="label.en"/></a>
</body>
</html>