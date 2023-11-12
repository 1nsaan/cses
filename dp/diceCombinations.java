
//Top-down approach ->  will throw tle 
import java.io.*;
import java.math.BigInteger;
import java.util.*;
import static java.lang.Math.*;
 
public class Solution implements Runnable{
	static long dp[];

	public static void main(String[] args) {
    //Thread(ThreadGroup group, Runnable target, String name, long stackSize)
		new Thread(null, new Solution(), "", 256 * (1L << 20)).start();
	}
    
    public void run(){
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		dp = new long[n+1];
    Arrays.fill(dp,-1);
		dp[0]=1;
        
		helper(n);
		System.out.println(dp[n]);
	}
 
	static long helper(int n){
        //top-down approach
		if(n<0) return 0;
		if(dp[n]!=-1) return dp[n];
		dp[n]=0;
		for(int j=1;j<7;j++){
            // (a+b) mod m = (a mod m + b mod m ) mod m 
			dp[n]=  ((helper(n-j) % (1000000007)) + (dp[n] % (1000000007)))  % (1000000007);
		}
		return dp[n];
	     
	}


 
 
    
}
