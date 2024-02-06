import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;

// ��������Ʈ�� - �迭 ����
// ũ�� �ø��� �ʴ� ����
public class CBT<T> {
	private Object[] nodes;
	private final int SIZE;
	private int lastIndex;
	private ArrayList<Integer> thresHold = new ArrayList<Integer>(); 
	private int nodeCnt = 0;
	
	public CBT(int size) { // ��������Ʈ���� �Է��� ���´�.
		SIZE = size;
		nodes = new Object[size + 1];
		
		int temp = 1;
		while (true) {
			if (size < temp)
				break;
			thresHold.add(temp);
			temp *= 2;
		}
	}
	
	public boolean isEmpty() {
		return lastIndex == 0;
	}
	
	public boolean isFull() {
		return lastIndex == SIZE;
	}
	
	public void add(T e) {
		if (isFull()) {
			System.out.println("��ȭ");
			return;
		}
		nodes[++lastIndex] = e;
	}
	
	public void bfs() { // Queue�� �ִ� ���� �湮�� ���� �ƴ϶�, Queue���� ������ ���� �湮�� ���̴�. 
		if (isEmpty()) return; //Root �Ѱ��� �־�� �Ѵ�.
		Queue<Integer> queue = new ArrayDeque<>();
		queue.offer(1); // �湮�� ��带 ������ �� �ֱ�
		
		while(!queue.isEmpty()) {
			int current = queue.poll();
			System.out.println(nodes[current]); // Node ó������
			
			// ���� �ڽ� ���, ������ �ڽ� ��� 
			if (current*2 <= lastIndex) queue.offer(current*2);
			if (current * 2 + 1<= lastIndex) queue.offer(current* 2 + 1);
		}
	}
	
	public void bfs2() { // Queue�� �ִ� ���� �湮�� ���� �ƴ϶�, Queue���� ������ ���� �湮�� ���̴�. 
		if (isEmpty()) return; //Root �Ѱ��� �־�� �Ѵ�.
		Queue<int[]> queue = new ArrayDeque<>();
		queue.offer(new int[] {1,0}); // �湮�� ��带 ������ �� �ֱ� -> {nodeIndex , �ʺ�}
		
		while(!queue.isEmpty()) {
			int[] currentInfo = queue.poll();
			int current = currentInfo[0];
			int breadth = currentInfo[1];
			System.out.println(breadth + ":" + nodes[current]); // Node ó������

			
			// ���� �ڽ� ���, ������ �ڽ� ��� 
			if (current*2 <= lastIndex) queue.offer(new int[] {current*2, breadth + 1});
			if (current * 2 + 1<= lastIndex) queue.offer(new int[] {current* 2 + 1, breadth + 1});
		}
	}
	
	public void bfs3() { // Queue�� �ִ� ���� �湮�� ���� �ƴ϶�, Queue���� ������ ���� �湮�� ���̴�. 
		if (isEmpty()) return; //Root �Ѱ��� �־�� �Ѵ�.
		Queue<Integer> queue = new ArrayDeque<>();
		queue.offer(1); // �湮�� ��带 ������ �� �ֱ� -> {nodeIndex , �ʺ�}
		
		int breadth = 0;
		while(!queue.isEmpty()) {
			int size = queue.size();
			System.out.println("breadth " + breadth + " : ");
			while (--size >= 0) {
				int current = queue.poll();
				System.out.print(breadth + ":" + nodes[current] + "\t"); // Node ó������
				// ���� �ڽ� ���, ������ �ڽ� ��� 
				if (current*2 <= lastIndex) queue.offer(current*2);
				if (current * 2 + 1<= lastIndex) queue.offer(current* 2 + 1);
			}
			++breadth;
			System.out.println();
		}
	}
}
// �ڽ� ��带 Ž���� ��, Queue�� ����� �þ��.
// 0�� ģ���� �������� �� �ʺ� 1�� ģ������ ����.

// ������ ���� Size�� ���� �ʺ� ������ �ִ� ���� => ���� �ʺ��� Ž�� ������ Queue�� �� �ִ�. 
// Queue size => 1�϶� �ʺ� 0�ΰ� 1��
// Queue Size => 2�϶� �ʺ� 1�ΰ� 2��
// Queue Size => 4�϶� �ʺ� 2�ΰ� 4�� 
// ���� for�� => ���� �ʺ� ���� ���� ó���� ������. 


// 1 2 4 8 