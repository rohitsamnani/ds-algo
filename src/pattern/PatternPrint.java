package pattern;

public class PatternPrint {
	
	public static void main(String[] args) {
	
		int n=5;
		for(int i=1;i<=n;i++) {
			for(int j=n+1-i;j>=1;j--) {
				System.out.print("*" );
			}
			System.out.println();
		}
		
	}

}
