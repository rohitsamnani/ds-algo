package example;
	
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result4 {

    /*
     * Complete the 'birthday' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER_ARRAY s
     *  2. INTEGER d
     *  3. INTEGER m
     */
//1 2 1 3 2
    public static int birthday(List<Integer> s, int d, int m) {
            int counter=0;
            int sum2=0;
            if(s.size()==m){
                for(int i=0;i<s.size();i++){
                 sum2=sum2+s.get(i);   
                }
                if(sum2==d)
                counter++;
            }
            else{
            for(int i=0;i<s.size()-m+1;i++){
                int j=i;
                int n=m;
                int sum=0;
                while(n!=0){
                    sum=sum+s.get(j);
                    ++j;
                    --n;
                }
                    if(sum==d)
                        counter++;
                }
            }
            return counter;
    }
}

public class BirthdayBar {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("OUTPUT_PATH"));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> s = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int d = Integer.parseInt(firstMultipleInput[0]);

        int m = Integer.parseInt(firstMultipleInput[1]);

        int result = Result4.birthday(s, d, m);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
