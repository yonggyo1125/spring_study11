<%@ page contentType="text/html; charset=utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
메인페이지!
<c:if test="${sessionScope.member == null}">
	<a href="<c:url value="/user/login" />">
		<spring:message code="user.login" />
	</a>
	<a href="<c:url value="/user/join" />">
		<spring:message code="user.join" />
	</a>
</c:if>
<c:if test="${sessionScope.member != null}">
	<spring:message code="loginMessage" arguments="${sessionScope.member.userNm},${sessionScope.member.userId}" />
	
	<a href="<c:url value="/user/logout" />">로그아웃</a>
</c:if>