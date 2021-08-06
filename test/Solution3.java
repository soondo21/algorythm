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
 * @Description [2021-04-13] 카카오 코딩테스트 2번 문제
 *              아이템의 목록을 관리하는 페이지를 출력하는 문제. 아이템의 목록은 {이름, 관련도, 가격}의 배열로 주어지고, 쿼리의 조건문에 따라 정렬이 바뀐다.
 *              <쿼리 조건>
 *                - orderBy : 0이면 이름, 1이면 관련도, 2이면 가격 순으로 정렬
 *                - orderDirection : 0이면 오름차순, 1이면 내림차순
 *                - pageSize : 각 page 사이즈
 *                - pageNumber : 출력할 page의 번호
 *              <해결방안>
 *                - oderBy와 oderDerection의 값을 보고 데이터를 정렬한다.(여기서는 Arrays로 변환하여 sort하였으나, Collections의 sort가 사용가능하다.)
 *                - 정렬된 데이터를 대상으로 페이징 처리하여 출력한다.
 */

class Result3 {

    /*
     * Complete the 'solution' function below.
     *
     * The function is expected to return a STRING_ARRAY.
     * The function accepts following parameters:
     *  1. 2D_STRING_ARRAY items
     *  2. INTEGER orderBy
     *  3. INTEGER orderDirection
     *  4. INTEGER pageSize
     *  5. INTEGER pageNumber
     */

    public static List<String> solution(List<List<String>> items, int orderBy, int orderDirection, int pageSize, int pageNumber) {
    // Write your code here
        List<String> output = new ArrayList<>();

        System.out.println(items.toString());

        String[][] itemArr = new String[items.size()][3];
        for(int i = 0; i < items.size(); i++) {
            String[] tempArray = items.get(i).toArray(new String[items.size()]);
            itemArr[i] = tempArray;
        }

        System.out.println("정렬 전");
        for(int i = 0; i < itemArr.length; i++) {
            for(int j = 0; j < 3; j++) {
                System.out.print(itemArr[i][j].toString() + " ");
            }
            System.out.println();
        }

    

        if(orderBy == 0) {  // 이름 순
            if(orderDirection == 0) {
                // 오름차순 정렬
                // Arrays.sort(itemArr, new Comparator<String[]>() {
                //     @Override
                //     public int compare(String[] o1, String[] o2) {
                //         return o1[0].compareTo(o2[0]);
                //     }
                // });
                Collections.sort(items, new Comparator<List<String>>() {
                    @Override
                    public int compare(List<String> o1, List<String> o2) {
                        return o1.get(0).compareTo(o2.get(0));
                    }
                });

            } else if(orderDirection == 1) {
                // 내림차순 정렬
                Arrays.sort(itemArr, new Comparator<String[]>() {
                    @Override
                    public int compare(String[] o1, String[] o2) {
                        return o2[0].compareTo(o1[0]);
                    }
                });
            }
        } else if(orderBy == 1) {  // 관련도 순
            if(orderDirection == 0) {  
                // 오름차순 정렬
                Arrays.sort(itemArr, new Comparator<String[]>() {
                    @Override
                    public int compare(String[] o1, String[] o2) {
                        return Integer.parseInt(o1[1]) - Integer.parseInt(o2[1]);
                        // return o1[1].compareTo(o2[1]);
                    }
                });

            } else if(orderDirection == 1) {
                // 내림차순 정렬
                Arrays.sort(itemArr, new Comparator<String[]>() {
                    @Override
                    public int compare(String[] o1, String[] o2) {
                        return Integer.parseInt(o2[1]) - Integer.parseInt(o1[1]);
                        // return o2[1].compareTo(o1[1]);
                    }
                });
            }
        } else if(orderBy == 2) {  // 가격 순
            if(orderDirection == 0) {  
                // 오름차순 정렬
                Arrays.sort(itemArr, new Comparator<String[]>() {
                    @Override
                    public int compare(String[] o1, String[] o2) {
                        return Integer.parseInt(o1[2]) - Integer.parseInt(o2[2]);
                        // return o1[2].compareTo(o2[2]);
                    }
                });

            } else if(orderDirection == 1) {
                // 내림차순 정렬
                Arrays.sort(itemArr, new Comparator<String[]>() {
                    @Override
                    public int compare(String[] o1, String[] o2) {
                        return Integer.parseInt(o2[2]) - Integer.parseInt(o1[2]);
                        // return o2[2].compareTo(o1[2]);
                    }
                });
            }

        }

        // // 예시
        // Arrays.sort(itemArr, new Comparator<String[]>() {
        //     // Compare With End_time
        //     @Override
        //     public int compare(String[] o1, String[] o2) {
        //         return o2[2].compareTo(o1[2]);
        //     }
        // });

        System.out.println("정렬 후");
        // for(int i = 0; i < itemArr.length; i++) {
        //     for(int j = 0; j < 3; j++) {
        //         System.out.print(itemArr[i][j].toString() + " ");
        //     }
        //     System.out.println();
        // }
        for(int i = 0; i < items.size(); i++) {
            for(int j = 0; j < 3; j++) {
                System.out.print(items.get(i).get(j) + " ");
            }
            System.out.println();
        }

        for(int i = (pageNumber*pageSize) + 1; i <= (pageNumber + 1) * pageSize; i++){
            if(i == itemArr.length +1) break;
            output.add(itemArr[i-1][0]);
        }
        System.out.println(output.toString());
        return new ArrayList<String>();
    }

}

