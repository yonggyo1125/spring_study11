<%@ page contentType="text/html; charset=utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<c:url var="action" value="/user/login" />
<form:form method="post" action="${action}" modelAttribute="memberLogin">
	<form:errors element="div" />
	<dl>
		<dt>
			<spring:message code="user.userId" />
		</dt>
		<dd>
			<form:input path="userId" />
			<form:errors path="userId" element="div" />
		</dd>
	</dl>
	<dl>
		<dt>
			<spring:message code="user.userPw" />
		</dt>
		<dd>
			<form:input path="userPw" />
			<form:errors path="userPw" element="div" />
		</dd>
	</dl>
	<div>
		<spring:message var="savedId" code="user.savedId" />
		<form:checkbox path="savedId" value="true" label="${savedId}" />
	</div>
	<button type="submit">
		<spring:message code="user.login" />
	</button>
</form:form>


