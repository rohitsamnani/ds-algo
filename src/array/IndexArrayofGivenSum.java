package array;

public class IndexArrayofGivenSum {
	
	 public int[] twoSum(int[] nums, int target) {
	      int temp[] =  new int[2];
		 for(int i =0; i<nums.length;i++) {
			 for(int j=i+1;j<nums.length;j++) {
				 if(nums[i]+nums[j]==target) {
					 temp[0]=i;
					 temp[1]=j;
					 return temp;
				 }
			 }
			}
		 return temp;
		 }
	 
	 public static void main(String[] args) {
		 int[] nums = {2,5,5,11}; 
		 int target = 10;
		 
		 int[] temp=new IndexArrayofGivenSum().twoSum(nums, target);
		 if(temp!=null)
		 System.out.println(temp[0] + "," +temp[1]);	 
	}
}
