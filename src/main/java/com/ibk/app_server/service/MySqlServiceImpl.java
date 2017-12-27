package com.ibk.app_server.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ibk.app_server.mapper.mysql.MySqlMapper;

@Service
@Transactional(value="asdbTx")
public class MySqlServiceImpl implements MySqlService{

	@Autowired MySqlMapper mySqlMapper;
	
	@Override
	public Integer deleteUsers() {
		return mySqlMapper.deleteUsers();
	}

	@Override
	public List<Map<String, String>> selectUsers() {
		return mySqlMapper.selectUsers();
	}

	public Integer insertUser(Map<String,Object> param) {
		return mySqlMapper.insertUser(param);
	}

}
