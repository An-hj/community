<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:set var="pageName" value="${board.name }게시물 작성" />
<%@ include file="../part/head.jspf"%>
	
<form action="/article/doWrite" method="POST">	
	<input type="hidden" name="boardId" value="${board.id }" />
	<div class="con table-box">	
		<table>
			<colgroup>
				<col width="100" />
			</colgroup>
			<tbody>
				<tr>
					<th>제목</th>
					<td><input autocomplete="off" name="title"
						autofocus="autofocus" placeholder="제목을 입력해주세요." type="text" /></td>
				</tr>
				<tr>
					<th>내용</th>
					<td><textarea name="body" placeholder="내용을 입력해주세요."></textarea></td>
				</tr>
				<tr>
					<th>작성</th>
					<td><input type="submit" value="작성" /> <input 
						onclick="history.back();" type="button" value="취소" /></td>
				</tr>
			</tbody>
		</table>
	</div>
</form>

<%@ include file="../part/foot.jspf"%>