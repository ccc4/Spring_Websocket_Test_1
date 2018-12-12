package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import model.Member;
import service.MemberService;

@Controller
@RequestMapping("/member")
@SessionAttributes("loginMember")
public class MemberController {

	private static final String RESULT_CHECK = "check/member";
	
	@Autowired
	private MemberService service;
	
	
	@RequestMapping(value="/login", method=RequestMethod.GET)
	public String login() {
		return "member/login";
	}
	@RequestMapping(value="/login", method=RequestMethod.POST)
	public String login(Model model, Member member) {
		
		Member result = service.login(member);
		if(result == null) {
			model.addAttribute("login", 0);
		} else {
			model.addAttribute("loginMember", result);
			model.addAttribute("login", 1);
		}
		return RESULT_CHECK;
	}
	
	@RequestMapping(value="/logout", method=RequestMethod.GET)
	public String logout(Model model, SessionStatus status) {
		
		status.setComplete();
		model.addAttribute("logout", 1);
		
		return RESULT_CHECK;
	}
	
	@RequestMapping(value="/join", method=RequestMethod.GET)
	public String join() {
		return "member/join";
	}
	@RequestMapping(value="/join", method=RequestMethod.POST)
	public String join(Model model, Member member) {
		int result = service.join(member);
		if(result == 1) {
			model.addAttribute("join", result);
			model.addAttribute("name", member.getName());
		} else {
			model.addAttribute("join", result);
		}
		return RESULT_CHECK;
	}
}
