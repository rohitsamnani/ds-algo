package slidingwindow;

import java.util.HashMap;
import java.util.Map;

//maximum toys one can obtain from array, condition , only k types of toys permit
public class PickToys {
	// a : cycle , b : elephant , c: car, d : ball
	public static void main(String[] args) {
		char[] arr = { 'a', 'b', 'a', 'c', 'c', 'a', 'b', 'd' };
		int k = 2; // only 2 type of toys permits

		int max = pickMaxToys(arr, k);
		System.out.println(max);
	}

	private static int pickMaxToys(char[] arr, int k) {
	     if(arr.length==0 ){
	            return 0;
	        }
	        if(arr.length==1){
	            return 1;
	        }
		int maxToys =0; int i=0;int j=0;
		Map<Character, Integer> map =  new HashMap<>(); 
		
		while(j<arr.length) {
			char c = arr[j];
			if(map.containsKey(c)) {
				map.put(c, map.get(c)+1);
			}
			else {
				map.put(c, 1);
			}
			
			if(map.size()<k) {
				j++;
			}
			else if(map.size()==k){
				maxToys = Math.max(maxToys, j-i+1);
				j++;
			}
			else if(map.size()>k) {
				while(map.size()!=k) {
					c= arr[i];
					map.put(c,map.get(c)-1);
					if(map.get(c)==0) {
						map.remove(c);
					}
					i++;
				}
				if(map.size()==k) {							//never will the answer, but if count has been ask then this will come
					maxToys = Math.max(maxToys, j-i+1);
				}
				j++;
			}
		}
		  if(map.size()==1){
	            return arr.length;
	        }
		return maxToys;
	}

}
