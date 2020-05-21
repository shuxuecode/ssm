package ssm;

import java.util.Calendar;

public class TTTTT {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Calendar calendar = Calendar.getInstance();
		System.out.println(calendar.getTimeInMillis());
		System.out.println(calendar.getTime());
		
		
		
		 // 15 分钟以后  
//	    calendar.add(Calendar.MINUTE, 1);  
	    calendar.add(Calendar.SECOND, 30);  
	    
	    System.out.println(calendar.getTimeInMillis());
	    
//	    前者大，显示 1 
//	    后者大，显示 -1  
//	    时间相同，显示 0  
	    int compareTo = calendar.compareTo(calendar);
	    System.out.println(compareTo);
	    
	}
}
