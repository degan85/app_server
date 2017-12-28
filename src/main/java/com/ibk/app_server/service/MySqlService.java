package com.ibk.app_server.service;

import java.util.List;
import java.util.Map;

import com.ibk.app_server.dao.User;

public interface MySqlService {
	Integer deleteUsers();
	Integer insertUser(Map<String, Object> param);
	List<Map<String, String>> selectUsers();
	List<User> selectUsersDao();
}
