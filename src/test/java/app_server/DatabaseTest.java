package app_server;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.ibk.app_server.config.ASMvcConfig;
import com.ibk.app_server.config.ASdbConfig;
import com.ibk.app_server.controller.ASMainController;
import com.ibk.app_server.dao.User;

@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = ASMvcConfig.class)
public class DatabaseTest {
	
	@Autowired ASMainController controller;
	@Autowired ASdbConfig dbConfig;
	
	@Before
	public void setUp() {
	}
	
	@Test
	public void DB_검색_test() throws ClassNotFoundException, SQLException {
		controller.deleteUsers();
		List<Map<String,String>> users = controller.selectUsers(); 
		assertThat(users.size(), is(0));
	}
	
	@Test
	public void DB_입력_test() throws ClassNotFoundException, SQLException {
		
		controller.deleteUsers();
		
		List<Map<String,String>> users = controller.selectUsers();
		assertThat(users.size(), is(0));
		
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("id", "id_1");
		param.put("name", "user_name1");
		param.put("password", "user_password1");
		controller.insertUser(param);
		
		users = controller.selectUsers();
		
		assertThat(users.size(), is(1));
		
		assertThat(users.get(0).get("Id"), is(param.get("id")));
		assertThat(users.get(0).get("Name"), is(param.get("name")));
		assertThat(users.get(0).get("Password"), is(param.get("password")));
	}
	@Test
	public void 프로퍼티_연결_테스트() {
		String result = dbConfig.getProperties();

		assertThat(result, is("root"));
	}
	
	@Test
	public void user_dao_테스트() {
		controller.deleteUsers();
		
		List<User> users = controller.selectUsersDao();
		assertThat(users.size(), is(0));
		
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("id", "id_1");
		param.put("name", "user_name1");
		param.put("password", "user_password1");
		controller.insertUser(param);
		
		users = controller.selectUsersDao();
		assertThat(users.size(), is(1));
		
		assertThat(users.get(0).getId(), is(param.get("id")));
		assertThat(users.get(0).getName(), is(param.get("name")));
		assertThat(users.get(0).getPassword(), is(param.get("password")));
	}
}
