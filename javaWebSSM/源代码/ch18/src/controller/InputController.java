package controller;
import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
@Controller
public class InputController {
	@RequestMapping("/input")
	public String input(HttpServletRequest request, Model model){
		String names[] = { "zhao", "qian", "sun", "li" };
		request.setAttribute("name", names);
		String address[] = { "beijing", "shanghai", "shenzhen"};
		model.addAttribute("address", address);
		return "show";
	}
}
