package websocket;

import java.util.ArrayList;
import java.util.Map;

import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import model.Member;

public class EchoHandler extends TextWebSocketHandler {
	
	private ArrayList<WebSocketSession> sessionList = new ArrayList<>();
	
	@Override
	public void afterConnectionEstablished(WebSocketSession session) throws Exception {
		sessionList.add(session);
		
		Map<String, Object> attrMap = session.getAttributes();
		Member member = (Member) attrMap.get("loginMember");
		System.out.printf("%s 연결됨\n", member.getId());
	}
	
	@Override
	protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
		Map<String, Object> attrMap = session.getAttributes();
		Member member = (Member) attrMap.get("loginMember");
		System.out.printf("%s : %s\n", member.getId(), message.getPayload());
		for(WebSocketSession sess : sessionList) {
			sess.sendMessage(new TextMessage(member.getId() + " : " + message.getPayload()));
		}
	}
	
	@Override
	public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
		sessionList.remove(session);
		Map<String, Object> attrMap = session.getAttributes();
		Member member = (Member) attrMap.get("loginMember");
		System.out.printf("%s 연결 끊김\n", member.getId());
	}
}