public class Solution3 {
    public static void main(String[] args) throws IOException {
        // BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        // BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        // int itemsRows = Integer.parseInt(bufferedReader.readLine().trim());
        // int itemsColumns = Integer.parseInt(bufferedReader.readLine().trim());

        // List<List<String>> items = new ArrayList<>();

        // IntStream.range(0, itemsRows).forEach(i -> {
        //     try {
        //         items.add(
        //             Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
        //                 .collect(toList())
        //         );
        //     } catch (IOException ex) {
        //         throw new RuntimeException(ex);
        //     }
        // });

        

        // 예제
        List<String> subListA= new ArrayList<>();
        List<List<String>> items = new ArrayList<>();

        subListA.add("p3");
        subListA.add("1");
        subListA.add("2");
        items.add(subListA);
        subListA= new ArrayList<>();

        subListA.add("p1");
        subListA.add("1");
        subListA.add("3");
        items.add(subListA);
        subListA= new ArrayList<>();

        subListA.add("p2");
        subListA.add("1");
        subListA.add("3");
        items.add(subListA);
        subListA= new ArrayList<>();

        subListA.add("p4");
        subListA.add("1");
        subListA.add("3");
        items.add(subListA);
        subListA= new ArrayList<>();

        subListA.add("p6");
        subListA.add("1");
        subListA.add("3");
        items.add(subListA);
        subListA= new ArrayList<>();

        subListA.add("p5");
        subListA.add("1");
        subListA.add("3");
        items.add(subListA);
        subListA= new ArrayList<>();

        subListA.add("p7");
        subListA.add("2");
        subListA.add("1");
        items.add(subListA);

        int orderBy = 0; //Integer.parseInt(bufferedReader.readLine().trim());

        int orderDirection = 0; //Integer.parseInt(bufferedReader.readLine().trim());

        int pageSize = 2; //Integer.parseInt(bufferedReader.readLine().trim());

        int pageNumber = 3; //Integer.parseInt(bufferedReader.readLine().trim());



        List<String> result = Result3.solution(items, orderBy, orderDirection, pageSize, pageNumber);

        // bufferedWriter.write(
        //     result.stream()
        //         .collect(joining("\n"))
        //     + "\n"
        // );

        // bufferedReader.close();
        // bufferedWriter.close();
    }
}
