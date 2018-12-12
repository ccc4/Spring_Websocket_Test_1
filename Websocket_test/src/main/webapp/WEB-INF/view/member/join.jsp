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
		<form action="${pageContext.request.contextPath }/member/join" method="POST">
			<div>
				<input type="text" name="name" placeholder="사용자 성함">
			</div>
			<div>
				<input type="text" name="id" placeholder="아이디">
			</div>
			<div>
				<input type="password" name="password" placeholder="비밀번호">
			</div>
			<button type="submit">가입</button>
		</form>
	</div>
	<button type="button" onclick="location.href='${pageContext.request.contextPath}/'">메인으로</button>
	
</body>
</html>