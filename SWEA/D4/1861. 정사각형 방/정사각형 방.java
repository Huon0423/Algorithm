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
	static int N; // 배열의 크기 => N * N
	static int[][] rooms; // 방을 저장할 배열
	static int[] dx = { -1, 0, 1, 0 }; // 상우하좌 순서의
	static int[] dy = { 0, 1, 0, -1 }; // 방향벡터
	static int maxCount; // 이동 횟수 => 큰 값으로 갱신
	static int roomNum; // 가장 많이 이동 가능한 방의 번호

	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in)); // 입력
		bw = new BufferedWriter(new OutputStreamWriter(System.out)); // 출력
		sb = new StringBuilder(); // sb 초기화
		int T = Integer.parseInt(br.readLine()); // testCase 수 입력 받기
		for (int testCase = 1; testCase <= T; testCase++) { // testCase만큼
			N = Integer.parseInt(br.readLine()); // N 입력 받기
			rooms = new int[N][N]; // 숫자를 저장할 방 == room 개수만큼의 배열
			roomNum = 10000; // 방 번호 초기화
			maxCount = -1; // 최대 이동 횟수 초기화

			// rooms 입력
			for (int i = 0; i < N; i++) {
				stk = new StringTokenizer(br.readLine()); // n개의 정수 받기
				for (int j = 0; j < N; j++) {
					rooms[i][j] = Integer.parseInt(stk.nextToken()); // 숫자 저장
				}
			}

			int moveCount; // 각 방의 이동 횟수를 저장해놓을 변수
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					moveCount = bfs(i, j); // 이동횟수 구하기
					if (maxCount < moveCount) { // 만약 최대 이동 횟수보다 많으면
						roomNum = rooms[i][j]; // 방 번호 저장
						maxCount = moveCount; // 최대 이동횟수 갱신
						continue; // 넘김
					}
					// 이동 횟수가 같다면 방 번호가 더 작은 것으로
					if(maxCount == moveCount && rooms[i][j] < roomNum) {
						roomNum = rooms[i][j]; // 방 번호 저장
						maxCount = moveCount; // 최대 이동횟수 갱신
					}
				}
			}
			// 정답 저장
			sb.append("#").append(testCase).append(" ").append(roomNum).append(" ").append(maxCount).append("\n");
		}

		bw.append(sb); // bw에 sb 저장
		bw.flush(); // bw 총 출력
		br.close(); // 입력 종료
		bw.close(); // 출력 종료
	}

	static int bfs(int r, int c) { // 스택 없이 구하기
		int nx, ny; // 다음에 이동할 행과 열
		int moveCount = 1; // 이동횟수를 저장할 변수 => 현재 위치 포함
		roop: while (true) {
			for (int v = 0; v < 4; v++) { // 방향 벡터르 ㄹ돌며
				nx = r + dx[v]; // 행 갱신
				ny = c + dy[v]; // 열 갱신
				if (nx < 0 || nx >= N || ny < 0 || ny >= N) { // 범위 밖이면
					continue; // 넘김
				}
				if (rooms[nx][ny] - rooms[r][c] == 1) { // 미래 위치와 현재 위치의 차가 1이라면
					moveCount++; // 이동이 가능하므로 횟수 증가
					r = nx; // 현재 행을 미래 위치로 갱신
					c = ny; // 현재 열을 미래 위치로 갱신
					continue roop; // 방향 벡터 벗어나기
				}
			}
			break; // 네 방향을 다 돌아도 이동X => while 빠져나가기
		}
		return moveCount; // 이동 횟수 반환
	}
}