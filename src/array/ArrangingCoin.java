package array;

public class ArrangingCoin {
	
	public static void main(String[] args) {
		
		System.out.println(arrangeCoins(14));
	}
	
	public static int arrangeCoins(int n) {
    
		long start=1;
		long end=n;
		
		while(start<end) {
			long mid = start+(end-start+1)/2;
			if(mid/2*(mid+1)<=n) {
				start=mid;
			}
			else {
				end=mid-1;
			}
		}
		return (int)end;
    }

}
