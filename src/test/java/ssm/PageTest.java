package ssm;

import java.util.List;

import javax.annotation.Resource;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.PageHelper;
import com.weshop.dao.UserDao;
import com.zsx.web.entity.User;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "file:src/main/resources/applicationContext.xml", "file:src/main/resources/spring-mybatis.xml", "file:src/main/resources/springMVC-servlet.xml" })
public class PageTest {

	@Resource
	private UserDao userDao;
	
	
	
	
	@Before
	public void before(){
		System.out.println("准备测试！！！");
	}
	
	@After
	public void After(){
		System.out.println("测试结束！！！");
	}
	
	
	@Test
	public void get() {
		PageHelper.startPage(2, 2);
		List<User> selectAll = userDao.selectAll();
		System.out.println(selectAll.size());
		for (User user : selectAll) {
			System.out.println(JSON.toJSONString(user));
		}
	}
	
	
	
	
}
