import java.io.*;
import java.util.*;

public class B21608_����ʵ��б�_��ȭ�� {
	static int size;
	static int studentNum;
	static int[] studentIndex, likeList[], classRoom[], roomInfo[];

	
	public static void main(String[] args) throws IOException {
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		size = Integer.parseInt(input.readLine());
		studentNum = size * size;
		roomInfo = new int[studentNum][7]; // �¼� ���� : n�� �ڸ� {��,��,��,��, ���ִ� ����, x, y} -> {x,y, ���ִ� ����, ��, ��, ��, ��}
		studentIndex = new int[studentNum + 1];
		likeList = new int[studentNum][4];
		
		// -1,0 / 0,-1, / 1,0 / 0,1 (��, ��, ��, ��)
		int index = 0;
		for (int i = 0 ; i < size ; i++) {
			for (int j = 0 ; j < size ; j++) {
				roomInfo[index][0] = i; roomInfo[index][1] = j;
				if (i - 1 < 0) roomInfo[index][3] = -1;
				if (j - 1 < 0) roomInfo[index][4] = -1;
				if (i + 1 >= size) roomInfo[index][5] = -1;
				if (j + 1 >= size) roomInfo[index][6] = -1;
				index++;
			}
		}
		
		int student;
		for (int i = 0 ; i < studentNum ; i++) {
			StringTokenizer st = new StringTokenizer(input.readLine());
			student = Integer.parseInt(st.nextToken());
			studentIndex[student] = i;
			likeList[i][0] = Integer.parseInt(st.nextToken());
			likeList[i][1] = Integer.parseInt(st.nextToken());
			likeList[i][2] = Integer.parseInt(st.nextToken());
			likeList[i][3] = Integer.parseInt(st.nextToken());
			makeSeat(student, likeList[i]);
		}
		
		int totalPoint = 0; int tempCount; int stIndex;
		for (int i = 0 ; i < roomInfo.length ; i++) {
			tempCount = 0;
			stIndex = studentIndex[roomInfo[i][2]];
			for (int j = 0 ; j < 4 ; j++) {
				if (roomInfo[i][j+3] == likeList[stIndex][0]) tempCount++;
				if (roomInfo[i][j+3] == likeList[stIndex][1]) tempCount++;
				if (roomInfo[i][j+3] == likeList[stIndex][2]) tempCount++;
				if (roomInfo[i][j+3] == likeList[stIndex][3]) tempCount++;
			}
			switch (tempCount) {
				case 4: totalPoint += 900;
				case 3: totalPoint += 90;
				case 2: totalPoint += 9;
				case 1: totalPoint += 1;
				case 0: totalPoint += 0;
			}
		}
		System.out.println(totalPoint);
	}
	// �� �ڸ��� ������ ���̰�, �׿� �°� �ڸ��� ������ ���� ���? => ��� �������ֱ�! 
	public static void makeSeat(int eachStud, int[] like) {
		Queue<int []> tempSeat = new ArrayDeque<>();
		
		// 1. ���ǿ� ����, �ش� �л��� �� ��ĭ�� ����
		for (int i = 0 ; i < roomInfo.length ; i++) {
			if (roomInfo[i][2] != 0) continue;
			
			int[] temp = {i,0,0}; // �¼���ȣ, �ֺ���ȣ��, ��ĭ����
			for (int j = 0 ; j < 4 ; j++) { // �¼��� ������ �����Ѵ�.
				if (roomInfo[i][j+3] == like[0]) temp[1]++; // ���ʿ� ��ȣ �л�?
				if (roomInfo[i][j+3] == like[1]) temp[1]++; // ���ʿ� ��ȣ �л�?
				if (roomInfo[i][j+3] == like[2]) temp[1]++; // �Ʒ��ʿ� ��ȣ �л�?
				if (roomInfo[i][j+3] == like[3]) temp[1]++; // �����ʿ� ��ȣ �л�?
				if (roomInfo[i][j+3] == 0) temp[2]++; // ��ĭ�� � �ֳ�?
			}
			
			if (tempSeat.isEmpty()) // Queue�� ���ٸ�, �¼��� ������ �־��ش�.
				tempSeat.offer(temp);
			
			if (tempSeat.peek()[1] < temp[1]) { // 1-1.�ش� �¼��� ��ȣ �л��� ���ٸ�, ä��
				tempSeat.poll(); tempSeat.offer(temp);
			}
			else if (tempSeat.peek()[1] == temp[1]) { // 1-2. ��ȣ �л��� ������, ��ĭ�� �ֺ��� �� ���Ҵٸ�, ä��
				if (tempSeat.peek()[2] < temp[2]) { 
					tempSeat.poll(); tempSeat.offer(temp);
				}
			}// 1-3. �� ���ȣ -> ����ȣ�� üũ X? => �¼� ������ ������ �̹� �� ��ȣ�� �� ��ȣ�� �ּ� ������ ��� ����.
		}
		
		// 2. �� ĭ�� ���� �ֺ��� ������ ��������� ��. 
		int[] seat = tempSeat.poll(); // �� ĭ�� ���� ���� ������
		int seatX = roomInfo[seat[0]][0]; // �� ĭ�� x��ǥ
		int seatY = roomInfo[seat[0]][1]; // �� ĭ��  y��ǥ
		roomInfo[seat[0]][2] = eachStud; // ���� ���� Array�� �� �л� ������ �ְ�
		
		for (int i = 0 ; i < roomInfo.length ; i++) { // -1,0 / 0,-1, / 1,0 / 0,1 (��, ��, ��, ��)
			if (seatX - 1 == roomInfo[i][0] && seatY == roomInfo[i][1]) roomInfo[i][5] = eachStud; // ���� ��ġ�� ���� ���忡���� '��'
			if (seatX == roomInfo[i][0] && seatY - 1 == roomInfo[i][1]) roomInfo[i][6] = eachStud; // ���� ��ġ�� ���� ���忡���� '��'
			if (seatX + 1 == roomInfo[i][0] && seatY == roomInfo[i][1]) roomInfo[i][3] = eachStud; // ���� ��ġ�� �Ʒ��� ���忡���� '��'
			if (seatX == roomInfo[i][0] && seatY + 1 == roomInfo[i][1]) roomInfo[i][4] = eachStud; // ���� ��ġ�� ������ ���忡���� '��'
		}
	}
}
