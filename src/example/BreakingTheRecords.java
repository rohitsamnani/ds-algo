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

    class Result2 {

        /*
        * Complete the 'breakingRecords' function below.
        *
        * The function is expected to return an INTEGER_ARRAY.
        * The function accepts INTEGER_ARRAY scores as parameter.
        */

        public static List<Integer> breakingRecords(List<Integer> scores) {
            int highestScore=Integer.MIN_VALUE;
            int lowestScore =Integer.MAX_VALUE;
            int highestCounter=-1;
            int lowestCounter=-1;
            for(int i=0;i<scores.size();i++){
                if(highestScore<scores.get(i)){
                    highestScore=scores.get(i);
                    highestCounter++;
                }
                if(lowestScore>scores.get(i)){
                    lowestScore=scores.get(i);
                    lowestCounter++;
                }
                
            }
            List<Integer> list= new ArrayList<Integer>();
            list.add(highestCounter);
            list.add(lowestCounter);
            return list;
    }
   }

    public class BreakingTheRecords {
        public static void main(String[] args) throws IOException {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("OUTPUT_PATH"));

            int n = Integer.parseInt(bufferedReader.readLine().trim());

            List<Integer> scores = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

            List<Integer> result = Result2.breakingRecords(scores);

            bufferedWriter.write(
                result.stream()
                    .map(Object::toString)
                    .collect(joining(" "))
                + "\n"
            );

            bufferedReader.close();
            bufferedWriter.close();
        }
    }
