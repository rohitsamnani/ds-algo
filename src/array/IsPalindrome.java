package array;

public class IsPalindrome {
	
public static boolean isPalindrome(int x) {
    int temp=x;
    int remainder=0;
    int reversedNum=0;
	if(x>=0) {
		while(temp!=0) {
    	remainder=temp%10;
    	reversedNum = reversedNum*10+remainder;
    	temp=temp/10;
    }
	}else return false;
	if(reversedNum==x) return true;
	else return false;
    }

public static void main(String[] args) {
	System.out.println(isPalindrome(121));
}

}
