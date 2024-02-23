import java.util.*;
import java.io.*;

public class PRIM_Test {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int V = Integer.parseInt(in.readLine());
		int[][] adjMatrix = new int[V][V];
		boolean[] visited = new boolean[V];
		int[] minEdge = new int[V];
		
		StringTokenizer st = null;
		for (int i = 0 ; i < V ; i++) {
			st = new StringTokenizer(in.readLine());
			for (int j = 0 ; j < V ; j++) {
				adjMatrix[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		Arrays.fill(minEdge, Integer.MAX_VALUE); // �ּҰ� �������� Max �ʱ�ȭ
		minEdge[0] = 0;  // ������ ������ 0�� ���� ó��
		int result = 0;
		
		for (int c = 0 ; c < V ; c++) {
			// step 1 : ��Ʈ�� ���� �� �ּҰ�������� ���� ã��
			int min = Integer.MAX_VALUE;
			int minVertex =-1;
			
			// step 2 : ���Ӱ� Ʈ�� ������ Ȯ��� ���� �������� ��Ʈ�� ��������� ���� ��� ��� ���� ������Ʈ
			for (int i = 0 ; i < V ; i++) {
				if (!visited[i] && minEdge[i] < min) {
					min = minEdge[i];
					minVertex = i;
				}
			}
			if (minVertex == -1) break;
			result += min; // ������� ����
			visited[minVertex] = true; // Ʈ�� ������ ����
			
			// step 2 : ���Ӱ� Ʈ�� ������ Ȯ��� ���� �������� ��Ʈ�� ��������� ���� ��� ��� ���� ������Ʈ
			for (int i = 0 ; i < V ; i++) {
				if (!visited[i] && adjMatrix[minVertex][i] != 0 &&
						adjMatrix[minVertex][i] < minEdge[i]) {
					minEdge[i] = adjMatrix[minVertex][i];
				}
					
			}
		}
	}
}
