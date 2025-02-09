import java.util.*;
import java.io.*;

public class Test {
    static class Pair {
        int x, y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public String toString() {
            return this.x + " " + this.y;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), "");
        while (st.hasMoreTokens()) {
            System.out.println(st.nextToken());
        }
        System.out.println(Integer.parseInt("010"));
        // System.out.println(answer);
    }
}