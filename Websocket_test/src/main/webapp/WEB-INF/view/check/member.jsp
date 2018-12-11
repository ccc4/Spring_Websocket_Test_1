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

<c:if test="${login eq 1 }">
	<script type="text/javascript">
		alert("로그인성공");
		location.href="${pageContext.request.contextPath}/";
	</script>
</c:if>
<c:if test="${login eq 0 }">
	<script type="text/javascript">
		alert("아이디 또는 비밀번호 확인");
		location.href="${pageContext.request.contextPath}/member/login";
	</script>
</c:if>
<c:if test="${logout eq 1 }">
	<script type="text/javascript">
		alert("로그아웃");
		location.href="${pageContext.request.contextPath}/";
	</script>
</c:if>

</body>
</html>