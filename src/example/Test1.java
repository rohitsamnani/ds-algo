package example;

public class Test1 implements Test{
	
	public static void main(String[] args) {
		Test1 test21= new Test1();
		test21.test();
	}

	@Override
	public void test() {
		System.out.println("testing");
		
	}

}
