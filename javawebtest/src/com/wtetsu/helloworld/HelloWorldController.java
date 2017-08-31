package com.wtetsu.helloworld;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelloWorldController {

	@RequestMapping("/welcome")
	public ModelAndView helloWorld() {

		StringBuilder builder = new StringBuilder();
		
		HelloWorldData data = new HelloWorldData();
		List<Map<String, Object>>  records = data.readCustomerRecords();
		
		for (Map<String, Object> r : records) {
			builder.append(r.get("customer_id") + "|" + r.get("customer_name") + "<br/>");
		}
		
		return new ModelAndView("welcome", "message", builder.toString());
	}
}
