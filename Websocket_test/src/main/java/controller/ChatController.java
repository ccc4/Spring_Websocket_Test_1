package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/chat")
public class ChatController {
	
	@RequestMapping(value="/ ", method=RequestMethod.GET)
	public String connect() {
		return "chat/main";
	}
	
}
