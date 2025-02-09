package _202502_week1;

// Key -> 0 ~ 8번 까지의 번호가 매겨져 있음

// BitMasking 가능성.. => 해보기 

import java.io.*;
import java.util.*;

public class B31909_FOCUS_오화랑 {
    static class Pair {
        int x, y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static class Solution {
        int N, P;
        int[] pointList = new int[8];
        HashMap<Integer, Pair> orderMap = new HashMap<>();

        void run() throws IOException {
            BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
            N = Integer.parseInt(input.readLine());
            StringTokenizer st = new StringTokenizer(input.readLine());
            P = Integer.parseInt(input.readLine());

            for (int i = 0; i <= 7; i++) {
                pointList[i] = i;
                for (int j = i + 1; j <= 7; j++) {
                    int order = (int) Math.pow(2, i) + (int) Math.pow(2, j);
                    orderMap.put(order, new Pair(i, j));
                }
            }

            int eachOrder;
            Pair eachPair;
            for (int i = 0; i < N; i++) {
                eachOrder = Integer.parseInt(st.nextToken());
                if (orderMap.keySet().contains(eachOrder)) {
                    eachPair = orderMap.get(eachOrder);
                    int temp = pointList[eachPair.x];
                    pointList[eachPair.x] = pointList[eachPair.y];
                    pointList[eachPair.y] = temp;
                }
            }
            System.out.println(pointList[P]);
        }
    }

    public static void main(String[] args) throws IOException {
        new Solution().run();
    }
}
