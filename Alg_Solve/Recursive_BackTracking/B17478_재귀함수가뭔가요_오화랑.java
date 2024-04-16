import java.io.*;
import java.lang.*;

public class BOJ_17478_HR {

	public static void main(String[] args) throws IOException {
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		int recurNum = Integer.parseInt(input.readLine());
		int cnt = 0;
		wordMake(recurNum,cnt);
	}
	public static void wordMake(int recurNum, int cnt) {
		StringBuilder sb = new StringBuilder();
		if (cnt == 0)
			System.out.println("��� �� ��ǻ�Ͱ��а� �л��� ������ �������� ã�ư� ������.");
		
		if (cnt == recurNum) {
			sb = new StringBuilder();
			for (int i = 0; i < cnt ; i++) sb.append("____");
			sb.append("\"����Լ��� ������?\"\n");
			for (int i = 0; i < cnt ; i++) sb.append("____");
			sb.append("\"����Լ��� �ڱ� �ڽ��� ȣ���ϴ� �Լ����\"\n");
			for (int i = 0; i < cnt ; i++) sb.append("____");
			sb.append("��� �亯�Ͽ���.");
			System.out.println(sb.toString());
			return;
		}
		
		sb = new StringBuilder();
		sb.append(words(cnt));
		System.out.println(sb.toString());
		
		cnt++; 
		wordMake(recurNum, cnt);
		
		sb = new StringBuilder();
		for (int i = 0; i < cnt-1 ; i++) sb.append("____");
		sb.append("��� �亯�Ͽ���.");
		System.out.println(sb.toString());
	}
	
	
	public static String words(int cnt) {
		StringBuilder sb = new StringBuilder();
		
		for (int i = 0; i < cnt ; i++) sb.append("____");
		sb.append("\"����Լ��� ������?\"\n");
		
		for (int i = 0; i < cnt ; i++) sb.append("____");
		sb.append("\"�� ����. �������� �� �� ����⿡ �̼��� ��� ������ ����� ������ �־���.\n");
		
		for (int i = 0; i < cnt ; i++) sb.append("____");
		sb.append("���� ������� ��� �� ���ο��� ������ ������ �߰�, ��� �����Ӱ� ����� �־���.\n");
		
		for (int i = 0; i < cnt ; i++) sb.append("____");
		sb.append("���� ���� ��κ� �ǾҴٰ� �ϳ�. �׷��� ��� ��, �� ���ο��� �� ���� ã�ƿͼ� ������.\"");
		
		return sb.toString();
	}
}
