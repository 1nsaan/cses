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
        Arrays.fill(dp,-1);
        helper(amount);
		System.out.println(dp[amount] == Integer.MAX_VALUE ? -1:dp[amount]);
	}
    //topdown
	static long helper(int n){
     // dp[i]= minimum no of coins to make amount
    if(n<0) return Integer.MAX_VALUE;
    if(n==0) return 0;
    if(dp[n]!=-1) return dp[n];
    dp[n]=Integer.MAX_VALUE;
    for(int j=0;j<coins.length;j++){
         dp[n] = Math.min(dp[n],1 + helper(n-coins[j]));
    }
    
    return dp[n];
} 
    
    
    

    
}
