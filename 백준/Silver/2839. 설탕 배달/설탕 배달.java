import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	static BufferedReader br; // 입력을 위한 br
	static BufferedWriter bw; // 출력을 위한 bw

	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in)); // 입력
		bw = new BufferedWriter(new OutputStreamWriter(System.out)); // 출력
		int N = Integer.parseInt(br.readLine()); // 설탕본지 개수 받기
		int fiveSugar = N / 5; // 설탕 봉지를 나눈 몫 저장
		int answer = -1;

		while (fiveSugar >= 0) { // 5kg 봉지가 0 이상일 때까지
			if ((N - fiveSugar * 5) % 3 == 0) { // 5kg 봉지를 제외한 값이 3의 배수라면
				answer = fiveSugar + (N - fiveSugar * 5) / 3; // 5kg 봉지와 3kg 봉지의 합 저장
				break; // while 문 빠져나가기
			}
			fiveSugar--; // 한 봉지씩 제거하다 음수가 되면 빠져나오기
		}

		bw.write(Integer.toString(answer));
		bw.flush(); // bw 총 출력
		br.close(); // 입력 종료
		bw.close(); // 출력 종료
	}
}