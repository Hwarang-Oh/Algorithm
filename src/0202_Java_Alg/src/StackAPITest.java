import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;

public class StackAPITest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Stack<String> stack = new Stack<String>(); // vector�κ��� ��ӹ��� ( vector�� List�� ����ü ) => push�� add ��� ����.
		Queue<String> queue = new ArrayDeque<String>();
		
		System.out.println(queue.isEmpty() + "//" + queue.size());
		queue.offer("��ȭ��");
		queue.offer("ī����");
		queue.offer("�ֿ���");
		System.out.println(queue.isEmpty() + "//" + queue.size());
		queue.offer("ī����");
		System.out.println(queue.peek());
		System.out.println(queue.isEmpty() + "//" + queue.size());
//		System.out.println(stack.pop());
//		System.out.println(stack.isEmpty() + "//" + stack.size());
		System.out.println("================================");
		while(!queue.isEmpty()) {
			System.out.println(queue.poll());
			System.out.println(queue.isEmpty() + "//" + queue.size());
		}
	}

}

// ������ : Queue����  : ������ �������� ȹ�� ������ ���� ���������� Counting