import java.util.PriorityQueue;

public class HeapTest {
	public static void main(String[] args) {
		
		PriorityQueue<Student> Slist = new PriorityQueue<Student>();
		Slist.offer(new Student("ī����",99));
		Slist.offer(new Student("����",90));
		Slist.offer(new Student("�ֿ���", 95));
		Slist.offer(new Student("����", 93));
		
		while (!Slist.isEmpty())
			System.out.print(Slist.poll() + " ");
	}
}
// PQ�� �۵���Ҹ� �� �����غ���!!

