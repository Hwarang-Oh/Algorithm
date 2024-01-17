import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class JavaLang_1 {
	public static void main(String[] args) throws IOException{
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("숫자 입력 >> ");
		int num = Integer.parseInt(input.readLine());
		int totalSum = 0;
		
		for (int start = 1 ; start <= num ; start++) {
			if (start % 2 == 0)
				totalSum += start;
		}
		System.out.printf("1부터 %d까지 수 중 짝수의 합 = %d",num,totalSum);
	}
}
