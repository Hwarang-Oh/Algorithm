import java.io.*;
import java.util.*;


public class MST_Test {
	static class Edge implements Comparable<Edge> {
		int from, to, weight;

		public Edge(int from, int to, int weight) {
			super();
			this.from = from;
			this.to = to;
			this.weight = weight;
		}

		@Override
		public int compareTo(Edge o) {
			// TODO Auto-generated method stub
			return Integer.compare(this.weight, o.weight);
		}
		
	}
	static int V;
	static Edge[] edgeList;
	static int[] parents;
	
	public static void main(String[] args) throws IOException {
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(input.readLine());
		V = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());
		edgeList = new Edge[E];
		
		for (int i = 0 ; i < E ; i++) {
			st = new StringTokenizer(input.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			edgeList[i] = new Edge(from, to, weight);
		} // ���� ����Ʈ ����
		
		// ��ó�� : ��������Ʈ ����
		Arrays.sort(edgeList);
		
		
		parents = new int[V]; // �ڽ��� �θ� Ȥ�� Root�� ���� (��� ���� )
		// 1. make - set
		make();
		
		// 2. ���ĵ� ���� �ϳ��� ������ ����Ʈ�� ���� 
		int weight = 0;
		int cnt = 0;
		for (Edge edge : edgeList) {
			if (!union(edge.from, edge.to)) continue; // v1�� v2��  Union �ֱ�
			weight += edge.weight;
			if (++cnt == V - 1) break;
		}
		System.out.println(weight);

	}
	public static void make() {
		parents = new int[V]; // �ڽ��� �θ� Ȥ�� Root�� ���� (��� ���� )
		for (int i = 0 ; i < V ; i++) {
			parents[i] = i;
		}
	}
	public static int find(int a) { // a�� ���� Tree�� root ã��
		if (a == parents[a]) return a;
		return parents[a] = find(parents[a]); // ��� ����
	}
	public static boolean union(int a, int b) {
		int aRoot = find(a); int bRoot = find(b); 
		if (aRoot == bRoot) return false; // a, b�� ���� Ʈ���� ���� �ִ� -> ���ʿ�
		parents[bRoot] = aRoot;
		return true;
	}

}
