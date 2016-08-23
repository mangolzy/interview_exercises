package grammar;

public class StringConst {
	// 同样类容的字符串常量 内存里只有一份 所以地址相同
	// 但是， 执行b+c过程本身new 了一个String...所以地址不同。。。可是内容相同，它new 到哪里去这次。。
		  private static final String MESSAGE="taobao";
		  public static void main(String [] args) {
		    String a ="tao"+"bao";
		    String b="tao";
		    String c="bao";
		    System.out.println(a==MESSAGE);
		    System.out.println((b+c)==MESSAGE);
		  }
		  
		  // true
		  // false
		
}
