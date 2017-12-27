package com.ibk.app_server.mapper.mysql;

import java.util.List;
import java.util.Map;

public interface MySqlMapper {
	Integer deleteUsers();
	Integer insertUser(Map<String, Object> param); 
	List<Map<String, String>> selectUsers();
	
}
