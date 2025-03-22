package _202503_week3;

import java.io.*;
import java.util.*;

/**
 * IMP : https://www.acmicpc.net/problem/13302
 * IMP : 2025.03.20 리조트
 * ! 1 <= N <= 100, 0 <= M <= N
 * ! 리조트를 갈 수 없는 날에, 특정 이용권을 구매하는 것은 어떠한 경우에도 이득이 될 수 없음 ( 최고 상태가 이득이 없는 상태 )
 * ! 리조트 이용권이 남은 날에, 특정 이용권을 구매하는 것도 이득이 될 수 없음.
 */
public class B13302_리조트_오화랑_RE {

    static class Solution {
        int N, M; // * N : 여름방학 Days, M : 리조트를 갈 수 없는 날짜의 수
        int[][] DP;
        HashSet<Integer> noDays;

        void run() throws IOException {
            BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st = new StringTokenizer(input.readLine());

            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            noDays = new HashSet<>();

            if (M > 0) {
                st = new StringTokenizer(input.readLine());
                for (int i = 0; i < M; i++) {
                    noDays.add(Integer.parseInt(st.nextToken()));
                }
            }

            DP = new int[N + 1][N + 1];
            for (int i = 0; i <= N; i++)
                Arrays.fill(DP[i], -1);

            // int result = Integer.MAX_VALUE;
            // for (int i = 0; i <= 2 * N; i++) {
            // if (DP[N][i] == -1)
            // continue;
            // result = Math.min(result, DP[N][i]);
            // }
            System.out.println(solve(1, 0));
        }

        int solve(int day, int coupon) {
            if (day > N)
                return 0;

            if (DP[day][coupon] != -1)
                return DP[day][coupon];

            DP[day][coupon] = Integer.MAX_VALUE;
            if (noDays.contains(day))
                return DP[day][coupon] = Math.min(DP[day][coupon], solve(day + 1, coupon));

            else {
                if (coupon >= 3)
                    DP[day][coupon] = Math.min(DP[day][coupon], solve(day + 1, coupon - 3));
                DP[day][coupon] = Math.min(DP[day][coupon], solve(day + 1, coupon - 3) + 10000);
                DP[day][coupon] = Math.min(DP[day][coupon], solve(day + 3, coupon + 1) + 25000);
                DP[day][coupon] = Math.min(DP[day][coupon], solve(day + 5, coupon + 2)) + 37000;
            }
            return DP[day][coupon];

        }

    }

    public static void main(String[] args) throws IOException {
        new Solution().run();
    }
}

// ! 가지치기를 해도, 시간복잡도가 매우 높아진다 -> 4^100도 가능함
/**
 * void check(int dayCount, int oneDayCount, int threeDayCount, int
 * fiveDayCount, int couponCount, int leftDays) {
 * if (dayCount > N) {
 * int result = oneDayCount * 10000 + threeDayCount * 25000 + fiveDayCount *
 * 37000;
 * minResult = Math.min(minResult, result);
 * return;
 * }
 * 
 * if (noDays.contains(dayCount)) {
 * leftDays = leftDays - 1 < 0 ? 0 : leftDays - 1;
 * check(dayCount + 1, oneDayCount, threeDayCount, fiveDayCount, couponCount,
 * leftDays);
 * } else {
 * if (leftDays == 0) {
 * check(dayCount + 1, oneDayCount + 1, threeDayCount, fiveDayCount,
 * couponCount, leftDays);
 * check(dayCount + 1, oneDayCount, threeDayCount + 1, fiveDayCount, couponCount
 * + 1, leftDays + 2);
 * check(dayCount + 1, oneDayCount, threeDayCount, fiveDayCount + 1, couponCount
 * + 2, leftDays + 4);
 * if (couponCount >= 3)
 * check(dayCount + 1, oneDayCount, threeDayCount, fiveDayCount, couponCount -
 * 3, leftDays);
 * } else
 * check(dayCount + 1, oneDayCount, threeDayCount, fiveDayCount, couponCount,
 * leftDays - 1);
 * }
 * 
 * }
 */