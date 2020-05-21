package ssm;

import javax.jws.soap.SOAPBinding.Use;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.fastjson.JSON;
import com.weshop.dao.UserDao;
import com.zsx.web.dao.UserMapper;
import com.zsx.web.entity.User;
import com.zsx.web.service.UserService;

/**
 * 单元测试
 * @author developer
 *
 */


@RunWith(SpringJUnit4ClassRunner.class)

// 
@WebAppConfiguration(value = "src/main/webapp") //可以不填，默认此目录

@ContextConfiguration(locations = { "file:src/main/resources/applicationContext.xml", "file:src/main/resources/spring-mybatis.xml", "file:src/main/resources/springMVC-servlet.xml" })

public class UtilTest {
	
	@Autowired
	private UserMapper userMapper;
	
	@Autowired
	private UserDao userDao;
	
	@Autowired
	private UserService userService;
	
	@Before
	public void before(){
//		userDao.executeSql("INSERT INTO `user` VALUES ('2231','zhao','shuxue')");
		System.out.println("准备测试！！！");
	}
	
	@After
	public void After(){
		System.out.println("测试结束！！！");
	}
	
	@Test
	public void get() {
		User user = userMapper.selectByPrimaryKey("1");
		System.out.println(JSON.toJSONString(user));
	}
	
	@Test
	public void getAll(){
		User selectByPrimaryKey = userDao.selectByPrimaryKey("99");
		System.out.println(JSON.toJSONString(selectByPrimaryKey));
	}
	
	
	
	
	@Test
	public void add(){
		User user = new User();
		user.setId(""
				+ "7");
		user.setName("Zsx");
		user.setPwd("pwd");
		userService.insert(user);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
