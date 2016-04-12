package netease;

import java.math.BigInteger;

public class Kangaroo {
	public static BigInteger count(int n){
	BigInteger temp[] = new BigInteger[11];
    BigInteger nums[] = new BigInteger[11];

    for (int i = 1; i <= 10; i++){
        temp[i] = new BigInteger("0");
        nums[i] = new BigInteger("0");
    }
    nums[1] = new BigInteger("1");
    nums[5] = new BigInteger("1");

    for (int i = 2; i <= n; ++ i){
        for (int j = 1; j < 10; ++ j){
            if(j < 3){
                temp[j + 1] = temp[j + 1].add(nums[j]);
            }else if (j < 8){
                temp[j + 1] = temp[j + 1].add(nums[j]);
                temp[1] = temp[1].add(nums[j]);
            }else {
                if(j == 9)  temp[j + 1] = temp[j + 1].add(nums[j]);
            }
        }
        System.arraycopy(temp, 0, nums, 0, temp.length);
        for (int K = 1; K <= 10; K++){
            temp[K] = new BigInteger("0");
        }

    }
    BigInteger sum = new BigInteger("0");
    for (int i = 1; i <= 10; ++ i){
        sum = sum.add(nums[i]);
    }
    return sum;
	}
	
	/*
	 
	public class Kangaroo {
    private static int count(int n){
        int tmp[] = new int[11];
        int res[] = new int[11];
        res[0] = 1;
        res[5] = 1;
        for(int i=2;i<n;i++){
            for(int j=0;j<=10;j++){
                if(j<3){
                    tmp[j+1] = res[j];
                }else{
                    if(j != 10) {
                        tmp[0] += res[j];
                        tmp[j + 1] = res[j];
                    }else{
                        tmp[j] = 0;
                    }
                }
            }
            for(int j=1;j<=10;j++){
                res[j] = tmp[j];
            }
        }
        int sum = 0;
        for(int i=0;i<10;i++){
            sum+=res[i];
        }
        return sum;
    }
		*/
    public static void main(String[] args){
        System.out.println(count(2000));
    }
   

}