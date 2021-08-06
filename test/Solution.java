package test;

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


/**
 * @Description [2021-04-13] 카카오 코딩테스트 1번 문제
 *              포인트를 빌려주고 빌린 사람의 목록이 배열로 주어지고, 현재 가장 포인트가 적은 인원을 출력하라
 *              배열 = {'빌린사람', '빌려준사람', '빌린Point'}
 *              <예외처리> 
 *                1) 포인트가 가장 적은 인원이 여러명일 경우 오름차순으로 출력
 *                2) 가장 적은 포인트가 마이너스가 아닐 경우 None 출력
 *              <해결방안>
 *                - 주어진 배열을 이용하여 User 별로 Point의 +/- 를 계산하여 userMap에 저장한다.
 *                - userMap은 TreeMap으로 선언한 것은 sort에 대한 고민을 하다가 수정을 놓친 실수. 원래는 HashMap을 사용했었다.
 *                  (TreeMap의 경우 get 시간복잡도는 O(logn)이지만, HashMap은 Hash값으로 바로 데이터에 접근이 가능하기 때문에 get 시간복잡도는 O(1)이다.)
 *                - 생성된 userMap으로 부터 가장 작은 값을 구하고 그 값에 해당하는 Entry(즉, userName)을 출력한다.
 */
class Result {

    /*
     * Complete the 'solution' function below.
     *
     * The function is expected to return a STRING_ARRAY.
     * The function accepts 2D_STRING_ARRAY arr as parameter.
     */

    public static List<String> solution(List<List<String>> arr) {
    // Write your code here
        Map<String, Integer> userMap = new HashMap<>();

        for(int i = 0; i < arr.size(); i++) {
            String userA = arr.get(i).get(0);
            String userB = arr.get(i).get(1);
            Integer point = Integer.parseInt(arr.get(i).get(2));

            if(userMap.get(userA) ==  null) {
                userMap.put(userA, 0-point);
            }else{
                userMap.put(userA, userMap.get(userA) - point);
            }

            if(userMap.get(userB) ==  null) {
                userMap.put(userB, point);
            }else {
                userMap.put(userB, userMap.get(userB) + point);
            }
            
        }

        System.out.println("User Map : " + userMap.toString());

        int min = 2147483647;
        List<String> output = new ArrayList<String>();

        for(String key : userMap.keySet()) {
            if(userMap.get(key) < min) {
                min = userMap.get(key);
                output.clear();
                output.add(key);
            } else if(userMap.get(key) == min) {
                output.add(key);
            }
        }

        Arrays.sort(output.toArray());
        if(min >=0) {
            output.clear();
            output.add("None");
        }

        System.out.println(output.toString());

        return output;
    }


}

public class Solution {
    public static void main(String[] args) throws IOException {
        // BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        // BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        // int arrRows = Integer.parseInt(bufferedReader.readLine().trim());
        // int arrColumns = Integer.parseInt(bufferedReader.readLine().trim());

        // List<List<String>> arr = new ArrayList<>();

        // IntStream.range(0, arrRows).forEach(i -> {
        //     try {
        //         arr.add(
        //             Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
        //                 .collect(toList())
        //         );
        //     } catch (IOException ex) {
        //         throw new RuntimeException(ex);
        //     }
        // });

        List<String> subListA= new ArrayList<>();
        List<List<String>> listA = new ArrayList<>();

        subListA.add("Apeach");
        subListA.add("Frodo");
        subListA.add("5");
        listA.add(subListA);
        subListA= new ArrayList<>();

        subListA.add("Frodo");
        subListA.add("Apeach");
        subListA.add("3");
        listA.add(subListA);
        subListA= new ArrayList<>();

        subListA.add("Tube");
        subListA.add("Apeach");
        subListA.add("7");
        listA.add(subListA);
        subListA= new ArrayList<>();

        subListA.add("Tube");
        subListA.add("Apeach");
        subListA.add("4");
        listA.add(subListA);
        subListA= new ArrayList<>();

        subListA.add("Tube");
        subListA.add("Apeach");
        subListA.add("2");
        listA.add(subListA);
        subListA= new ArrayList<>();

        subListA.add("Aaa");
        subListA.add("Apeach");
        subListA.add("13");
        listA.add(subListA);

        // System.out.println(listA.toString());


        List<String> result = Result.solution(listA);

        System.out.println(listA.toString());

        // bufferedWriter.write(
        //     result.stream()
        //         .collect(joining("\n"))
        //     + "\n"
        // );

        // bufferedReader.close();
        // bufferedWriter.close();
    }
}
