package alibaba;

import java.math.BigInteger;
 /*
  * 1、

若原来牌是全新升序排列，则一次洗牌后顺序可能性的数目为973469712824056。分析如下：

这种洗牌方法，洗一次牌保证了牌是按照两个有序子序列合并而成的。同时也可以看作计算插空法的可能数目，假设F(M,N)表示将长为N的序列有序插入M个空位，则针对此洗牌情景有
如下公式：
F(28,27) = F(28,26) + F(27,26) + ... + F(1,26)
其中当M = 1时， F = 1, 故 F(1,26) = 1，由此展开可以计算出 
F(28,26) = F(28,25) + F(27,25) + ... + F(1,25)
F(27,26) = F(27,25) + F(26,25) + ... + F(1,25) 
...............

编程求出矩阵：
public class Poke {
   public static void main(String[] args){
	   long [][] a = new long[28][27];
	   for(int i = 0; i < 28; i++)
	   {
		   for(int j = 0; j < 27; j++){
			   if(i == 0 || j == 0)
				   a[i][j] = 1;
			   else{
				   int k = i;
				   while(k-- >= 0){
					   a[i][j] += a[k][j-1];
				   }
			   }
		   }
	   }
	   
	   System.out.println(a[27][26]);
   }
}

2、
思考一：按照前一题的思路，洗牌一次会产生两个有序子序列，再洗一次，前一半里面两个有序子序列和后一半的两个有序子序列会产生四个有序子序列，平均每个的长度为 54/4 = 13.5。
思考二：而且54个牌的全排序为 54！约等于 2^71。上述排序约为2^40。
思考三：联想排序算法中，乱序数的定义，考虑每次洗牌最多可以增加多少乱序数。
我猜想此下界约为六七次。
  */
public class Poke {
   public static void main(String[] args){
	   long [][] a = new long[28][28];
	   for(int i = 0; i < 28; i++)
	   {
		   for(int j = 0; j < 28; j++){
			   if(i == 0 || j == 0){
				   a[i][j] = 1;
				   System.out.print(a[i][j] + " ");
			   }
			   else{
				   int k = i;
				   while(k >= 0){
					   a[i][j] += a[k][j-1];
					   
					   k--;
				   }
				   System.out.print(a[i][j] + " ");
			   }
		   }
		   System.out.println();
	   }
	 
	   System.out.println(a[27][27]);
   }
}
