<%@ page contentType="text/html; charset=utf-8" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:url var="action" value="/user/join" />
<spring:message var="agree" code="user.agree" />
<form:form method="post" action="${action}" modelAttribute="memberJoin">
	<spring:message code="loginMessage">
		<spring:argument value="사용자01" />
		<spring:argument value="user01" />
	</spring:message>
	<dl>
		<dt>
			<spring:message code="user.userId" />
		</dt>
		<dd>
			<form:input path="userId" />
			<form:errors path="userId" />
		</dd>
	</dl>
	<dl>
		<dt>
			<spring:message code="user.userPw" />
		</dt>
		<dd>
			<form:password path="userPw" />
			<form:errors path="userPw" />
		</dd>
	</dl>
	<dl>
		<dt>
			<spring:message code="user.userPwRe" />
		</dt>
		<dd>
			<form:password path="userPwRe" />
			<form:errors path="userPwRe" />
		</dd>
	</dl>
	<dl>
		<dt>
			<spring:message code="user.userNm" />
		</dt>
		<dd>
			<form:input path="userNm" />
			<form:errors path="userNm" />
		</dd>
	</dl>
	<dl>
		<dt>
			<spring:message code="user.email" />
		</dt>
		<dd>
			<form:input path="email" />
		</dd>
	</dl>
	<dl>
		<dt>
			<spring:message code="user.mobile" />
		</dt>
		<dd>
			<form:input path="mobile" />
		</dd>
	</dl>
	<div>
		<form:checkbox path="agree" value="true" label="${agree}" />
	</div>
	<button type="submit">가입하기</button>
</form:form>



