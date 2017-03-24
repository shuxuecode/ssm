package ssm;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.alibaba.fastjson.JSON;
import com.zsx.web.dao.UserMapper;
import com.zsx.web.entity.User;

public class MainTest {

	public static void main(String[] args) {
		ApplicationContext ac = new ClassPathXmlApplicationContext(
				"classpath:/applicationContext.xml", "classpath:/spring-mybatis.xml");
//		RedisTemplate redis = (RedisTemplate) ac.getBean("redisTemplate");
		UserMapper bean = ac.getBean(UserMapper.class);
		User selectByPrimaryKey = bean.selectByPrimaryKey("1");
		System.out.println(JSON.toJSONString(selectByPrimaryKey));
	}
}
