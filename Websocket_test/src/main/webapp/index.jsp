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
<div></div>
	<c:if test="${empty loginMember }">
		<div>
			<button type="button" onclick="location.href='${pageContext.request.contextPath}/member/login'">로그인</button>
			<button type="button" onclick="location.href='${pageContext.request.contextPath}/member/join'">회원가입</button>
		</div>
	</c:if>
	<c:if test="${!empty loginMember }">
		<div>
			<div>
				<span>${loginMember.name } 님 반갑습니다.</span>
			</div>
			<div>
				<button type="button" onclick="location.href='${pageContext.request.contextPath}/member/logout'">로그아웃</button>
				<button type="button" onclick="location.href='${pageContext.request.contextPath}/chat/'">채팅접속</button>
			</div>
		</div>
	</c:if>

</body>
</html>