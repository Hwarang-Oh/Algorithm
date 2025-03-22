package _TEST;

import java.util.*;

public class Problem1_오화랑 {

    static class Solution {
        HashMap<String, Integer> hash = new HashMap<>();
        int[] link;

        void run(String[] words, String[] nextWords, String startWord, int count) {
            // * STEP 1 : words 배열에 있는 단어들을 HashMap 에 넣는다.
            for (int i = 0; i < words.length; i++)
                hash.put(words[i], i);

            // * STEP 2 : nextWords 배열을 순회하면서 Link를 만들어 낸다.
            link = new int[words.length];
            for (int i = 0; i < nextWords.length; i++) {
                String[] split = nextWords[i].split(" ");
                int from = hash.get(split[0]);
                int to = hash.get(split[1]);
                link[from] = to;
            }

            // * STEP 3 : startWord 를 시작으로 count 만큼 순회하면서 출력한다.
            StringBuilder sb = new StringBuilder();
            int current = hash.get(startWord);
            while (count-- > 0) {
                sb.append(words[current]).append(" ");
                current = link[current];
            }

            System.out.println(sb);
        }
    }

    public static void main(String[] args) {
        String[] words = { "let", "it", "go", "wow" };
        String[] nextWords = { "let it", "it go", "go let", "wow go" };
        String startWord = "go";
        int count = 6;
        new Solution().run(words, nextWords, startWord, count);
    }

}
