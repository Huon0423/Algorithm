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
	static int[] GyuYeongscards; // 규영이의 카드를 저장할 배열
	static int[] InYeongsCards; // 인영이의 카드를 저장할 배열
	static int[] caseCards; // 인영이가 낼 수 있는 카드 배열
	static boolean[] visited; // 재귀를 돌 때 방문체크할 배열
	static final int N = 9; // 게임 라운스 횟수
	static int win;

	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in)); // 입력
		bw = new BufferedWriter(new OutputStreamWriter(System.out)); // 출력
		sb = new StringBuilder(); // sb 초기화
		int T = Integer.parseInt(br.readLine()); // testCase 개수

		for (int testCase = 1; testCase <= T; testCase++) {
			sb.append("#").append(testCase).append(" "); // 출력 양식 저장
			stk = new StringTokenizer(br.readLine()); // 9장 카드의 정보
			GyuYeongscards = new int[N]; // 규영이의 카드 수만큼 초기화
			InYeongsCards = new int[N]; // 인영이의 카드 수만큼 초기화
			caseCards = new int[N]; // 인영이의 카드 수만큼 초기화
			visited = new boolean[N]; // 인영이의 카드 수만큼 초기화
			boolean[] check = new boolean[18]; // 인영이의 카드를 구하기 위한 배열
			win = 0; // 승리 횟수 초기화

			// 카드 입력받기
			for (int i = 0; i < N; i++) {
				GyuYeongscards[i] = Integer.parseInt(stk.nextToken()); // 카드를 배열에 저장
				check[GyuYeongscards[i] - 1] = true; // 규영이의 카드는 true로 바꾸기
			}
			int j = 0; // caseCards 인덱스
			for (int i = 0; i < 18; i++) { // 총 18번을 돌며
				if (check[i]) { // 규영이의 카드라면
					continue; // 넘김
				}
				caseCards[j++] = i + 1; // 인영이가 낼 수 있는 카드 저장
			}

			cardGame(0); // 게임 시작
			sb.append(win).append(" ").append(362880 - win).append("\n"); // 정답 저장
		}
		bw.append(sb); // bw에 sb 추가
		bw.flush(); // bw 총 출력
		br.close(); // 입력 종료
		bw.close(); // 출력 종료
	}

	static void cardGame(int index) {
		if (index == N) { // 게임 라운드가 모두 끝나면
			int GyuYeongsPoint = 0; // 규영이의 점수
			int InYeongsPoint = 0; // 인영이의 점수

			// 점수 계산
			for (int i = 0; i < N; i++) {
				if (GyuYeongscards[i] > InYeongsCards[i]) { // 규영이의 숫자가 더 높다면
					GyuYeongsPoint += GyuYeongscards[i] + InYeongsCards[i]; // 규영이 점수 up
					continue; // for문 넘김
				}
				// 점수가 같으면 무승부인데 지는 경우로 포함되어 있음????
				InYeongsPoint += GyuYeongscards[i] + InYeongsCards[i]; // 인영이 점수 up
			}
			if (GyuYeongsPoint > InYeongsPoint) { // 규영이의 점수가 더 크다면
				win++; // 승리 횟수 추가
			}
			return; // 재귀 종료
		}

		// 게임 라운드가 진행 중이면
		for (int i = 0; i < N; i++) {
			if (visited[i]) { // 이미 고른 카드라면
				continue; // 넘김
			}
			InYeongsCards[index] = caseCards[i]; // 인영이가 낼 카드 넣기
			visited[i] = true; // 방문 처리
			cardGame(index + 1); // 다음 라운드 인영이 카드 고르기
			visited[i] = false; // 방문 취소
		}
	}
}