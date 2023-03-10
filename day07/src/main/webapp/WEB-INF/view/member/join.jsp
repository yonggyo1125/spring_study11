<%@ page contentType="text/html; charset=utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<form:form method="post" action="<c:url value='/member/join' />" modelAttribute="memberJoin">
	<dl>
		<dt>아이디</dt>
		<dd>
			<form:input path="userId" />
		</dd>
	</dl>
	<dl>
		<dt>비밀번호</dt>
		<dd>
			<form:password path="userPw" />
		</dd>
	</dl>
	<dl>
		<dt>비밀번호 확인</dt>
		<dd>
			<form:password path="userPwRe" />
		</dd>
	</dl>
	<dl>
		<dt>회원명</dt>
		<dd>
			<form:input path="userNm" />
		</dd>
	</dl>
	<div>
		<form:checkbox itemLabel="약관에 동의하세요" itemValue="true" path="agree" />
	</div>
	<button type="submit">가입하기</button>
</form:form>


