import java.io.*;
import java.util.*;

// https://www.acmicpc.net/problem/11053
public class B11053_가장긴증가하는부분수열1_오화랑 {
    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        int numLength = Integer.parseInt(input.readLine());
        int[] numList = new int[numLength];
        int[] cntList = new int[numLength];
        StringTokenizer st = new StringTokenizer(input.readLine());
        numList[0] = Integer.parseInt(st.nextToken());
        cntList[0] = 1;
        for (int i = 1; i < numLength; i++) {
            numList[i] = Integer.parseInt(st.nextToken());
            cntList[i] = 1;
            for (int j = 0; j < i; j++) {
                if (numList[j] < numList[i])
                    cntList[i] = Math.max(cntList[j] + 1, cntList[i]);
            }
        }
        Arrays.sort(cntList);
        System.out.println(cntList[numLength - 1]);
    }
}