package _TEST;

import java.util.*;

import javax.swing.text.Segment;

public class Problem2_오화랑 {

    static class SegmentTree {
        int size;
        long[] tree;

        public SegmentTree(int n) {
            size = 1;
            while (size < n)
                size <<= 1;
            tree = new long[size << 1];
        }

        public void update(int idx, long val) {
            int i = idx + size - 1;
            tree[i] += val;
            while ((i >>= 1) > 0)
                tree[i] = tree[i << 1] + tree[i << 1 | 1];
        }

        public long query(int l, int r) {
            if (l > r)
                return 0;
            long ret = 0;

            l += size - 1;
            r += size - 1;

            while (l <= r) {
                if ((l & 1) == 1)
                    ret += tree[l++];
                if ((r & 1) == 0)
                    ret += tree[r--];
                l >>= 1;
                r >>= 1;
            }
            return ret;
        }
    }

    static class Solution {

        // ? popList에 나타나 있는 특정 책을 뽑아서, 맨 위로 올리는 작업을 수행한다.
        // ? 이때, 특정 책을 뽑아 올리는데 소요되는 힘은 해당 책보다 위에 있는 책들의 개수다.
        // ? popList Operation을 수행하고 난 후, 소요된 힘의 총합을 출력하라.
        void run(int[] bookList, int[] popList) {
            long start = System.nanoTime();

            int result = 0;
            for (int i = 0; i < popList.length; i++) {
                int target = popList[i];
                // * STEP 1 : popList에 나타난 특정 책을 bookList를 순회하면서 탐색한다.
                int point = 0;
                for (int j = 0; j < bookList.length; j++) {
                    if (bookList[j] == target) {
                        result += j; // * STEP 2 : 책을 뽑아 올리는데 소요되는 힘을 더한다.
                        point = j;
                        break;
                    }
                }
                // * STEP 3 : 책을 뽑아 올리고, 맨 위로 올리는 작업을 수행한다.
                // * STEP 4 : 책을 뽑아 올리는 작업을 수행하고 난 후, 책들을 한 칸씩 뒤로 민다.
                for (int j = point; j > 0; j--)
                    bookList[j] = bookList[j - 1];
                bookList[0] = target;
            }
            long end = System.nanoTime();
            System.out.println(result);
            System.out.println("실행 시간 (ms): " + (end - start) / 1_000_000.0 + "ms");
        }

        void run2(int[] bookList, int[] popList) {
            int N = bookList.length;
            int MAX = N + popList.length + 5;

            SegmentTree segmentTree = new SegmentTree(MAX);
            Map<Integer, Integer> map = new HashMap<>();

            for (int i = 0; i < N; i++) {
                int idx = i + 1;
                map.put(bookList[i], idx);
                segmentTree.update(idx, 1);
            }
            long totalCost = 0;
            int currentTop = N + 1;

            for (int book : popList) {
                int idx = map.get(book);
                long rank = segmentTree.query(1, idx) - 1;
                totalCost += rank;
                segmentTree.update(idx, -1);
                map.put(book, currentTop);

                segmentTree.update(currentTop, +1);
                currentTop++;
            }
            System.out.println(totalCost);
        }
    }

    public static void main(String[] args) {
        // * Book List -> Random으로 쌓여 있는 책 배열 30개 ( 1 ~ 100개 제한 )
        Random random = new Random();
        // int[] bookList = random.ints(100, 1, 101).toArray();
        // int[] popList = random.ints(100, 0, bookList.length)
        // .map(i -> bookList[i])
        // .toArray();
        int[] bookList = {
                1, 2, 3, 4, 5, 6, 7, 8, 9, 10,
                11, 12, 13, 14, 15, 16, 17, 18, 19, 20,
                21, 22, 23, 24, 25, 26, 27, 28, 29, 30
        };
        int[] popList = {
                5, 3, 2, 6, 8, 7, 1, 4, 9, 10
        };
        new Solution().run(bookList, popList);
        new Solution().run2(bookList, popList);
    }
}
