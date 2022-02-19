package example;

	import static java.util.stream.Collectors.toList;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

	class Result001 {
	    /*
	     * Complete the 'queensAttack' function below.
	     *
	     * The function is expected to return an INTEGER.
	     * The function accepts following parameters:
	     *  1. INTEGER n
	     *  2. INTEGER k
	     *  3. INTEGER r_q
	     *  4. INTEGER c_q
	     *  5. 2D_INTEGER_ARRAY obstacles
	     */

	    public static int queensAttack(int n, int k, int r_q, int c_q, List<List<Integer>> obstacles) {
	        int count=0;
	        boolean flag=false;
	        int rQueen=r_q-1; 
	        int cQueen=c_q-1;
	        while(rQueen>0) {
	        	rQueen--;
	        	int tmpIndex=Integer.MIN_VALUE;
	        	for(List<Integer> ob: obstacles) {
	        		if(rQueen==ob.get(0)-1 && cQueen==ob.get(1)-1) {
	        			flag=true;
	        			tmpIndex=obstacles.indexOf(ob);
	        			break;
	        		}
	        	}
	        	
	        	if(flag==false) {
	        	count++;
	        	}
	        	else {
	        		obstacles.remove(tmpIndex);
	        		flag=false;
	        		break;
	        	}
	        }
	        rQueen=r_q-1; 
	        while(rQueen<n-1) {
	        	rQueen++;
	        	int tmpIndex=Integer.MIN_VALUE;
	        	for(List<Integer> ob: obstacles) {
	        		if(rQueen==ob.get(0)-1 && cQueen==ob.get(1)-1) {
	        			flag=true;
	        			tmpIndex=obstacles.indexOf(ob);
	        			break;
	        		}
	        	}
	        	if(flag==false) {
	        	count++;
	        	}
	        	else {
	        		obstacles.remove(tmpIndex);
	        		flag=false;
	        		break;
	        	}
	        }
	        rQueen=r_q-1;
	        while(cQueen<n-1) {
	        	cQueen++;
	        	int tmpIndex=Integer.MIN_VALUE;
	        	for(List<Integer> ob: obstacles) {
	        		if(rQueen==ob.get(0)-1 && cQueen==ob.get(1)-1) {
	        			flag=true;
	        			tmpIndex=obstacles.indexOf(ob);
	        			break;
	        		}
	        	}
	        	if(flag==false) {
	        	count++;
	        	}
	        	else {
	        		obstacles.remove(tmpIndex);
	        		flag=false;
	        		break;
	        	}
	        }
	        cQueen=c_q-1;
	        while(cQueen>0) {
	        	cQueen--;
	        	int tmpIndex=Integer.MIN_VALUE;
	        	for(List<Integer> ob: obstacles) {
	        		if(rQueen==ob.get(0)-1 && cQueen==ob.get(1)-1) {
	        			flag=true;
	        			tmpIndex=obstacles.indexOf(ob);
	        			break;
	        		}
	        	}
	        	if(flag==false) {
	        	count++;
	        	}
	        	else {
	        		obstacles.remove(tmpIndex);
	        		flag=false;
	        		break;
	        	}
	        		
	        }
	        cQueen=c_q-1;
	        
	        while(rQueen>0 && cQueen>0) {
	        	rQueen--;
	        	cQueen--;
	        	int tmpIndex=Integer.MIN_VALUE;
	        	for(List<Integer> ob: obstacles) {
	        		if(rQueen==ob.get(0)-1 && cQueen==ob.get(1)-1) {
	        			flag=true;
	        			tmpIndex=obstacles.indexOf(ob);
	        			break;
	        		}
	        	}
	        	if(flag==false) {
	        	count++;
	        	}
	        	else {
	        		obstacles.remove(tmpIndex);
	        		flag=false;
	        		break;
	        	}
	        }
	        rQueen=r_q-1;
	        cQueen=c_q-1;
	        while(rQueen<n-1 && cQueen<n-1) {
	        	rQueen++;
	        	cQueen++;
	        	int tmpIndex=Integer.MIN_VALUE;
	        	for(List<Integer> ob: obstacles) {
	        		if(rQueen==ob.get(0)-1 && cQueen==ob.get(1)-1) {
	        			flag=true;
	        			tmpIndex=obstacles.indexOf(ob);
	        			break;
	        		}
	        	}
	        	if(flag==false) {
	        	count++;
	        	}
	        	else {
	        		obstacles.remove(tmpIndex);
	        		flag=false;
	        		break;
	        	}
	        }
	        rQueen=r_q-1;
	        cQueen=c_q-1;
	        while(rQueen>0 && cQueen<n-1) {
	        	rQueen--;
	        	cQueen++;
	        	int tmpIndex=Integer.MIN_VALUE;
	        	for(List<Integer> ob: obstacles) {
	        		if(rQueen==ob.get(0)-1 && cQueen==ob.get(1)-1) {
	        			flag=true;
	        			tmpIndex=obstacles.indexOf(ob);
	        			break;
	        		}
	        	}
	        	if(flag==false) {
	        	count++;
	        	}
	        	else {
	        		obstacles.remove(tmpIndex);
	        		flag=false;
	        		break;
	        	}
	        }
	        rQueen=r_q-1;
	        cQueen=c_q-1;
	        while(rQueen<n-1 && cQueen>0) {
	        	rQueen++;
	        	cQueen--;
	        	int tmpIndex=Integer.MIN_VALUE;
	        	for(List<Integer> ob: obstacles) {
	        		if(rQueen==ob.get(0)-1 && cQueen==ob.get(1)-1) {
	        			flag=true;
	        			tmpIndex=obstacles.indexOf(ob);
	        			break;
	        		}
	        	}
	        	if(flag==false) {
	        	count++;
	        	}
	        	else {
	        		obstacles.remove(tmpIndex);
	        		flag=false;
	        		break;
	        	}
	        }
	        rQueen=r_q-1;
	        cQueen=c_q-1;
	        
	        return count;
	    }
	}

	public class Solution11 {
	    public static void main(String[] args) throws IOException {
	        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
	        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("OUTPUT_PATH"));

	        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

	        int n = Integer.parseInt(firstMultipleInput[0]);

	        int k = Integer.parseInt(firstMultipleInput[1]);

	        String[] secondMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

	        int r_q = Integer.parseInt(secondMultipleInput[0]);

	        int c_q = Integer.parseInt(secondMultipleInput[1]);

	        List<List<Integer>> obstacles = new ArrayList<>();

	        IntStream.range(0, k).forEach(i -> {
	            try {
	                obstacles.add(
	                    Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
	                        .map(Integer::parseInt)
	                        .collect(toList())
	                );
	            } catch (IOException ex) {
	                throw new RuntimeException(ex);
	            }
	        });

	        int result = Result001.queensAttack(n, k, r_q, c_q, obstacles);

	        bufferedWriter.write(String.valueOf(result));
	        bufferedWriter.newLine();

	        bufferedReader.close();
	        bufferedWriter.close();
	    }
}
