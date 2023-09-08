package practice;

public class BalancedBTs {
	
	public static int countBalancedBTs(int h) {
		
		int mod= (int)Math.pow(10,9)+7;
		
		return countBalancedBTs(h, mod);
	}
	
	public static int countBalancedBTs(int h, int mod) {
		
		if(h==0|| h==1) {
			return 1;
		}
		
		int x= countBalancedBTs(h-1);
		int y= countBalancedBTs(h-2);
		
		long res1=(long)x*x;
		long res2=(long)2*x*y;
		int value1=(int)(res1%mod);
		int value2=(int)(res2%mod);
		
		return (value1+value2)%mod;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int h=7;
		int ans=countBalancedBTs(h);
		System.out.println(ans);

	}

}
