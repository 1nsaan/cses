import java.io.*;
import java.math.BigInteger;
import java.util.*;
import static java.lang.Math.*;
 
public class Solution implements Runnable{
	static long dp[];

	public static void main(String[] args) {
		new Thread(null, new Solution(), "", 256 * (1L << 20)).start();
	}
    
    public void run(){
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		dp = new long[n+1];
		dp[0]=1;
		helper(n);
		System.out.println(dp[n]);
	}
 
	static long helper(int n){
        //bottom-up 
        for(int i=1;i<n+1;i++){
		for(int j=1;j<7;j++){
        if((i-j)>=0)
            // (a+b) mod m = (a mod m + b mod m ) mod m 
			dp[i]=  ((dp[i-j] % (1000000007)) + (dp[i] % (1000000007)))  % (1000000007);
		    }
        }
		return dp[n];
	     
	} 
    
}
