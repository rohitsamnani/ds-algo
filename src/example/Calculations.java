package example;

//Tn=Tn-1+Tn-2+Tn-3 at n>3 & T1=3,T2=2,T3=1

public class Calculations {
	public static void main(String[] args) {
		int temp1 = 3;
		int temp2 = 2;
		int temp3 = 1;
		

		int sum=0;
		long square= (long)temp1*temp1+(long)temp2*temp2+(long)temp3*temp3;
		for (int i = 4; i <= 8; i++) {
			sum=temp3+temp2+temp1;
			temp1 = temp2;
			temp2 = temp3;
			temp3 =sum;
			square=square + (long)Math.pow(sum, 2);
		}
	System.out.println(square);
	}

}	
