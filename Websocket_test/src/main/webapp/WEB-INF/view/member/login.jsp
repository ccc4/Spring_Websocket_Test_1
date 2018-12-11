<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<c:if test="${!empty loginMember }">
	<script type="text/javascript">
		location.href="${pageContext.request.contextPath }/";
	</script>
</c:if>

	<div>
		<form action="${pageContext.request.contextPath }/member/login" method="POST">
			<input type="text" name="id" placeholder="아이디">
			<input type="password" name="password" placeholder="비밀번호">
			<button type="submit">로그인</button>
		</form>
	</div>

</body>
</html>