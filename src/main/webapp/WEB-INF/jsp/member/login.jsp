<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:set var="pageTitle" value="회원 로그인" />
<%@ include file="../part/head.jspf"%>
	
<script>
	function submitLoginForm(form) {
		form.loginId.value = form.loginId.value.trim();

		if (form.loginId.value.length== 0) {
			alert('로그인 아이디를 입력해주세요.');
			form.loginId.focus();

			return false;
		}

		if (form.loginId.value.length < 4) {
			alert('로그인 아이디를 4자 이상 입력해주세요.');
			form.loginId.focus();

			return false;
		}

		if (isAlphaNumeric(form.loginId.value) == false) {
			alert('로그인 아이디는 영어 소문자와 숫자만 사용할 수 있습니다.');
			form.loginId.focus();

			return false;
		}

		form.loginId.value = form.loginId.value.toLowerCase();
		
		form.loginPw.value = form.loginPw.value.trim();

		if (form.loginPw.value.length== 0) {
			alert('비밀번호를 입력해주세요.');
			form.loginPw.focus();

			return false;
		}	

		form.submit();
	} 
</script>
	
<div class="article-join-box con">
	<form action="/member/doLogin" method="POST"
		onsubmit="submitLoginForm(this); return false;"
		class="table-box form form-type-1">
		<table>
			<colgroup>
				<col width="100" />
			</colgroup>
			<tbody>
				<tr>
					<th>아이디</th>
					<td><input maxlength="30" name="loginId"
						autofocus="autofocus" placeholder="아이디를 입력해주세요." type="text" /></td>
				</tr>
				<tr>
					<th>비밀번호</th>
					<td><input maxlength="30" name="loginPw"
						 placeholder="비밀번호를 입력해주세요." type="password" /></td>
				</tr>
				<tr>
					<th>로그인</th>
					<td><input type="submit" value="로그인" /> <input 
						onclick="history.back();" type="button" value="취소" /></td>
				</tr>
			</tbody>
		</table>
	</form>
</div>
<%@ include file="../part/foot.jspf"%>