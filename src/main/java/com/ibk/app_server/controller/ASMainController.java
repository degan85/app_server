package com.ibk.app_server.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ibk.app_server.dao.User;
import com.ibk.app_server.service.MySqlService;

@Controller
@RequestMapping(value = "/")
public class ASMainController {

	@Autowired MySqlService mySqlService;
	
	Logger logger = LoggerFactory.getLogger(ASMainController.class);
	
	public List<Map<String,String>> selectUsers() {
		return mySqlService.selectUsers();
	}
	
	public Integer deleteUsers() {
		return mySqlService.deleteUsers();
	}

	public Integer insertUser(Map<String, Object> param) {
		return mySqlService.insertUser(param);
	}
	
	public List<User> selectUsersDao() {
		return mySqlService.selectUsersDao();
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public String first() {
		logger.debug("Hello World!!");
		System.out.println("@@@@@@");
		return "login";
	}
	
	@RequestMapping(value = "/ss", method = RequestMethod.GET)
	public String testSS(HttpServletRequest req, Model model) {
		logger.debug("Hello World!!");
		System.out.println("ssssss");
		List<Map<String,String>> result = mySqlService.selectUsers();
		req.setAttribute("test", "success!!");
		model.addAttribute("testmodel", "modelObject");
		return "login";
	}
	
	@RequestMapping(value = "/ajaxTest", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> ajaxTest(@RequestParam("inputValue") String value1) {
		Map<String, Object> jsonObject = new HashMap<String, Object>();
		
		System.out.println("입력된 값 : "+value1);
		List<Map<String,String>> result = mySqlService.selectUsers(); 
		jsonObject.put("result", result); 
		
		return jsonObject;
 	}
	
	
	/*
	 * 401 ERROR
	 */
	@RequestMapping(value = "/error401", method = RequestMethod.GET)
	public String error401(HttpServletResponse res, Model model) {
		res.setStatus(HttpServletResponse.SC_OK);
		model.addAttribute("contents","error/error401");
		
		return "/error401";
	}
	
	/*
	 * 403 ERROR
	 */
	@RequestMapping(value = "/error403", method = RequestMethod.GET)
	public String error403(HttpServletResponse res, Model model) {
		res.setStatus(HttpServletResponse.SC_OK);
		model.addAttribute("contents","error/error403");
		
		return "/error403";
	}
	
	/*
	 * 404 ERROR
	 */
	@RequestMapping(value = "/error404", method = RequestMethod.GET)
	public String error404(HttpServletResponse res, Model model) {
		res.setStatus(HttpServletResponse.SC_OK);
		model.addAttribute("contents","error/error404");
		
		return "/error404";
	}

	/*
	 * 500 ERROR
	 */
	@RequestMapping(value = "/error500", method = RequestMethod.GET)
	public String error500(HttpServletResponse res, Model model) {
		res.setStatus(HttpServletResponse.SC_OK);
		model.addAttribute("contents","error/error500");
		
		return "/error500";
	}
	
	/*
	 * 501 ERROR
	 */
	@RequestMapping(value = "/error501", method = RequestMethod.GET)
	public String error501(HttpServletResponse res, Model model) {
		res.setStatus(HttpServletResponse.SC_OK);
		model.addAttribute("contents","error/error501");
		
		return "/error501";
	}
	
	
}
