package grammar;

class Enclosingone {
    //非静态内部类
    public class InsideOne {}
    //静态内部类
    public static class InsideTwo{}
}
public class Outer_Inner {
	
	
	    public static void main(String args []){
	    	
	    	Enclosingone e1 = new Enclosingone();
	    	Enclosingone.InsideOne o1 = e1.new InsideOne();
	    	Enclosingone.InsideTwo o2 = new Enclosingone.InsideTwo();
	    	/*
	    	 * Outer.Inner a=new Outer().new Inner()（非静态，先有Outer对象才能有属性）
	    	 * Outer.Inner a=new Outer.Inner()要把Outer.Inner看成一部分，就像类变量一样
	    	 */
	        Enclosingone.InsideOne obj1 = new Enclosingone().new InsideOne();//非静态内部类对象
	        Enclosingone.InsideTwo obj2 = new Enclosingone.InsideTwo();//静态内部类对象
	    }
	
}
