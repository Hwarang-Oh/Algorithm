import java.util.*;
import java.io.*;

public class B14499_�ֻ���������_��ȭ�� {
	static int[] currDice = new int [6];
	static int row, col, map[][];
	static StringBuilder sb = new StringBuilder();
	// { 0, 0, 0, 0, 0, 0 } => 
	// {1, 2, 3, 4, 5, 6} => �� �� �� �� �� �� (�� : �� -> ��, �� -> ��, �� -> �� , �� -> �� ) (�� : �� -> ��, �� -> ��, �� -> ��, �� -> �� )
	// (�� : �� -> �� , �� -> ��, ��-> ��, ��, ��) (�� : �� -> ��, �� -> ��, �� -> ��, �� -> ��)
	// �� : 1, �� : 2, �� : 3, �� : 4
	// { 1(��), 2(��), 3(��), 4(��), 5(��), 6(��) } �� => { 4(��), 2(��), 1(��), 6(��), 5(��), 3(��) } �� => { 1(��), 2(��), 3(��), 4(��), 5(��), 6(��) } 
	// �� => { 1(��), 2(��), 3(��), 4(��), 5(��), 6(��) } �� => { 5(��), 1(��), 3(��), 4(��), 6(��), 2(��) } �� => { 1(��), 2(��), 3(��), 4(��), 5(��), 6(��) }

	public static void main(String[] args) throws IOException {
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(input.readLine());
		row = Integer.parseInt(st.nextToken());
		col = Integer.parseInt(st.nextToken());
		map = new int[row][col];
		
		int sRow = Integer.parseInt(st.nextToken());
		int sCol = Integer.parseInt(st.nextToken());
		int optNum = Integer.parseInt(st.nextToken());
		
		for (int i = 0 ; i < row ; i++) {
			st = new StringTokenizer(input.readLine());
			for (int j = 0 ; j < col ; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		st = new StringTokenizer(input.readLine());
		int tempX; int tempY; int mode;
		for (int i = 0 ; i < optNum ; i++) {
			tempX = sRow; tempY = sCol;
			mode = Integer.parseInt(st.nextToken());
			switch(mode) {
				case 1: tempX += 0; tempY += 1; break;
				case 2: tempX += 0; tempY += -1; break;
				case 3: tempX += -1; tempY += 0; break;
				case 4: tempX += 1; tempY += 0; break;
			}
			if (tempX < 0 || tempY < 0 || tempX >= row || tempY >= col) continue;
			sRow = tempX; sCol = tempY;
			move(mode, sRow, sCol);
		}
		System.out.print(sb);
	}
	
	public static void move(int mode, int sRow, int sCol) { // �� {0,1} ��{0,-1} ��{-1,0} ��{1,0}
		moveDice(mode);
		if (map[sRow][sCol] == 0) map[sRow][sCol] = currDice[5];
		else {
			currDice[5] = map[sRow][sCol];
			map[sRow][sCol] = 0;
		}
		sb.append(currDice[0]).append("\n");
	}
	
	public static void moveDice(int mode) {
		int[] nextDice = new int[6];
		if (mode == 1) { nextDice[0] = currDice[3]; nextDice[1] = currDice[1]; 
		nextDice[2] = currDice[0]; nextDice[3] = currDice[5]; 
		nextDice[4] = currDice[4]; nextDice[5] = currDice[2]; }
		
		if (mode == 2) { nextDice[0] = currDice[2]; nextDice[1] = currDice[1]; 
		nextDice[2] = currDice[5]; nextDice[3] = currDice[0]; 
		nextDice[4] = currDice[4]; nextDice[5] = currDice[3]; }
		
		if (mode == 3) { nextDice[0] = currDice[4]; nextDice[1] = currDice[0]; 
		nextDice[2] = currDice[2]; nextDice[3] = currDice[3]; 
		nextDice[4] = currDice[5]; nextDice[5] = currDice[1]; }
		
		if (mode == 4) { nextDice[0] = currDice[1]; nextDice[1] = currDice[5]; 
		nextDice[2] = currDice[2]; nextDice[3] = currDice[3]; 
		nextDice[4] = currDice[0]; nextDice[5] = currDice[4]; }
		
		currDice = nextDice;
	}
}
