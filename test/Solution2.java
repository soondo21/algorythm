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
 * @Description [2021-04-13] 카카오 코딩테스트 3번 문제
 *              희의실 시간표 구성하는 문제로 시작시간의 배열과 회의시간의 배열이 주어진다. 주어진 배열을 이용하여 최대한 많은 회의시간을 구성하는 문제
 *              <해결방안>
 *                - 그리디 알고리즘으로 해결하는 문제이다.
 *                - 각 회의시간이 곂치지 않는다면 종료시간이 빠른 회의를 나열하는 것이 최선이다.
 *                - 주어진 배열을 가지고 시작시간과 종료시간으로 구성된 2차원 배열로 만들고 종료시간 순으로 나열한다. 그리고 곂치지 않는 회의 시간표를 구성한다.
 * 
 * @Reference https://st-lab.tistory.com/145
 */
class Result2 {

    /*
     * Complete the 'solution' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER_ARRAY start_time
     *  2. INTEGER_ARRAY running_time
     */

    public static int solution(List<Integer> start_time, List<Integer> running_time) {
        // Write your code here

        int N = start_time.size();
        int[][] time = new int[N][2];
		
		for(int i = 0; i < N; i++) {
			time[i][0] = start_time.get(i);	// Start Time
			time[i][1] = start_time.get(i) + running_time.get(i);	// End Time
		}
		
		
		// sorting
		Arrays.sort(time, new Comparator<int[]>() {
            // Compare With End_time
			@Override
			public int compare(int[] o1, int[] o2) {
				if(o1[1] == o2[1]) {
					return o1[0] - o2[0];
				}

				return o1[1] - o2[1];
			}
 
		});
		
		int count = 0;
		int prev_end_time = 0;
		
		for(int i = 0; i < N; i++) {
			
			// 직전 종료시간이 다음 회의 시작 시간보다 작거나 같다면 갱신 
			if(prev_end_time <= time[i][0]) {
				prev_end_time = time[i][1];
				count++;
			}
		}
		
		System.out.println(count);

        return count;

    }

}

public class Solution2 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int start_timeCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> start_time = IntStream.range(0, start_timeCount).mapToObj(i -> {
            try {
                return bufferedReader.readLine().replaceAll("\\s+$", "");
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        })
            .map(String::trim)
            .map(Integer::parseInt)
            .collect(toList());

        int running_timeCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> running_time = IntStream.range(0, running_timeCount).mapToObj(i -> {
            try {
                return bufferedReader.readLine().replaceAll("\\s+$", "");
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        })
            .map(String::trim)
            .map(Integer::parseInt)
            .collect(toList());

        int result = Result2.solution(start_time, running_time);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
