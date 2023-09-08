package practice;

public class Fibonnaci {
	
	public static int fibonnaci(int n) {
		
		if(n==0 || n==1) {
			return n;
		}
		
		return fibonnaci(n-1)+fibonnaci(n-2);
	}
	
	public static int fibM(int n) {
		
		int storage[]= new int[n+1];
		for(int i=0; i<n+1; i++) {
			storage[i]=-1;
		}
		
		return fibM(n,storage);
	}
	
	public static int fibM(int n, int[] storage) {
		
		if(n==0||n==1) {
			storage[n]=n;
			return storage[n];
		}
		
		if(storage[n]!=-1) {
			return storage[n];
		}
		else {
			
			storage[n]=fibM(n-1, storage)+fibM(n-2, storage);
			return storage[n];
		}
	}
	
	public static int fibDP(int n) {
		
		int storage[]=new int[n+1];
		storage[0]=0;
		storage[1]=1;
		
		for(int i=2; i<=n; i++) {
			storage[i]=storage[i-1]+storage[i-2];
		}
		
		return storage[n];
	}

	public static void main(String[] args) {
		
		int n=4;
		System.out.println(fibonnaci(n));
		System.out.println(fibM(n));
		System.out.println(fibDP(n));
	}

}
