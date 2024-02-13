import java.io.*;
import java.util.*;

public class B16435_������ũ����_��ȭ�� {
	public static void main(String[] args) throws IOException {
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(input.readLine());
		int numF = Integer.parseInt(st.nextToken());
		int snakeBird = Integer.parseInt(st.nextToken());
		PriorityQueue<Integer> heightList = new PriorityQueue<>(numF);
		
		st = new StringTokenizer(input.readLine());
		for (int i = 0 ; i < numF ; i++) heightList.offer(Integer.parseInt(st.nextToken()));
		
		while (!heightList.isEmpty()) {
			if (snakeBird >= heightList.poll()) snakeBird++;
			else break;
		}
		System.out.println(snakeBird);
	}
}

// ������ũ ����� �ڽź��� �۰ų� ���� ������ ���� �� ����. => �������� ����
// ���θ� �����ϱ� ������, ��� ��쿡�� ���κ��� ���� ������ �ݵ�� ���� �� ����.