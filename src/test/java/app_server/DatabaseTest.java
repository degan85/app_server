package app_server;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.sql.SQLException;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.ibk.app_server.controller.ASMainController;
import com.ibk.app_server.dao.User;

public class DatabaseTest {

	ASMainController controller;
	
	@Before
	public void setUp() {
		controller = new ASMainController();
	}
	
	@Test
	public void DB_검색_test() throws ClassNotFoundException, SQLException {
		controller.deleteUsers();
		
		List<User> users = controller.selectTest(); 
		assertThat(users.size(), is(0));
	}
	
	@Test
	public void DB_입력_test() throws ClassNotFoundException, SQLException {
		
		controller.deleteUsers();
		
		List<User> users = controller.selectTest(); 
		assertThat(users.size(), is(0));
		
		User user = new User();
		user.setId("id_1");
		user.setName("user_name1");
		user.setPassword("user_password1");
		controller.insertUser(user);
		
		users = controller.selectTest();
		assertThat(users.size(), is(1));
		assertThat(users.get(0).getId(), is(user.getId()));
		assertThat(users.get(0).getName(), is(user.getName()));
		assertThat(users.get(0).getPassword(), is(user.getPassword()));
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
}
