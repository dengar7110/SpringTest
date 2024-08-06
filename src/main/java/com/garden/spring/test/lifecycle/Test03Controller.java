package com.garden.spring.test.lifecycle;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/lifecycle/test03")
public class Test03Controller {

	@RequestMapping("/1")
	public String view() {
		return "lifecycle/test03";
	}
}
