import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	static int N; // 재료 개수 N
	static int[] sour; // 신맛 배열
	static int[] bitter; // 쓴맛 배열
	static int min; // 신맛과 쓴맛의 최소 차이 변수

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // 입력
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)); // 출력
		N = Integer.parseInt(br.readLine()); // N 입력
		min = Integer.MAX_VALUE; // 최소 값을 저장

		sour = new int[N]; // 신맛 배열 N으로 초기화
		bitter = new int[N]; // 쓴맛 배열 N으로 초기화

		// 재료 신맛과 쓴맛 받기
		for (int i = 0; i < N; i++) {
			StringTokenizer stk = new StringTokenizer(br.readLine()); // br로 값 읽어오기
			sour[i] = Integer.parseInt(stk.nextToken()); // 값 넣기
			bitter[i] = Integer.parseInt(stk.nextToken()); // 값 넣기
		}

		BackTracking(0, 1, 0, 0); // 재귀 호출 => s는 곱하기이므로 1부터 시작

		bw.append(Integer.toString(min)); // bw에 min 저장
		bw.flush(); // bw 출력
		br.close(); // 입력 종료
		bw.close(); // 출력 종료
	}

	public static void BackTracking(int index, int s, int b, int count) throws IOException {
		if (index == N) { // count가 0이어도 index가 N이라면 종료해야 함
			if (count != 0 && Math.abs(s-b) < min) { // count가 1 이상이고 min보다 작은 값이라면
				min = Math.min(min, Math.abs(s - b)); // min 갱신
			}
			return;
		}
		BackTracking(index + 1, s * sour[index], b + bitter[index], count + 1); //이번 재료 넣기
		BackTracking(index + 1, s, b, count); // 이번 재료 안 넣기
	}
}
