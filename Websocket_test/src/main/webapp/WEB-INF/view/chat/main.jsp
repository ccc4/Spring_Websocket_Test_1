<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.1.1.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/sockjs-client@1/dist/sockjs.min.js"></script>
</head>
<body>

<c:if test="${empty loginMember }">
	<script type="text/javascript">
		alert("잘못된 접근입니다.");
		location.href="${pageContext.request.contextPath }/";
	</script>
</c:if>


	<div>
		<div id="data"></div>
		<div>
			<input type="text" id="message">
			<button type="button" id="btn_send">전송</button>
		</div>
	</div>
	<button type="button" onclick="location.href='${pageContext.request.contextPath}/'">메인으로</button>


<script type="text/javascript">
	$(document).ready(function() {
		$("#btn_send").click(function() {
			sendMessage();
			$("#message").val('');
		})
	})
	
	let sock = new SockJS("<c:url value="/echo"/>");
	sock.onmessage = onMessage;
	sock.onclose = onClose;
	
	function sendMessage() {
		sock.send($("#message").val());
	}
	function onMessage(msg) {
		var data = msg.data;
		$("#data").append(data + "<br/>");
	}	
	function onClose(evt) {
		$("#data").append("연결 끊김");
	}
</script>

</body>
</html>