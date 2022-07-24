package practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DeliveryTime {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String line = br.readLine();
		int[] arr = Arrays.stream(line.split("\\s+")).mapToInt(Integer::parseInt).toArray();
		int baseDeliveryCost = arr[0];
		int noOfPackges = arr[1];
		Map<Integer, PackageInfo> map = new HashMap<>();
		
		
		for (int i = 0; i < noOfPackges; i++) {
			String[] arr1 = br.readLine().split("\\s+");
			map.put(i, new PackageInfo(arr1[0], Integer.parseInt(arr1[1]), Integer.parseInt(arr1[2]), arr1[3]));
		}
		arr = Arrays.stream(line.split("\\s+")).mapToInt(Integer::parseInt).toArray();
		
		int no_of_vehicles = arr[0];
		int max_speed = arr[1];
		int max_carriable_weight = arr[2];
		long[] timeTakeByVehicle = new long[no_of_vehicles];
		List<Integer> sum = new ArrayList<>();
		//takeSubArrays(map, 0,0,sum,0);
		
		for(int s:sum) {
			if(s>max_carriable_weight) {
				
			}
		}
		
		while (!map.isEmpty()) {
			for (int i = 0; i < no_of_vehicles; i++) {
				int distance = delivery(map, max_carriable_weight);
				timeTakeByVehicle[i] = timeTaken(distance, max_speed);
			}
		}

	}

	private static long timeTaken(int distance, int max_speed) {
		return 0;
	}

	private static int delivery(Map<Integer, PackageInfo> map, int max_carriable_weight) {
		int maxWeight = Integer.MIN_VALUE;
		int weight=0;
		int sumWeight=0;
		if (map.size() > 1) {
			for (int i = map.size()-1; i >= 0; i--) {
				int diffWeight = max_carriable_weight-map.get(i).getPkg_weight1_in_kg();
				for (int j = 0; j < map.size()-1; j--) {
					sumWeight=+ map.get(j).getPkg_weight1_in_kg();
					while(sumWeight<diffWeight) {
						continue;
					}
				}
			}
		}
		map.clear();
		return map.get(0).distance1_in_km;
	}
	
	private static void takeSubArrays(Map<Integer,PackageInfo> map, int start, int end, int[][] sum, int counter)
    {
        // Stop if we have reached the end of the array
        if (end == map.size())
            return;
        // Increment the end point and start from 0
        else if (start > end)
        	takeSubArrays(map, 0, end + 1,sum, counter);
        // Print the subarray and increment the starting
        // point
        else {
        	int tmpCounter=0;
            for (int i = start; i <= end; i++) {
            	sum[counter][tmpCounter]=i;
            	tmpCounter++;
            }
            takeSubArrays(map, start + 1, end,sum,counter++);
        }
        return;
    }
}

class PackageInfo {
	String pkg_id1 = null;
	int pkg_weight1_in_kg = 0;
	int distance1_in_km = 0;
	String offer_code1 = null;

	public PackageInfo(String pkg_id1, int pkg_weight1_in_kg, int distance1_in_km, String offer_code1) {
		this.pkg_id1 = pkg_id1;
		this.pkg_weight1_in_kg = pkg_weight1_in_kg;
		this.distance1_in_km = distance1_in_km;
		this.offer_code1 = offer_code1;
	}

	public String getPkg_id1() {
		return pkg_id1;
	}

	public void setPkg_id1(String pkg_id1) {
		this.pkg_id1 = pkg_id1;
	}

	public int getPkg_weight1_in_kg() {
		return pkg_weight1_in_kg;
	}

	public void setPkg_weight1_in_kg(int pkg_weight1_in_kg) {
		this.pkg_weight1_in_kg = pkg_weight1_in_kg;
	}

	public int getDistance1_in_km() {
		return distance1_in_km;
	}

	public void setDistance1_in_km(int distance1_in_km) {
		this.distance1_in_km = distance1_in_km;
	}

	public String getOffer_code1() {
		return offer_code1;
	}

	public void setOffer_code1(String offer_code1) {
		this.offer_code1 = offer_code1;
	}
}