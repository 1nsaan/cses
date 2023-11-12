import java.io.*;
import java.math.BigInteger;
import java.util.*;
import static java.lang.Math.*;
 
public class Solution implements Runnable{
	static long dp[];
    static int coins[];
	public static void main(String[] args) {
		new Thread(null, new Solution(), "", 256 * (1L << 20)).start();
	}
    
    public void run(){
	    Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int amount = sc.nextInt();
		coins=new int[n+1];
		for(int i=0;i<n;i++){
			coins[i]= sc.nextInt();
		}
		dp = new long[amount+1];
        helper(amount);
		System.out.println(dp[amount] == Integer.MAX_VALUE ? -1:dp[amount]);
	}
    //topdown
	static long helper(int amount){
     // dp[i]= minimum no of coins to make amount
    for(int i=1;i<amount+1;i++){
    dp[i]=Integer.MAX_VALUE;
    for(int j=0;j<coins.length;j++){
        if(i-coins[j]>=0)
         dp[i] = Math.min(dp[i],1 + dp[i-coins[j]]);
         }
    }
    return dp[amount];
} 
    
    
    

    
}
