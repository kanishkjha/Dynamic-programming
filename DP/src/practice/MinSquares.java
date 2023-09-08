package practice;

public class MinSquares {
	
// Memoization: Time complexity=> O(n)
	
	public static int minSquares(int n, int dp[]) {
		
		if(n==0) {
			return 0;
		}
		
		int minAns=Integer.MAX_VALUE;
		
		for(int i=1; i*i<=n; i++) {
			int currentAns;
			if(dp[n-(i*i)]==-1) {
				currentAns=minSquares(n-(i*i), dp);
				dp[n-(i*i)]=currentAns;
			}
			else {
				currentAns=dp[n-(i*i)];
			}
			
			if(minAns>currentAns) {
				minAns=currentAns;
			}
		}
		
		int myAns= 1+minAns;
		return myAns;
	}

// Dp iterative: Best
	
	public static int minSquaresI(int n) {
		
		int dp[]= new int[n+1];
		dp[0]=0;
		
		for(int i=1; i<=n; i++) {
			
			int minAns= Integer.MAX_VALUE;
			
			for(int j=1; j*j<=i; j++) {
				
				int currentAns=dp[i-(j*j)];
				
				if(minAns>currentAns) {
					minAns=currentAns;
				}
			}
			
			dp[i]=1+minAns;
		}
		
		return dp[n];
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int n=41;
		int dp[]= new int[n+1];
		
		for(int i=0; i<dp.length; i++) {
			dp[i]=-1;
		}
		
		int ans1=minSquares(n,dp);
		int ans2=minSquaresI(n);
		System.out.println(ans1);
		System.out.println(ans2);
	}

}
