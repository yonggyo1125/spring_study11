<%@ page contentType="text/html; charset=utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<form method="post" action="<c:url value='/member/join' />">
	<dl>
		<dt>아이디</dt>
		<dd>
			<input type="text" name="userId" value="${member.userId}">
		</dd>
	</dl>
	<dl>
		<dt>비밀번호</dt>
		<dd>
			<input type="password" name="userPw">
		</dd>
	</dl>
	<dl>
		<dt>비밀번호 확인</dt>
		<dd>
			<input type="password" name="userPwRe">
		</dd>
	</dl>
	<dl>
		<dt>회원명</dt>
		<dd>
			<input type="text" name="userNm" value="${member.userNm}">
		</dd>
	</dl>
	<div>
		<input type="checkbox" name="agree" id="agree" value="true">
		<label for="agree">약관에 동의함</label>
	</div>
	<button type="submit">가입하기</button>
</form>


