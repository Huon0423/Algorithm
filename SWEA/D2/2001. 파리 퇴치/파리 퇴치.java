/*
 * 오른쪽으로는 열의 누적합을 저장하고, 아래로는 행과 열의 모든 누적합을 저장한다.
 * 누적합을 저장할 때도, 누적합을 이용해 저장한다.
 * x2, y2의 누적합에 x1-1 ,y2의 누적합과 x2, y1-1의 누적합을 빼고, 중복으로 빼진 x1-1, y1-1의 값을 더해준다.
 * max 변수에 가장 작은 값을 넣어두고, for문을 돌며 M*M 크기의 누적합 중 가장 큰 값을 max에 갱신해준다.
 */

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

class Solution {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // 입력
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)); // 출력
		StringBuilder sb = new StringBuilder(); // 출력을 저장할 sb

		int T = Integer.parseInt(br.readLine()); // TestCase 개수 받기
		for (int testCase = 1; testCase <= T; testCase++) {
			StringTokenizer stk = new StringTokenizer(br.readLine()); // br로 N과 M 읽어오기
			int N = Integer.parseInt(stk.nextToken()); // 배열의 크기 N 입력받기
			int M = Integer.parseInt(stk.nextToken()); // 파리 퇴치 영역 M 입력받기
			sb.append("#").append(testCase).append(" "); // 출력 양식 저장

			// 전체 영역 배열 입력
			int[][] ground = new int[N + 1][N + 1]; // 전체 영역을 저장할 배열 -> index 에러를 막기위해 각 행열 +1
			for (int i = 1; i <= N; i++) {
				stk = new StringTokenizer(br.readLine()); // 전체 영역 배열에 넣을 값 받아오기
				for (int j = 1; j <= N; j++) {
					ground[i][j] += ground[i][j - 1] + ground[i - 1][j] - ground[i - 1][j - 1]
							+ Integer.parseInt(stk.nextToken()); // 배열에 누적합을 이용해서 값 넣기
				}
			}

			int max = Integer.MIN_VALUE; // 가장 작은 값을 max에 넣어둔다.
			for (int i = 1; i <= N - M + 1; i++) { // N-M으로 하면 마지막 행이나 열이 포함이 안됨 => M 크기가 한칸 정도 걸쳐야함 == +1
				for (int j = 1; j <= N - M + 1; j++) {
					// ground[i][j]의 값도 누적합에 포함이므로, i부터 i+M-1까지가 i부터 M 크기의 누적합이다.
					// i, j 부터의 누적합에 i-1, j-1 경우의 누적합을 각각 빼주고, 겹치는 [i-1][j-1]읋 더해준다.
					int sum = ground[i + M - 1][j + M - 1] - ground[i - 1][j + M - 1] - ground[i + M - 1][j - 1]
							+ ground[i - 1][j - 1];
					max = Math.max(max, sum); // 가장 큰 값을 저장한다.
				}
			}

			sb.append(max).append("\n"); // 출력 양식 저장
		}

		bw.append(sb); // bw에 sb 저장
		bw.flush(); // bw 출력
		br.close(); // 입력 종료
		bw.close(); // 출력 종료
	}

}
