package com.ibk.app_server.service;

import java.util.List;
import java.util.Map;

public interface MySqlService {
	Integer deleteUsers();
	Integer insertUser(Map<String, Object> param);
	List<Map<String, String>> selectUsers();
}
