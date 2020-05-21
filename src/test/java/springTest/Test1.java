package springTest;

import org.springframework.context.support.FileSystemXmlApplicationContext;

public class Test1 {

	public static void main(String[] args) {
		FileSystemXmlApplicationContext context = new FileSystemXmlApplicationContext("applicationContext.xml");
		
		Object bean = context.getBean("TTTTT");
		
		System.out.println(bean);
		
		
		
		
	}

}
