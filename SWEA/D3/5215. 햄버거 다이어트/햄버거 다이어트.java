import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

class Solution {
	static BufferedReader br; // 입력을 위한 br
	static BufferedWriter bw; // 출력을 위한 bw
	static StringBuilder sb; // 출력을 저장할 sb
	static StringTokenizer stk; // 문자열을 자를 stk

	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in)); // 입력
		bw = new BufferedWriter(new OutputStreamWriter(System.out)); // 출력
		sb = new StringBuilder(); // sb 초기화

		int T = Integer.parseInt(br.readLine()); // testCase 수 받기
		for (int testCase = 1; testCase <= T; testCase++) { // testCase만큼 돌며
			sb.append("#").append(testCase).append(" "); // 출력 양식 저장
			stk = new StringTokenizer(br.readLine()); // 입력 받아오기
			int N = Integer.parseInt(stk.nextToken()); // 재료의 수
			int maxCalorie = Integer.parseInt(stk.nextToken()); // 제한 칼로리

			int[][] ingredientsInfo = new int[N + 1][2]; // 각 재료의 점수와 칼로리를 저장할 배열
			int[][] dp = new int[N + 1][maxCalorie + 1]; // 1부터 사용 => +1 길이로 초기화

			for (int i = 1; i <= N; i++) {
				stk = new StringTokenizer(br.readLine()); // 재료 정보 받아오기
				ingredientsInfo[i][0] = Integer.parseInt(stk.nextToken()); // 맛 저장
				ingredientsInfo[i][1] = Integer.parseInt(stk.nextToken()); // 칼로리 저장
			}

			for (int i = 1; i <= N; ++i) { // 1부터 N까지
				for (int j = 1; j <= maxCalorie; ++j) { // 1부터 maxCalorie까지
					if (ingredientsInfo[i][1] > j) { // 재료의 칼로리가 현재 칼로리보다 클 때
						dp[i][j] = dp[i - 1][j]; // dp 값 갱신
						continue; // 넘김
					}
					// 재료의 칼로리가 현재 칼로리보다 낮다면
					// 이전에 갱신한 맛과 (갱신된 칼로리 - 현재 칼로리+현재 맛)을 비교해서 더 큰 값으로 갱신
					dp[i][j] = Math.max(ingredientsInfo[i][0] + dp[i - 1][j - ingredientsInfo[i][1]], dp[i - 1][j]);
				}
			}
			sb.append(dp[N][maxCalorie]).append("\n"); // 답 저장
		}
		bw.append(sb); // bw에 sb 추가
		bw.flush(); // bw 총 출력
		br.close(); // 입력 종료
		bw.close(); // 출력 종료
	}
}