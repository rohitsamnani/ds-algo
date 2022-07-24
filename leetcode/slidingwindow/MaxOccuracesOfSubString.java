package slidingwindow;

import java.util.HashMap;
import java.util.Map;

public class MaxOccuracesOfSubString {
	
	public static void main(String[] args) {
		String s = "aaaa"; int maxLetters = 1; int minSize = 3; int maxSize = 3;
		System.out.println(maxFreq(s,maxLetters,minSize,maxSize));
	}
	
	
	public static int maxFreq(String s, int maxLetters, int minSize, int maxSize) {
        int i=0;int j=0;
		int max=0;
        Map<String, Integer> map = new HashMap<>();
        Map<Character,Integer> map1 = new HashMap<>();
        
        while(j<s.length()) {
			char c= s.charAt(j);
			if(map1.containsKey(c)){
                map1.put(c,map1.get(c)+1);
            }
            else{
                map1.put(c,1);
            }
            if(map1.size()<maxLetters) {
				j++;
			}
			else if(map1.size()>maxLetters) {
                char c1 = s.charAt(i);
				while (map1.size()>maxLetters) {
                    map1.put(s.charAt(i),map1.get(s.charAt(i))-1);
                    if(map1.get(c1)==0){
                    map1.remove(c1);
                    }
					i++;
				}
				if(map1.size()==maxLetters) {
					String temp =s.substring(i,j+1);
                    if(map.containsKey(temp)){
                        map.put(temp, map.get(temp)+1);
                    }
                    else{
                        map.put(temp,1);
                    }
			}
				j++;
			}
			else if(map1.size()==maxLetters) {
                String temp =s.substring(i,j+1);
                    if(map.containsKey(temp)){
                        map.put(temp, map.get(temp)+1);
                    }
                    else{
                        map.put(temp,1);
                    }
					j++;
			}
		}
		 for (Map.Entry mapElement : map.entrySet()) {
			 
             String s11 = (String) mapElement.getKey();
             if(s11.length()>=minSize && s11.length()<=maxSize) {
            	Integer value = (Integer)mapElement.getValue();
                max = Math.max(max,value);
             }
    }
        return max;
}

}
