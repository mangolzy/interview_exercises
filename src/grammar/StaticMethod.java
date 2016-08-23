package grammar;

public class StaticMethod {
	
		   private static void testMethod(){
		        System.out.println("testMethod");
		   }
		   public static void main(String[] args) {
		        ((StaticMethod)null).testMethod();  // if it's not static method.
		        									// runtime exception: nullpointerexception
		        									// 加载过的类，类转换没问题，但是非静态函数不能用？为什么呢？？不存在在方法区，存在在堆栈里？
		        
		   }
		
}
