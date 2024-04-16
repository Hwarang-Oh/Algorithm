import java.io.*;
import java.util.*;

public class J1183_�������Ǳ���_��ȭ�� {
	static int[] coinList = {500, 100, 50, 10, 5, 1};
	static int[] haveList;
	public static void main(String[] args) throws IOException {
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		int target = Integer.parseInt(input.readLine());
		int max = 0; int newTarget;
		
		int[] coinList = {500, 100, 50, 10, 5, 1};
		int[] haveList = new int[6];
		int[] usedList = new int[6];
		
		StringTokenizer st = new StringTokenizer(input.readLine());
		for (int i = 0 ; i < 6 ; i++) {
			haveList[i] = Integer.parseInt(st.nextToken());
			max += coinList[i] * haveList[i];
		}
		
		newTarget = max - target;
		for (int i = 0 ; i < 6 ; i++) {
			if (newTarget > coinList[i])
				usedList[i] = newTarget / coinList[i];
				newTarget %= coinList[i];
		}
		System.out.println(Arrays.toString(usedList));
		
		
	}
}
// 100�� 5�� -> 500�� 1��

// 50�� 2�� -> 100�� 1�� => 50�� 10�� -> 500�� 1��

// 10�� 5�� -> 50�� 1�� => 10�� 10�� -> 100�� 1�� => 10�� 50�� -> 500�� 1��

// 5�� 2�� -> 10�� 1�� => 5�� 10�� -> 50�� 1�� => 5�� 20�� -> 100�� 1��

// 1�� 5�� -> 5�� 1�� => 1�� 10�� -> 10�� 1�� => 1�� 50�� -> 50�� 1��

// 100�� 5���� �ִٸ� 500������ ȯ�� => 500���� ��ٸ� 100���� 5�� ����!

// 4 5 2 6 3 4 => 5(4 + 1), 1(0 + 1), 

// newCoinList;
// {500, 100, 50, 10} , {100, 50, 10, 5}, {50, 10, 5, 1}, {10, 5, 1}, {5, 1}, {1}\
// w = 500x + 100x + 50x + 10x + 5x + x;