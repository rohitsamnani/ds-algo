package array;

public class TranposeSqaureMatrix {
	
	public static void main(String[] args) {
		int num=1121;
		int count=0;
		while(num>0) {
			num=num/10;
			count++;
		}
		
		System.out.println(count);
		
		int num1=12211;
		String num2=num1+"";
		System.out.println(num2.length());
		
		
		int[][] arr= {{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,64,15,16}};
		print(arr);
		System.out.println("------------------------------------");
		int arr1[][]=transposeSquareMatrix(arr);
		print(arr1);
		System.out.println("------------------------------------");
		System.out.println(maxIn2DArray(arr1));	
	}
	
	static void print(int[][] arr) {
		for(int i=0;i<arr.length;i++) {
			for(int j=0;j<arr.length;j++) {
				System.out.print(arr[i][j]+",");
			}
			System.out.println();
		}
	}
	
	private static int[][] transposeSquareMatrix(int[][] arr){
		int length=arr.length;
		for(int r=0;r<length;r++) {
			for(int c=r+1;c<length;c++) {
				int temp=arr[r][c];
				arr[r][c]=arr[c][r];
				arr[c][r]=temp;
			}
		}
		return arr;
	}
	
	private static int maxIn2DArray(int[][] arr) {
		int maxNumber=Integer.MIN_VALUE;
		for(int[] eleArray: arr) {
			for(int element:eleArray) {
				if(maxNumber<element) {
					maxNumber=element;
				}
			}
		}
		return maxNumber;
	}

}
