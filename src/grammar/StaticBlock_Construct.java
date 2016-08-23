package grammar;


/*
 * 其中涉及：静态初始化代码块、构造代码块、构造方法
当涉及到继承时，按照如下顺序执行：
1、执行父类的静态代码块 
static {
        System.out.println("static A");
    }
输出:static A
2、执行子类的静态代码块
static {
        System.out.println("static B");
    }
输出:static B
3、执行父类的构造代码块
{
        System.out.println("I’m A class");
    }
输出:I'm A class
4、执行父类的构造函数
public HelloA() {
    }
输出：无
5、执行子类的构造代码块
{
        System.out.println("I’m B class");
    }
输出:I'm B class
6、执行子类的构造函数
public HelloB() {
    }
输出：无


1.静态代码块：是在类的加载过程的第三步初始化的时候进行的，主要目的是给类变量赋予初始值。
2.构造代码块：是独立的，必须依附载体才能运行，Java会把构造代码块放到每种构造方法的前面，
			用于实例化一些共有的实例变量，减少代码量。
3.构造方法：用于实例化变量。
 */
class HelloB extends HelloA {
	public HelloB()
	{}
	{
		System.out.println("I’m B class");
	 }
	static{
		System.out.println("static B");
	}
 
}
class HelloA{
	public HelloA(){
	}
	{
		System.out.println("I’m A class");
	}
	static{
		System.out.println("static A");
	}
}
public class StaticBlock_Construct {

	
	public static void main(String[] args)
	 {
	     new HelloB();
	 }

}
