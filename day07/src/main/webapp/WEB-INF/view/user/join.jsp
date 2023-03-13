<%@ page contentType="text/html; charset=utf-8" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:url var="action" value="/user/join" />
<form:form method="post" action="${action}" modelAttribute="memberJoin">
	<dl>
		<dt>
			<spring:message code="user.userId" />
		</dt>
		<dd>
			<form:input path="userId" />
		</dd>
	</dl>
	<dl>
		<dt>
			<spring:message code="user.userPw" />
		</dt>
		<dd>
			<form:password path="userPw" />
		</dd>
	</dl>
</form:form>