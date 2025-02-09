package _202502_week1;

import java.io.*;
import java.util.*;

/**
 * IMP : https://www.acmicpc.net/problem/23325
 * IMP : 2025.02.07
 */

/**
 * * +----+-+-
 * IMP : 이 식은, "열 십(十)과 +", "하나 일(一)과 -"이 뒤섞인 상태
 * * 이런 이유로, 해당 식은 다양한 해석이 가능한 상태 -> 가능한 해석에서 가장 최대값을 찾아라
 * Type : 올바른 해석
 * * 숫자로 시작해서 숫자로 끝나고, 숫자와 연산자가 번갈아 가면서 나와야 한다.
 * * +- : 11 , + : 10, - : 1, -+ (숫자 X) , -- (숫자 X), ++ (숫자 X)
 */

// +, -로 이루어진 길이가 200,000 이하의 문자열이 주어진다.
// 올바른 해석이 존재하는 입력만 존재한다.

/**
 * * Step 1 -> 그냥 되는 대로 한다?
 * * 일단 해석의 여지가 생기는 부분은 10과 11
 */

public class B23325_마법천자문_오화랑 {

    static class State {
        int id, value;
        boolean isNumber;

        public State(int id, int value, boolean isNumber) {
            this.id = id;
            this.value = value;
            this.isNumber = isNumber;
        }
    }

    static class Solution {
        String text;
        int maxResult = Integer.MIN_VALUE;
        Queue<State> queue = new ArrayDeque<>();

        void run() throws IOException {
            BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
            text = input.readLine();
            int maxWord = text.length();

            if (text.charAt(0) == '+') {
                queue.offer(new State(1, 10, true));
                if (text.charAt(1) == '-')
                    queue.offer(new State(2, 11, true));
            } else
                queue.offer(new State(1, 1, true));

            State current;
            int cId, cV;
            boolean cIsNum;
            while (!queue.isEmpty()) {
                current = queue.poll();
                cId = current.id;
                cV = current.value;
                cIsNum = current.isNumber;
                if (cId == maxWord) {
                    if (cIsNum)
                        maxResult = Math.max(maxResult, cV);
                    continue;
                }

                current.id++;
                // IMP : Current Number로 끝난 State -> 'I' Should Be Operator
                if (cIsNum)
                    current.isNumber = false;
                // IMP : Current Operator로 끝난 State -> 'I' Should Be Number
                else {
                    current.isNumber = true;
                    if (text.charAt(cId) == '-') {
                        if (text.charAt(cId - 1) == '+')
                            current.value++;
                        else
                            current.value--;
                    } else {
                        if (text.charAt(cId - 1) == '+') {
                            current.value += 10;
                            if (cId + 1 < maxWord && text.charAt(cId + 1) == '-')
                                queue.offer(new State(cId + 2, cV + 11, true));
                        } else {
                            current.value -= 10;
                            if (cId + 1 < maxWord && text.charAt(cId + 1) == '-')
                                queue.offer(new State(cId + 2, cV - 11, true));
                        }
                    }
                }
                queue.offer(current);
            }
            System.out.println(maxResult);
        }
    }

    public static void main(String[] args) throws IOException {
        new Solution().run();
    }
}
