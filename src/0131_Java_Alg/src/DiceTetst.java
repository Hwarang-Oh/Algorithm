import java.util.Arrays;
import java.util.Scanner;

// �ֻ����� 3�� ������ ���� �� �ִ� ��� ���
// 112�� 121�� �ٸ� -> ������ �����ϳ� ������ �ٸ��� diff �Ǵ� => Permutation
// value�� �ߺ��� ������. ( Duplicate )

// �ֻ��� ������ ( ������ Ƚ���� 6�� ���϶� ���� )
public class DiceTetst {
	static int N, numbers[];
	static boolean[] isSelected;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt(); 
		numbers = new int[N];
		int mode= sc.nextInt() ;
		
		switch (mode) {
		case 1: // �ߺ�����
			dice1(0);
			break;
		case 2: // ���� : �ߺ� ����
			isSelected = new boolean[7];
			dice2(0);
			break;
		
		}
	}
	
	public static void dice1(int cnt) { // �������� ���� �ֻ��� Ƚ��
		
		if (cnt == N)
			System.out.println(Arrays.toString(numbers));
			return;
		
		for (int i = 1; i <= 6; i++) { // ��� �ֻ����� ���� �õ�
			numbers[cnt] = i; // �ǵ��� �ʿ� X ������ cnt �ڸ����� �ֱ� ������, ��� ����� 
			dice1(cnt + 1); 
			} // cnt�� ���� �ٱʹ� �����ǹ� X
	}

	
	public static void dice2(int cnt) { // �������� ���� �ֻ��� Ƚ��
		// ������ �� ���� -> �Էµ� �� ���� => 1-> 0, input.length ( input �迭�� isSelected �迭 ���� )
		if (cnt == N)
			System.out.println(Arrays.toString(numbers));
			return;
		for (int i = 1; i <= 6; i++) { // ��� �ֻ����� ���� �õ�
			if (isSelected[i]) continue;
			
			numbers[cnt] = i;
		}// �ǵ��� �ʿ� X ������ cnt �ڸ����� �ֱ� ������, ��� ����� 
		
	}		
		//  �ߺ�����
	public static void dice3(int cnt, int start) {
		if (cnt == N) {
			System.out.println(Arrays.toString(numbers));
		}
	}
	it4(int cnt ; int stat) {
		if (cnt == N)
	}
		
		
	// ����
	public static void de
	it4(int cnt ; nt stat) {
		if (cnt == N)
	}
}
