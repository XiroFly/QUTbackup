package controller;
import java.util.Locale;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
@Controller
public class I18NTestController {
	@RequestMapping("/i18nTest")
	/**
	 * locale接收请求参数locale值，并存储到session中
	 */
	public String first(Locale locale){
		return "first";
	}
}
