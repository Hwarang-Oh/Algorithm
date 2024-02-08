import java.io.*;
import java.util.*;


public class NPTest {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int [] input = new int[N];
		
		for (int i = 0 ; i < N ; i++)
			input[i] = sc.nextInt();
		
		// step0 : ���� (��������)
		Arrays.sort(input);
		
		do {
			// ���� �̿��� ó�� ���� 
			System.out.println(Arrays.toString(input));
			
		}while(np(input));
	}
	
	public static boolean np(int[] p) { // �� ������ ������ ���� ���� ���� (P : �� ����)
		final int N = p.length;
		// step1 : ��ȯ��ġ ã�� ( ���ʺ��� ����⸦ ã���� ����� ������ ��ȯ ��ġ�� ��
		int i = N - 1;
		while( i > 0  && p[i-1] >= p[i]) --i; // �������Դٸ�, i == 0 OR p[i-1] < p[i]
		
		if (i == 0) return false; // ���� ������ ���°� ���� ū �����̹Ƿ� NP ����
		
		// step2 : ��ȯ ��ġ ( i - 1 )�� ���� �� ���ʺ��� ã�� ( ū �� �� �ּҰ� )
		
		int j = N - 1;
		while(p[i-1] >= p[j]) --j;
		
		// step3 : ��ȯ��ġ(i -1) ���� ã�� ��ġ (j)���� ��ȯ
		swap(p, i - 1, j); // swap ���� �Ǿ� ���� (�������� �����־��� ������)
		
		// step4 : �����(i)��ġ���� �� �ڱ��� �������� ����
		int k = N - 1;
		while(i < k) swap(p, i++, k--);
		
		return true;
	}
	
	public static void swap(int [] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
}
