import java.io.*;
import java.util.*;

public class B18921_������¡�˴ٸ��ǳʱ�_��ȭ�� {
	public static void main(String[] args) throws IOException {
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		int testCase = Integer.parseInt(input.readLine());
		for (int t = 0 ; t < testCase ; t++) {
			int size = Integer.parseInt(input.readLine());
			ArrayList<Integer> tempArr = new ArrayList<>();
			tempArr.add(1); tempArr.add(1);
			int index = 3;
			if (size == 1) System.out.println(tempArr.get(size - 1));
			if (size == 2) System.out.println(tempArr.get(size - 1));
			else {
				while (true) {
					tempArr.add(tempArr.get(index - 1) * 2);
					if (tempArr.get(index) > (int) Math.pow(10,9) + 7) {
						tempArr.clear();
					}
					index++;
				}
			}
		}
	}
}



// ��ⷯ ������ ���� dp�ȿ� ��Ÿ���� �Ѵ� 
// ������ ���� X�� ���� i��° -> i + X��°�� Jump ����
// N��° ¡�˴ٸ��� ����ġ�� �ȵǸ�, ��Ȯ�ϰ� �����ؾ� �Ѵ�.
// 1 2 3 4�� ¡�˴ٸ� : 1���� 4�� ��Ȯ�ϰ� �� �� �ִ� ����� ��!
// 1 2 3 4 => 1 4, 1 2 4, 1 3 4, 1 2 3 4 => 4�� => �κ����� �ƴѰ�? 
// 10^9�� ¡�˴ٸ���.. �� �� ������? => NextPowerSet?
// 1 -> 1 -> 2 -> 4 -> 8 -> 16 -> 32 -> 64 -> 128 -> 256 -> 512
