package _202503_week3;

import java.io.*;
import java.util.*;

/**
 * IMP : https://www.acmicpc.net/problem/1806
 * IMP : 25.03.20
 * * 10,000 이하의 자연수로 이루어진 길이 N 짜리의 수열이 주어진다.
 * * 연속된 수들의 부분합 중에 그 합이 S 이상이 되는 것 중, 가장 짧은 것의 길이를 구하는 프로그램
 * TYPE : 1 <= N <= 100,000 ( 10만 ), 1 <= S <= 100,000,000 ( 1억 )
 * 5 2
 * 1 1 1 1 1
 */
public class B1806_부분합_오화랑 {

    static class Solution {
        int N, S;
        int[] numberList;

        void run() throws IOException {
            BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st = new StringTokenizer(input.readLine());
            N = Integer.parseInt(st.nextToken());
            S = Integer.parseInt(st.nextToken());
            numberList = new int[N];

            st = new StringTokenizer(input.readLine());
            for (int i = 0; i < N; i++)
                numberList[i] = Integer.parseInt(st.nextToken());

            int result = Integer.MAX_VALUE;
            int left, right, currentSum;
            left = right = currentSum = 0;
            while (N > right) {
                currentSum += numberList[right++];

                if (currentSum >= S) {
                    // System.out.println("left : " + left + " right : " + right + " currentSum : "
                    // + currentSum);
                    result = Math.min(result, right - left);

                    while (true) {
                        currentSum -= numberList[left++];
                        if (currentSum >= S) {
                            // System.out.println("left : " + left + " right : " + right + " currentSum : "
                            // + currentSum);
                            result = Math.min(result, right - left);
                        } else
                            break;
                    }
                }
            }
            if (result == Integer.MAX_VALUE)
                System.out.println(-1);
            else
                System.out.println(result);
        }
    }

    public static void main(String[] args) throws IOException {
        new Solution().run();
    }

}
