package controller;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
@Controller
@RequestMapping("/my")
public class MyController {
	@RequestMapping("/first")
	public String first(){
		return "first";
	}
	@RequestMapping("/second")
	public String second(){
		return "second";
	}
	@RequestMapping("/third")
	public String third(){
		return "third";
	}
}
