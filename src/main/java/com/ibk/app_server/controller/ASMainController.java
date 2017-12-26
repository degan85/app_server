package com.ibk.app_server.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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
	
	public List<User> selectTest() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.jdbc.Driver");
		Connection c = DriverManager.getConnection("jdbc:mysql://localhost/spring_db?verifyServerCertificate=false&amp;useSSL=false", "root","inno100");
		
		PreparedStatement ps = c.prepareStatement("select * from users");
		
		ResultSet rs = ps.executeQuery();
		
		List<User> users = new ArrayList<User>();
		
		while (rs.next()) {
			User user = new User();
			user.setId(rs.getString("id"));
			user.setName(rs.getString("name"));
			user.setPassword(rs.getString("password"));
			
			users.add(user);
			System.out.println(user.getId());
		}
		
		rs.close();
		ps.close();
		c.close();
		
		return users;
	}
	
	public void deleteUsers() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.jdbc.Driver");
		Connection c = DriverManager.getConnection("jdbc:mysql://localhost/spring_db?verifyServerCertificate=false&amp;useSSL=false", "root","inno100");
		
		PreparedStatement ps = c.prepareStatement("delete from users");
		
		ps.executeUpdate();
		
		ps.close();
		c.close();
	}

	public void insertUser(User user) throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.jdbc.Driver");
		Connection c = DriverManager.getConnection("jdbc:mysql://localhost/spring_db?verifyServerCertificate=false&amp;useSSL=false", "root","inno100");
		
		PreparedStatement ps = c.prepareStatement("insert into users(id, name, password) values(?,?,?)");
		ps.setString(1, user.getId());
		ps.setString(2, user.getName());
		ps.setString(3, user.getPassword());
		
		ps.executeUpdate();
		
		ps.close();
		c.close();
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
