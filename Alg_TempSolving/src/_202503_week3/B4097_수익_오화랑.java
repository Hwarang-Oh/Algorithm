package _202503_week3;

/**
 * IMP : https://www.acmicpc.net/problem/4097
 * IMP : 2025.03.17 수익
 * * 각 Test Case의 첫 번째 줄에는, 해당 TC의 구간 길이가 주어진다.
 * * 모든 Test Case에 대해서, 가장 많은 수익을 올린 구간의 수익을 출력한다. ( 구간이 비어 있으면 안됨 )
 * TYPE : 1 <= N <= 250,000 까지의 구간이 주어질 수 있음
 * TYPE : -10,000 <= P <= 10,000 까지의 수익값이 주어짐
 * * => 이러한 이유로, 최대 수익값이 2,500,000,000 까지 발생하게 될 수 있음 ( -> LONG )
 * IMP : Kadane's Algorithm을 활용할 수 있다?!
 */

import java.io.*;

public class B4097_수익_오화랑 {

    static class Solution {

        int T;

        void run() throws IOException {
            BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
            StringBuilder sb = new StringBuilder();
            while (true) {
                T = Integer.parseInt(input.readLine());
                if (T == 0)
                    break;

                int eachInput;
                long currentMaxSum = -10001;
                long[] dp = new long[T];
                for (int i = 0; i < T; i++) {
                    if (i == 0) {
                        currentMaxSum = Integer.parseInt(input.readLine());
                        dp[i] = currentMaxSum;
                        continue;
                    }
                    eachInput = Integer.parseInt(input.readLine());
                    dp[i] = Math.max(eachInput, dp[i - 1] + eachInput);
                    currentMaxSum = Math.max(currentMaxSum, dp[i]);
                }
                sb.append(currentMaxSum).append("\n");
            }

            System.out.println(sb);
        }
    }

    public static void main(String[] args) throws IOException {
        new Solution().run();
    }
}