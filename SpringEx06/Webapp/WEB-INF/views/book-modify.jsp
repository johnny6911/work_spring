<%@ page contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head><title>도서정보 수정</title></head>
<body>
	<h1>*도서정보 수정 페이지*</h1>
	<form action="book-modify.do" method="post">
		<div>도서 번호: ${ book.isbn }</div>
		<div>저자: ${ book.author }</div>
		<div>출판사: ${ book.publisher }</div>
		<div>
			<label>제목<input type="text" name="title" value="${ book.title }"></label>
		</div>
		<div>
			<label>가격<input type="text" name="price" value="${ book.price }"></label>
		</div>
		<div>
			<label>상세 내용</label>
			<textarea name="description">${ book.description }</textarea>
		</div>
		<input type="hidden" name="isbn" value="${ book.isbn }"> <!-- 수정하는것 없이 그대로 값을 전달받고 싶을경우 hidden -->
		<input type="hidden" name="author" value="${ book.author }">
		<input type="hidden" name="publisher" value="${ book.publisher }">
		<input type="submit" value="도서정보 수정">
		<input type="reset" value="입력한 내용 지우기">
		<a href="book-list.do">도서 목록페이지로 이동</a>
	</form>
</body>
</html>