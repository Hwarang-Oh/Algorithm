import java.io.*;


public class JavaLang_2 {
	public static void main(String[] args) throws IOException {
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		int month;
		int count = 0;
//		for (int SSAFY = 0 ; SSAFY < 3 ; SSAFY++) {
//			System.out.print("월 입력>> ");
//			month = Integer.parseInt(input.readLine());
//			if (month < 3)
//				System.out.printf("%d월은 겨울입니다.%n",month);
//			else if (month < 6)
//				System.out.printf("%d월은 봄입니다.%n",month);
//			else if (month < 9)
//				System.out.printf("%d월은 여름입니다.%n",month);
//			else if (month < 11)
//				System.out.printf("%d월은 가을입니다.%n",month);
//			else 
//				System.out.printf("%d월은 겨울입니다.%n",month);		
//		}
		while (count < 3) {
			System.out.print("월 입력>> ");
			month = Integer.parseInt(input.readLine());
			switch (month) {
				case 12: case 1: case 2:
					System.out.printf("%d월은 겨울입니다.%n",month);
					break;
				case 3: case 4: case 5:
					System.out.printf("%d월은 봄입니다.%n",month);
					break;
				case 6: case 7: case 8:
					System.out.printf("%d월은 여름입니다.%n",month);
					break;
				default :
					System.out.printf("%d월은 가을입니다.%n",month);
				}
			count++;	
		}
	}
}

