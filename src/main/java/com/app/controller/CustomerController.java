package com.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.app.dao.ITopicDao;
import com.app.service.ITutorialService;

@Controller
@RequestMapping("/customer")
public class CustomerController {
	//dependency : topic DAO i/f
	@Autowired
	private ITopicDao topicDao;
	//dep : tutorial service i/f
	@Autowired
	private ITutorialService tutService;
	
	public CustomerController() {
		System.out.println("In ctor of " + getClass());
	}
	//add req handling method to forward/redirect the clnt to topic.jsp
	@GetMapping("/topics")
	public String showTopics(Model map) {
		System.out.println("in showTopics "+map);
		System.out.println("dao "+topicDao.getClass());
		map.addAttribute("topic_list", topicDao.getallTopics());
		return"/customer/topics"; //AVN : /WEB-INF/views/customer/topics.jsp
	}
	//Hint : http://localhost:9090/day18_boot_cms/customer.tutorial?topicId=2
	//add req handling method to forward clnt to tutorial page
	@GetMapping("/tutorials")
	public String showTutorialTitles(Model map,@RequestParam long topicId) {
		System.out.println("in show tut titiles");
		map.addAttribute("tut_names", tutService.getTutorialDetails(topicId));
		return "/customer/tutorials"; //AVN : /	/WEB-INF/views/customer/tutorials.jsp;
	}
	//http://localhost:9090/day19_boot_cms/customer/tut_details?tut_name=Spring%20MVC%20Flow
	//add req handling method to display selected tutorial details
	@GetMapping("/tut_details")
	public String showTutDetails(@RequestParam String tut_name,Model map) {
		System.out.println("in show tut detils "+tut_name);
		map.addAttribute("tutorial_details", tutService.getTutorialDetails(tut_name));
		return "/customer/tut_details"; //AVN : /WEB-INF/views/customer/tut_details.jsp
	}
}
