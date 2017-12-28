package com.ibk.app_server.mapper.mysql;

import java.util.List;
import java.util.Map;

import com.ibk.app_server.dao.User;

public interface MySqlMapper {
	Integer deleteUsers();
	Integer insertUser(Map<String, Object> param); 
	List<Map<String, String>> selectUsers();
	List<User> selectUsersDao();
	
}
