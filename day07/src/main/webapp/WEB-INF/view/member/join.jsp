<%@ page contentType="text/html; charset=utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<c:url var="action" value='/member/join' />

<form:form method="post" action="${action}" modelAttribute="memberJoin">
	<dl>
		<dt>회원유혀</dt>
		<dd>
			<form:radiobuttons items="${memberTypes}" itemLabel="title" itemValue="value" path="memberType"/>
		</dd>
	</dl>
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
	<dl>
		<dt>취미</dt>
		<dd>
			<form:checkboxes items="${hobbies}" path="hobby" />
		</dd>
	</dl>
	<dl>
		<dt>선호 에디터</dt>
		<dd>
			<form:checkboxes items="${editors}" path="editor" itemValue="value" itemLabel="title" />
		</dd>
	</dl>
	<div>
		<form:checkbox path="agree" />
		약관에 동의하세요.
	</div>
	<button type="submit">가입하기</button>
</form:form>


