package _202503_week3;

import java.io.*;
import java.util.*;

/**
 * IMP : https://www.acmicpc.net/problem/14238
 * IMP : 2025.03.17 출근 기록
 * TYPE : 진짜 매우 화나는 문제 -> 깊은 Depth에 대한 DP를 다루어야 하는 문제
 * => HashMap으로 처리할 수 있을까?
 */

public class B14328_출근기록_오화랑_DP {
    static class Solution {
        int L;
        String S;
        int[] count;
        char[] workList;
        boolean[][][][][] visited;

        void run() throws IOException {
            BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
            S = input.readLine();
            L = S.length();

            count = new int[3];
            for (int i = 0; i < L; i++) {
                if (S.charAt(i) == 'A')
                    count[0]++;
                else if (S.charAt(i) == 'B')
                    count[1]++;
                else
                    count[2]++;
            }

            boolean canMake = true;
            if (count[1] > Math.ceil((L + 1) / 2))
                canMake = false;

            if (count[2] > Math.ceil((L + 2 / 3)))
                canMake = false;

            workList = new char[L];
            visited = new boolean[count[0] + 1][count[1] + 1][count[2] + 1][3][3];
            if (canMake)
                canMake = check(0, 0, 0, 'A', 'A');

            if (canMake) {
                System.out.println(String.valueOf(workList));
            } else
                System.out.println(-1);
        }

        boolean check(int a, int b, int c, char back1, char back2) {
            if (visited[a][b][c][back1 - 'A'][back2 - 'A'])
                return false;

            if (a == count[0] && b == count[1] && c == count[2])
                return true;

            visited[a][b][c][back1 - 'A'][back2 - 'A'] = true;

            if (count[0] >= a + 1) {
                workList[a + b + c] = 'A';
                if (check(a + 1, b, c, 'A', back1))
                    return true;
            }

            if (count[1] >= b + 1) {
                workList[a + b + c] = 'B';
                if (back1 != 'B')
                    if (check(a, b + 1, c, 'B', back1))
                        return true;
            }

            if (count[2] >= c + 1) {
                workList[a + b + c] = 'C';
                if (back1 != 'C' && back2 != 'C')
                    if (check(a, b, c + 1, 'C', back1))
                        return true;
            }
            return false;
        }
    }

    public static void main(String[] args) throws IOException {
        new Solution().run();
    }
}
