package _202503_week3;

/**
 * IMP : https://www.acmicpc.net/problem/14238
 * IMP : 2025.03.17 출근 기록
 * * StartLink => One Day One Person 출근 
 * * AAC => A, A, C 형태로 출근을 함
 * * A : 매일매일 출근 가능함
 * * B : 출근한 다음날은 반드시 쉬어야 함
 * * C : 출근한 다음날과 다다음날은 반드시 쉬어야 함 
 * * => 'BB' or 'CAC' 와 같은 형태는 나올 수가 없음 
 * TYPE : 출근기록 S가 주어졌을 때, S의 모든 순열 중에서 올바른 출근 기록인 것을 아무거나 출력하는 프로그램을 작성
 * ! S의 길이는 50을 넘지 않는다.
 * IMP : 정말 오랜만의 순조부 => Naive한 방법으로는 시간 초과 
 * ? Naive한 순열이 안되면, NextPermutation?
 */

import java.io.*;

public class B14238_출근기록_오화랑 {

    static class Solution {
        String S;
        boolean made;
        int targetSize;
        char[] workList;

        void run() throws IOException {
            BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
            S = input.readLine();
            targetSize = S.length();
            workList = new char[targetSize];

            int aCount, bCount, cCount;
            aCount = bCount = cCount = 0;
            for (int i = 0; i < targetSize; i++) {
                if (S.charAt(i) == 'A')
                    aCount++;
                else if (S.charAt(i) == 'B')
                    bCount++;
                else
                    cCount++;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        new Solution().run();
    }
}

/**
 * IMP : 시간 초과 Logic
 * void makePermutation(int count, int aLeft, int bLeft, int cLeft, char
 * oneBefore, char twoBefore) {
 * if (made) {
 * return;
 * }
 * 
 * if (count == targetSize) {
 * System.out.println("완성 상태 : " + String.valueOf(workList));
 * made = true;
 * return;
 * }
 * 
 * char temp;
 * if (aLeft > 0) {
 * workList[count] = 'A';
 * temp = twoBefore;
 * twoBefore = oneBefore;
 * oneBefore = 'A';
 * System.out.println("현재 상태 : " + String.valueOf(workList));
 * makePermutation(count + 1, aLeft - 1, bLeft, cLeft, oneBefore, twoBefore);
 * oneBefore = twoBefore;
 * twoBefore = temp;
 * }
 * 
 * if (!made && bLeft > 0 && oneBefore != 'B') {
 * workList[count] = 'B';
 * temp = twoBefore;
 * twoBefore = oneBefore;
 * oneBefore = 'B';
 * System.out.println("현재 상태 : " + String.valueOf(workList));
 * makePermutation(count + 1, aLeft, bLeft - 1, cLeft, oneBefore, twoBefore);
 * oneBefore = twoBefore;
 * twoBefore = temp;
 * }
 * 
 * if (!made && cLeft > 0 && oneBefore != 'C' && twoBefore != 'C') {
 * workList[count] = 'C';
 * temp = twoBefore;
 * twoBefore = oneBefore;
 * oneBefore = 'C';
 * System.out.println("현재 상태 : " + String.valueOf(workList));
 * makePermutation(count + 1, aLeft, bLeft, cLeft - 1, oneBefore, twoBefore);
 * oneBefore = twoBefore;
 * twoBefore = temp;
 * }
 * }
 */