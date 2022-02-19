package practice;

public class ZeroOddEven extends Thread{
	int num;
	public ZeroOddEven(int num) {
		this.num=num;
	}

	public void odd(ZeroOddEven o) {
		for(int i=1 ; i<=num;i++) {
			if(num%2==1) {
		
			zero(o);
		System.out.print(i);
		
		}
		}
	}
	public void even(ZeroOddEven o) {
		for(int i=1 ; i<=num;i++) {
			if(num%2==0) {
		
			zero(o);
		System.out.print(i);
		}
		
		}
	}
	public void zero(ZeroOddEven o) {
		
		System.out.print(0);
		
}

}
