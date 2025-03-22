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
        System.out.println(2 == Math.ceil(4 / 2));
    }
}