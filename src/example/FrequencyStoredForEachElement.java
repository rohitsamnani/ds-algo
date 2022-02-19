package example;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class FrequencyStoredForEachElement {
	
	public static void main(String[] args) {
		int [] arr = {1,2,5,3,6,7,8,43,3,7,8,8,3,4,5,6,4,5,4,4};
		int frequency []= takeoutFrequency(arr);
		System.out.println("printing now");
		int max=0;
		for(int i=0;i<frequency.length-1;i++) {
			System.out.print(frequency[i]+" ");
			if(frequency[i]+frequency[i+1]>max)
				max=frequency[i]+frequency[i+1];
		}
		System.out.println();
		System.out.println("maximum consucuite substring is : "+max);
		
		takeoutFrequencyWithHashMap(arr);
		
	}

	private static int[] takeoutFrequency(int[] arr) {
		int frequency []= new int[50];
		
		for(int i=0;i<arr.length;i++) {
			frequency[arr[i]]++;
		}
		
		return frequency;	
	}
	
	private static void takeoutFrequencyWithHashMap(int[]arr) {
		
		Map<Integer,Integer> map= new HashMap<>();
		for(int i=0;i<arr.length;i++) {
			if(map.get(arr[i])==null) {
				map.put(arr[i], 1);
			}
			else {
				map.put(arr[i], (map.get(arr[i]))+1);
			}
		}
		for(Map.Entry<Integer, Integer> entry: map.entrySet()) {
			System.out.print(entry.getValue()+" ");
		}
		
		
	}

}
