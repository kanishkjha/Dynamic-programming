package practice;

public class Knapsack01 {
	
// Recursive
	
	public static int knapsack(int[] weights, int[] values, int n, int maxWeight) {

		return knapsack(weights, values, n, maxWeight, 0);
	}

	public static int knapsack(int[] weights, int[] values, int n, int maxWeight, int i) {

		if(i>=weights.length || maxWeight==0){
			return 0;
		}

		if(weights[i]<=maxWeight){
			return Math.max( values[i]+knapsack(weights, values, n, maxWeight-weights[i], i+1),
			knapsack(weights, values, n, maxWeight, i+1)
			);
		}
		else{
			return knapsack(weights, values, n, maxWeight, i+1);
		}
		
	}
	
// Memoizatation
	
	public static int knapsackRecursive(int W, int val[], int wt[], int n, int[][] dp) {
	    // Base case: If no items are left or the knapsack has no capacity, return 0
	    if (n == 0 || W == 0) {
	        return 0;
	    }
	    
	    // If the result for this subproblem is already computed, return it
	    if (dp[n][W] != -1) {
	        return dp[n][W];
	    }
	    
	    int ans;
	    
	    // If the current item's weight is less than or equal to the knapsack's capacity
	    if (wt[n - 1] <= W) {
	        // Either include the current item or exclude it
	        ans = Math.max(
	            val[n - 1] + knapsackRecursive(W - wt[n - 1], val, wt, n - 1, dp),
	            knapsackRecursive(W, val, wt, n - 1, dp)
	        );
	    } else {
	        // Skip the current item since its weight is greater than the knapsack's capacity
	        ans = knapsackRecursive(W, val, wt, n - 1, dp);
	    }
	    
	    // Store the result in the dp array
	    dp[n][W] = ans;
	    
	    return ans;
	}

	public static int knapsackTopDown(int W, int val[], int wt[]) {
	    int n = val.length;
	    int[][] dp = new int[n + 1][W + 1];
	    
	    // Initialize the dp array with -1
	    for (int i = 0; i <= n; i++) {
	        for (int j = 0; j <= W; j++) {
	            dp[i][j] = -1;
	        }
	    }
	    
	    return knapsackRecursive(W, val, wt, n, dp);
	}

	
// dp
	
	public static int knapsackDP(int W, int val[], int wt[]) {
		
		int n=val.length;
		int[][] dp= new int[n+1][W+1];
		
		for(int i=n-1; i>=0; i--) {
			for(int w=0; w<=W; w++) {
				
				int ans;
				
				if(wt[i]<=w) {
					ans=Math.max(val[i]+dp[i+1][w-wt[i]], dp[i+1][w]);
				}
				else {
					ans=dp[i+1][w];
				}
				
				dp[i][w]=ans;
			}
		}
		
		return dp[0][W];
	}

	public static void main(String[] args) {
		
		int values[]= {200,300,100};
		int weights[]= {20,25,30};
		int maxWeight=50;
		
		System.out.println(knapsack(weights, values, maxWeight, maxWeight));
		System.out.println(knapsackDP(maxWeight, values, weights));
		System.out.println(knapsackTopDown(maxWeight, values, weights));
	}

}
