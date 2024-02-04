import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	static int range; // 
	static StringBuilder sb; // 출력 저장할 sb

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // 입력
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)); // 출력
		sb = new StringBuilder(); // sb 초기화
		int N = Integer.parseInt(br.readLine()); // N 입력 => 재귀엔 값이 달라지므로 static 선언X
		
		dfs(0 , N); // 신기한 수 체크
		bw.append(sb); // bw에 min 저장
		bw.flush(); // bw 출력
		br.close(); // 입력 종료
		bw.close(); // 출력 종료

	}

	// 소수 체크 => 소수가 아니면 false 반환
	static boolean isPrime(int num) {
		if (num < 2) { // 0,1, 음수는 해
			return false;
		}
		for (int i = 2; i <= Math.sqrt(num); i++) {
			if (num % i == 0) {
				return false; // i로 나눠 떨어지면 소수X
			}
		}
		return true; // 소수라면 true 반환
	}

	// 신기한 소수 체크 => 자리수를 10으로 나눠가며 0이 될 때까지 체크
	static void dfs(int prime, int depth) { // 맨 처음 수와, 자리수를 전달받기
		if (depth <= 0) { // 자리수가 0까지 도달하면 신기한 소수가 맞음
			sb.append(prime).append("\n"); // sb에 num 추가
		}
		for (int i = 1; i < 10; i++) { // 0은 어차피 소수X => 1~9
			int num = 10 * prime + i; // 현재 수에 10을 곱하고, 자리수 더하기 => 12 -> 123
			if (depth > 0 && isPrime(num)) { // 아직 자리수가 N보다 작고, 만든 num이 소수면
				dfs(num, depth - 1); // 자리수를 더 붙여서 확인
			}
		}
	}
}
