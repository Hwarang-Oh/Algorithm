
public class CBT_Test {

	public static void main(String[] args) {
		CBT<Character> tree = new CBT<>(10);
		for (int i = 0 ; i < 10 ; i++) {
			tree.add((char)(65 + i));
		}
//		tree.bfs();
//		System.out.println("==================================");
//		tree.bfs2();
		System.out.println("==================================");
		tree.bfs3();
	}
}

// ���� ��¿��� Level�� ���� ������ �������� �ʴ´�.
//��� �ϸ� �ʺ� �����ؼ� ����� �س� �� ������??
// �湮 ���θ� Ȯ������ �ʾҴ� In Tree
// �� �������� �ٸ� �������� ���� ��찡 ������
// Acyclic => �湮������ �� �ʿ䰡 ����. 