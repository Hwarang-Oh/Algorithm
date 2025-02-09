package _202502_week1;

import java.io.*;
import java.util.*;

// 100, 001, 000 이 3가지 경우에만 Fallen
// 100, 1, 0 숫자만 Fallen

public class B9287_Jenga_오화랑 {

    static class Solution {
        int T, H;

        void run() throws IOException {
            BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
            StringBuilder sb = new StringBuilder();
            T = Integer.parseInt(input.readLine());

            int blockState;
            boolean eachResult;
            for (int t = 1; t <= T; t++) {
                eachResult = true;
                H = Integer.parseInt(input.readLine());
                for (int i = 0; i < H; i++) {
                    blockState = Integer.parseInt(input.readLine());
                    if (!eachResult)
                        continue;
                    if (blockState == 0 || blockState == 1 || blockState == 100)
                        eachResult = false;
                }
                if (eachResult)
                    sb.append("Case " + t + ": Standing").append("\n");
                else
                    sb.append("Case " + t + ": Fallen").append("\n");
            }
            System.out.println(sb);
        }
    }

    public static void main(String[] args) throws IOException {
        new Solution().run();
    }
}
