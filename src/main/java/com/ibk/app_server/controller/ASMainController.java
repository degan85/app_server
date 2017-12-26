package com.ibk.app_server.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ibk.app_server.dao.User;

@Controller
@RequestMapping(value = "/")
public class ASMainController {
	Logger logger = LoggerFactory.getLogger(ASMainController.class);
	
	public Boolean selectTest() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.jdbc.Driver");
		Connection c = DriverManager.getConnection("jdbc:mysql://localhost/spring_db?verifyServerCertificate=false&amp;useSSL=false", "root","inno100");
		
		PreparedStatement ps = c.prepareStatement("select * from users");
		
		ResultSet rs = ps.executeQuery();
		if(rs.next()) {
			System.out.println(rs.getString("id"));
			return true;
		}
		return false;
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public String first() {
		logger.debug("Hello World!!");
		System.out.println("@@@@@@");
		return "login";
	}
	
	@RequestMapping(value = "/ss", method = RequestMethod.GET)
	public String testSS(HttpServletRequest res, Model model) {
		logger.debug("Hello World!!");
		System.out.println("ssssss");
		return "login";
	}
	
	
	
	
	
}
