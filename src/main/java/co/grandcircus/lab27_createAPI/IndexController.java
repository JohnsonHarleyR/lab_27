package co.grandcircus.lab27_createAPI;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {
	
	//test
	@RequestMapping("/")
	public String home() {
		
		return "index";
	}

}
