package _202502_week1;

import java.io.*;
import java.util.*;

/**
 * IMP : 20만 길이의 문자열 -> 기본적으로 차지하는 Memory 양이 많다.
 * * Solve => Dynamic Programming? => 개선할 점이 많다. ( 너무 빡구현 느낌 )
 * * -> + - - - - + - + -
 * 0+ ,10
 * 10 -, 11
 * 11 -, (10 - 1)
 * 9 -, (11 - 1)
 * 10 - , (9- 1)
 * 8 +, (10 - 10)
 * 0 -, (8 + 1), (-1)
 * 9 +, (0 - 10)
 * -10 -, (9 + 1), (0 -10 - 1)
 * => 10, -11
 * * -> - - + - + -
 * 0 , 0 , true
 * - : 0 , 1 , true
 * - : 1 , 0 , false
 * + : 0, -9, true
 * - : -9, -10, false
 * + : -10, -19, true
 * - : -18, -9, false
 * 
 */

public class B23325_마법천자문_오화랑2 {
    static class State {
        int optState, numState;
        boolean isPlus, isOpt, isNum;

        public State(int optState, int numState, boolean isPlus, boolean isOpt, boolean isNum) {
            this.optState = optState;
            this.numState = numState;
            this.isPlus = isPlus;
            this.isOpt = isOpt;
            this.isNum = isNum;
        }
    }

    static class Solution {
        String text;
        State[] DP;

        void run() throws IOException {
            BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
            text = input.readLine();
            int textL = text.length();
            DP = new State[textL + 1];
            DP[0] = new State(0, 0, true, false, false);

            char eachText;
            for (int i = 1; i <= textL; i++) {
                eachText = text.charAt(i - 1);
                if (i == 1) {
                    DP[i] = new State(0, getValue(eachText), true, false, true);
                    continue;
                }
                DP[i] = new State(0, 0, true, false, false);
                int nextNum;
                if (eachText == '+') {
                    if (DP[i - 1].isOpt) {
                        if (DP[i - 1].isPlus)
                            DP[i].numState = DP[i - 1].optState + 10;
                        else
                            DP[i].numState = DP[i - 1].optState - 10;
                        DP[i].isNum = true;
                    }
                    if (DP[i - 1].isNum) {
                        DP[i].optState = DP[i - 1].numState;
                        DP[i].isOpt = true;
                    }
                    DP[i].isPlus = true;
                }

                else {
                    if (DP[i - 1].isOpt) {
                        if (DP[i - 1].isPlus)
                            nextNum = DP[i - 1].optState + 1;
                        else
                            nextNum = DP[i - 1].optState - 1;

                        if (DP[i].isNum)
                            DP[i].numState = Math.max(DP[i].numState, nextNum);
                        else {
                            DP[i].numState = nextNum;
                            DP[i].isNum = true;
                        }
                    }
                    if (DP[i - 1].isNum) {
                        if (text.charAt(i - 2) == '+') {
                            if (DP[i - 2].isPlus) {
                                nextNum = DP[i - 1].numState + 1;
                            } else
                                nextNum = DP[i - 1].numState - 1;
                            if (DP[i].isNum)
                                DP[i].numState = Math.max(DP[i].numState, nextNum);
                            else {
                                DP[i].numState = nextNum;
                                DP[i].isNum = true;
                            }
                        }

                        DP[i].optState = DP[i - 1].numState;
                        DP[i].isOpt = true;
                    }
                    DP[i].isPlus = false;
                }
            }
            System.out.println(DP[textL].numState);
        }

        int getValue(char eachText) {
            if (eachText == '+')
                return 10;
            return 1;
        }
    }

    public static void main(String[] args) throws IOException {
        new Solution().run();
    }
}
