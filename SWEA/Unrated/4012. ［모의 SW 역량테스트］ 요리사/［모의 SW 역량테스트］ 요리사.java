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
	static int[][] synergy; // 음식 조합을 저장할 배열
	static boolean[] visited; // 방문 체크할 boolean 배열
	static int N; // 식재료의 개수
	static int min; // 두 맛의 차이의 최솟값

	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in)); // 입력
		bw = new BufferedWriter(new OutputStreamWriter(System.out)); // 출력
		sb = new StringBuilder(); // sb 초기화

		int T = Integer.parseInt(br.readLine()); // testCase 수 받기ㅇ
		for (int testCase = 1; testCase <= T; testCase++) { // testCase만큼 돌며
			sb.append("#").append(testCase).append(" "); // 출력 양식 저장
			min = Integer.MAX_VALUE; // 최댓값으로 갱신해놓기
			N = Integer.parseInt(br.readLine()); // 식재료의 개수 받기
			synergy = new int[N][N];// NxN으로 초기화
			visited = new boolean[N];// N으로 초기화

			// synerge 배열 값 저장
			for (int i = 0; i < N; i++) {
				stk = new StringTokenizer(br.readLine()); // 행 받기
				for (int j = 0; j < N; j++) {
					synergy[i][j] = Integer.parseInt(stk.nextToken()); // 각 열에 값 저장
				}
			}

			dfs(0, 0); // 처음 index와 재료 개수를 넣고 시작
			sb.append(min).append("\n"); // 최솟값 저장
		}

		bw.append(sb); // bw에 sb 추가
		bw.flush(); // bw 총 출력
		br.close(); // 입력 종료
		bw.close(); // 출력 종료
	}

	public static void dfs(int index, int ingredient) { // 재귀로 음식 시너지 찾는 함수
		if (ingredient == N / 2) { // 재료들이 반이상 골라졌을 때
			int containedSum = 0; // 담은 재료들의 합
			int NonContainedSum = 0; // 아직 담지 않은 재료들의 합

			// containedSum과 NonContainedSum 구하기
			for (int i = 0; i < N; i++) {
				for (int j = i + 1; j < N; j++) {
					if (visited[i] && visited[j]) { // 방문한 곳이라면
						containedSum += synergy[i][j] + synergy[j][i]; // 담은 재료 합 추가
						continue; // 넘김
					}
					// 모두 방문하지 않아야 하므로, if문 필수...
					if (!visited[i] && !visited[j]) { // 방문하지 않은 곳이라면
						NonContainedSum += synergy[i][j] + synergy[j][i]; // 담지 않은 재료 합 추가
					}
				}
			}

			// 최솟값과 두 합의 차를 비교해서 더 작은 값으로 갱신
			min = Math.min(min, Math.abs(containedSum - NonContainedSum));
			return; // 재귀 빠져나가기
		}

		// 아직 재료를 반 이상 담지 않았을 때
		for (int i = index; i < N; i++) {
			visited[i] = true; // 방문한 곳 체크
			dfs(i + 1, ingredient + 1); // 재료를 더 담기
			visited[i] = false; // 방문 취소
		}
	}
}