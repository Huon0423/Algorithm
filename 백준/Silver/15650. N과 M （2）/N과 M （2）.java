import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/*
 * 1부터 N까지 재귀를 통해 수열을 고른다.
 * isSelected를 사용해서 중복 없이 고른다.
 */

public class Main {
	static int N; // 범위 변수 N
	static int M; // 수열 개수 M
	static int[] sequence; // 수열을 저장할 배열
	static StringBuilder sb; // 출력을 저장할 sb

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // 입력
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)); // 출력
		sb = new StringBuilder();
		String[] num = br.readLine().split(" "); // br로 N과 M 읽어오기
		N = Integer.parseInt(num[0]); // N 입력
		M = Integer.parseInt(num[1]); // M 입력
		sequence = new int[M]; // 수열을 저장할 배열 초기화
		BackTracking(0, 1); // 재귀 호출
		bw.append(sb); // bw에 sb 추가
		bw.flush(); // bw에 남은 글자 모두 출력
		br.close(); // 입력 종료
		bw.close(); // 출력 종료
	}

	public static void BackTracking(int index, int cnt) throws IOException {
		if (index == M) { // 배열의 크기가 M과 같다면 => ++index == M
			for (int s : sequence) { // 0부터 M까지
				sb.append(s); // bw에 수열 추가
				sb.append(" "); // 출력 양식 저장
			}
			sb.append("\n"); // 출력 양식 저장
			return; // 재귀 종료
		}
		for (int i = cnt; i <= N; i++) { // 1부터 N까지
			sequence[index] = i; // 배열에 값 저장
			BackTracking(index + 1, i + 1); // 다시 재귀 => 오름차순==나보다 큰 수 이므로 cnt 증가
		}
	}
}
