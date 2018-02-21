<%@ page contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head><title>도서정보 삭제 확인페이지</title></head>
<body>
	<h1>-도서 정보삭제 확인-</h1>
	<p>정말로 ${ isbn }번 도서를 삭제하시겠습니까?</p>
	<!-- 
		원래 삭제할 때에는 HTTP Method delete를 사용해야 하지만
		html의 form은 get과 post 두가지만 제공하므로
		delete 대신 post를 사용한다
	 -->
	<form action="book-remove.do" method="post">
		<input type="hidden" name="isbn" value="${ isbn }">
		<input type="submit" value="도서 정보 삭제">
	</form>
	<a href="book-list.do">도서 목록 페이지로 이동</a>
</body>
</html>