import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

class Solution {
	static BufferedReader br;
	static BufferedWriter bw;
	static StringTokenizer stk;
	static StringBuilder sb;

	public static void main(String[] args) throws NumberFormatException, IOException {
		br = new BufferedReader(new InputStreamReader(System.in)); // 입력
		bw = new BufferedWriter(new OutputStreamWriter(System.out)); // 출력
		sb = new StringBuilder(); // 출력 저장
		int T = Integer.parseInt(br.readLine()); // testCase 개수

		for (int testCase = 1; testCase <= T; testCase++) { // testCase만큼
			sb.append("#").append(testCase).append(" "); // 출력 양식 저장
			stk = new StringTokenizer(br.readLine()); // 문자열을 자를 st
			int N = Integer.parseInt(stk.nextToken()); // 과자 봉지의 개수
			int M = Integer.parseInt(stk.nextToken()); // 무게 합 제한
			int max = 0; // 최댓값 초기화

			int[] snack = new int[N]; // 과자의 무게를 저장할 배열
			stk = new StringTokenizer(br.readLine()); // 문자열을 자를 st
			for (int i = 0; i < N; i++) { // N개만큼
				snack[i] = Integer.parseInt(stk.nextToken()); // 과자 무게 받기
			}

			for (int i = 0; i < N - 1; i++) {
				for (int j = i + 1; j < N; j++) {
					if (snack[i] + snack[j] > M) {
						continue;
					}
					max = Math.max(max, snack[i] + snack[j]); // max 갱신
				}
			}
			if (max == 0) {
				max = -1;
			}
			sb.append(max).append("\n"); // 답 저장

		}

		bw.append(sb); // M무게의 최댓값 출력
		bw.flush(); // bw 출력
		br.close(); // 입력 종료
		bw.close(); // 출력 종료
	}

}
