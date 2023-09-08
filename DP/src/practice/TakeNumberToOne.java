package practice;

public class TakeNumberToOne {

	// Normal function: To many redundant calls.  Time complexity: O(3^n) ( HORRIBLE )
	
	static int countSteps(int n) {
		
		if(n==1) {
			return 0;
		}
		
		int op1= countSteps(n-1);
		int minSteps= op1;
		
		if(n%3==0) {
			int op2=countSteps(n/3);
			if(op2<minSteps) {
				minSteps=op2;
			}
		}
		if(n%2==0) {
			int op3=countSteps(n/2);
			if(op3<minSteps) {
				minSteps=op3;
			}
		}
		
		return 1+minSteps;
	}
	
	// Memoization technique : O(n)
	
	static int countStepsM(int n) {
		
		int storage[]= new int[n+1];
		
		return countStepsM(n, storage);
	}

	private static int countStepsM(int n, int[] storage) {
		
		if(n==1) {
			storage[n]=0;
			return storage[n];
		}
		
		if(storage[n]!=0) {
			return storage[n];
		}
		
		int op1= countSteps(n-1);
		int minSteps= op1;
		
		if(n%3==0) {
			int op2=countSteps(n/3);
			if(op2<minSteps) {
				minSteps=op2;
			}
		}
		if(n%2==0) {
			int op3=countSteps(n/2);
			if(op3<minSteps) {
				minSteps=op3;
			}
		}
		
		storage[n]=1+minSteps;
		return storage[n];
		
	}
	
	// DP : O(n)
	
	static int countStepsDp(int n) {
		
		int storage[]= new int[n+1];
		storage[1]=0;
		
		for(int i=2; i<=n;i++) {
			
			int min=storage[i-1];
			
			if(i%3==0) {
				
				if(storage[i/3]<min) {
					min=storage[i/3];
				}
			}
			if(i%2==0) {
				
				if(storage[i/2]<min) {
					min=storage[i/2];
				}
			}
			
			storage[i]=1+min;
		}
		
		return storage[n];
	}

	public static void main(String[] args) {
		
		int n=99;
		System.out.println(countSteps(n));
		System.out.println(countStepsM(n));
		System.out.println(countStepsDp(n));
	}

}
