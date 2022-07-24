package example;

public class Binary {
	
	public static void main(String[] args) {
	 int[] A = {1,2,5,9,9};
	 int X = 5;
		solution(A,X);	
	}
	
	static int solution(int[] A, int X) {
	    int N = A.length;
	    if (N == 0) {
	        return -1;
	    }
	    int l = 0;
	    int r = N;
	    while (l < r) {
	        int m = (l + r) / 2;
	        if (A[m] >= X) {
	            r = m - 1;
	        } else {
	            l = m+1;
	        }
	    }
	    if (A[r] == X) {
	        return r;
	    }
	    return -1;
	}

}
