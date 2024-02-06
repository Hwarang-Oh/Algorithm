import java.util.*;
import java.io.*;

public class S1233_��Ģ������ȿ��_��ȭ�� {
	static int[][] tree;
	static StringTokenizer st;
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		for (int tc = 1 ; tc <= 10 ; tc++) {
			Solve(tc);
		}
		System.out.println(sb);
	}
	
	public static void Solve(int tc) throws IOException {
		int nodeLength = Integer.parseInt(input.readLine());
		tree = new int[nodeLength + 1][3];
		int nodeNum;
		String tempValue;
		
		for (int i = 1 ; i <= nodeLength ; i++) {
			st = new StringTokenizer(input.readLine());
			nodeNum = Integer.parseInt(st.nextToken());
			tempValue = st.nextToken(); // �� Node�� ������ Ȥ�� ���ڸ� �Է� �޴´�.
			switch (tempValue) {
				case "+" : case "-" : case "*" : case "/" : tree[nodeNum][0] = 1; break; // ���� ���� ������ -> 1�� ���� 
				default : tree[nodeNum][0] = 2; // ���� ���� ���� -> 2�� ����
			}
			
			if (nodeNum > nodeLength/2) // nodeNum�� ��ü ��� ���� half���� ũ��, left / right �ڽ� ������ X
				continue;
			
			if (nodeLength/2 == nodeNum && nodeLength%2 == 0) { // nodeNum == ��ü ��� ���� half�� ����, nodeLength�� ¦���� => ���� �ڽĸ� ����
				tree[nodeNum][1] = Integer.parseInt(st.nextToken()); // ���� �ڽ� index�� �о��ֱ�
				continue;
			}
			
			tree[nodeNum][1] = Integer.parseInt(st.nextToken());
			tree[nodeNum][2] = Integer.parseInt(st.nextToken());
		}
		calCheck(tc, nodeLength);
	}
	
	public static void calCheck(int tc, int nodeLength) {
		boolean canCalculate = true;
		if (nodeLength%2 == 0) {
			canCalculate = false;
			sb.append("#").append(tc).append(" ").append(canCalculate ? 1 : 0).append("\n");
			return;
		}
		
		for (int i = (nodeLength/2) ; i >= 1 ; i--) {
			int left = tree[i][1]; // ���� �θ� ���忡�� ���� �ڽ� Index
			int right = tree[i][2]; // ���� �θ� ���忡�� ������ �ڽ� Index
			if ((tree[left][0] - tree[i][0]) * tree[right][0] != 2) { // => "���� ������ ����"�� ��쿡��, ����� ���ڷ� ���� �� ����, ���� (����V - ������V)*����V = ����V�� �ǰ� ���� 
				canCalculate = false; // ( 2 - 1 ) * 2 = 2 , �ٸ� ��쿡�� ����� 2�� ���ư��� ����. => ���� 2�� �ȵǸ�, �� ���ڷ� ����� ���� �� ���ٸ�, ��� �Ұ�! 
				break;
			}
			tree[i][0] = (tree[left][0] - tree[i][0]) * tree[right][0];
		}
		sb.append("#").append(tc).append(" ").append(canCalculate ? 1 : 0).append("\n");
	}
}
