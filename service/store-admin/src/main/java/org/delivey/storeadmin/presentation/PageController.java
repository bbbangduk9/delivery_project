package org.delivey.storeadmin.presentation;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("")

public class PageController {

	@RequestMapping(path = {"", "/main"})
	public ModelAndView main(){
		return new ModelAndView("main"); //VIEWNAME = main.html => main.html이랑 매핑
	}

	@RequestMapping("/order")
	public ModelAndView order(){
		return new ModelAndView("order/order");
	}
}
