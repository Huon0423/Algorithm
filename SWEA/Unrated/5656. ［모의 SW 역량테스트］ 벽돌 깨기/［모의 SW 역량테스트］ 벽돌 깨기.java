import java.io.*;
import java.util.*;

public class Solution {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringBuilder sb = new StringBuilder(); // 출력을 저장할 sb
	static StringTokenizer st;
	static int N, W, H; // 벽돌의 수와 공간의 크기
	static int[][] map; // 게임을 할 공간
	static int[] dx = { -1, 1, 0, 0 }; // 방향벡터
	static int[] dy = { 0, 0, -1, 1 }; // 상하좌우
	static int answer; // 최솟값을 저장할 변수

	public static void main(String[] args) throws IOException {
		int T = Integer.parseInt(br.readLine()); // 테스트 케이스 수 입력
		for (int testCase = 1; testCase <= T; testCase++) { // 테스트 케이스만큼 돌며
			answer = Integer.MAX_VALUE; // 변수 초기화

			// 입력 시작
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken()); // 젹돌의 개수
			W = Integer.parseInt(st.nextToken()); // 공간의 너비
			H = Integer.parseInt(st.nextToken()); // 공간의 높이
			map = new int[H][W]; // 주어진 공간만큼 초기화
			for (int i = 0; i < H; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < W; j++) {
					map[i][j] = Integer.parseInt(st.nextToken()); // 벽돌 상태 저장
				}
			}

			// 게임 실행
			dfs(0, map);
			sb.append("#").append(testCase).append(" ").append(answer).append("\n");
		}
		bw.append(sb); // 정답을 bw에 추가
		bw.flush(); // 정답 출력
		br.close(); // 입력 종료
		bw.close(); // 출력 종료
	}

	// 배열이 변하지 않도록 복사해서 사용하며 탐색하는 플레이 함수
	static void dfs(int depth, int[][] arr) {
		if (answer == 0) { // 정답이 이미 최솟값이라면(벽돌의 수는 0 이상)
			return; // 재귀 종료
		}
		if (getBlockN(arr) == 0) { // arr에 남아있는 벽돌이 없다면
			answer = 0; // 남은 벽돌의 개수로 answer 바꾸기
			return; // 재귀 종료
		}
		if (N == depth) { // 이미 N번 깨트렸다면
			answer = Math.min(answer, getBlockN(arr)); // 현재 정답과 지금 arr의 벽돌 수 중 최솟값을 저장
			return; // 재귀 종료
		}
		
		for (int i = 0; i < W; i++) { // 열마다 돌며
			// 필요한 변수들 초기화
			boolean[][] visited = new boolean[H][W]; // 방문 확인 함수
			int[][] temp = new int[H][W]; // arr을 복사할 copy 배열
			for (int copy = 0; copy < H; copy++) {
				System.arraycopy(arr[copy], 0, temp[copy], 0, W);
			}
			boolean flag = false; // 같은 벽돌을 부수지 않기 위해 필요한 변수
			
			// 맨 위의 벽돌 찾아서 깨트리기
			for (int j = 0; j < H; j++) { // 행에서 벽돌이 존재하는 가장 작은 행 => 가장 높은 벽돌 위치
				if (arr[j][i] > 0) { // 벽돌이 존재한다면
					breakBlock(arr, j, i, temp, visited); // 벽돌 제거
					sendBlockDown(temp); //
					flag = true; // 이미 부순 벽돌로 설정
					break; // 더 내려갈 필요 없으므로 for문 나가기
				}
			}
			if (flag) { // 벽돌을 부쉈으면 다음 N번째 깨트리기 시도
				dfs(depth + 1, temp); // 벽돌을 못 부쉈을 경우, 진행 의미 없음
			}
		}
	}

	// 벽돌을 아래로 한칸씩 내리는 함수
	static void sendBlockDown(int[][] arr) {
		Stack<Integer> stack = new Stack<Integer>(); // 벽돌을 보관할 스택
		for (int j = 0; j < W; j++) { // 열을 이동하며 해야하므로, j 먼저
			for (int i = 0; i < H; i++) {
				if (arr[i][j] > 0) { // 벽돌이 있다면
					stack.push(arr[i][j]); // stack에 넣기
				}
				arr[i][j] = 0; // 공간 비우기
			}
			int height = H - 1; // 공간의 높이
			while (!stack.empty()) { // 스택이 비기 전까지
				arr[height--][j] = stack.pop(); // 공간에 스택에 들어있는 벽돌 할당
			}
		}
	}

	// 벽돌을 깨트리는 함수
	static void breakBlock(int[][] arr, int x, int y, int[][] temp, boolean[][] visited) {
		for (int v = 0; v < 4; v++) { // 상하좌우를 돌며
			for (int i = 0; i < arr[x][y]; i++) { // 폭탄의 범위까지
				int nx = x + dx[v] * i; // 이동할 행 계산
				int ny = y + dy[v] * i; // 이동할 열 계산
				
				// 범위 내에 존재하며, 방문하지 않은 벽돌이라면
				if (nx >= 0 && nx < H && ny >= 0 && ny < W && !visited[nx][ny]) {
					temp[nx][ny]--; // 벽돌을 제거하고
					visited[nx][ny] = true; // 방문 처리
					if (arr[nx][ny] > 0) {
						temp[nx][ny] = 0;
						breakBlock(arr, nx, ny, temp, visited); // 벽돌 연쇄 제거
					}
				}
			}
		}
	}

	// 남아 있는 벽돌의 수를 계산하는 함수
	static int getBlockN(int[][] arr) {
		int block = 0; // 벽돌의 수를 저장할 변수
		for (int[] row : arr) { // 행 반환
			for (int column : row) { // 열 중에서
				if (column > 0) { // 0보다 크다면
					block++; // 개수 증가
				}
			}
		}
		return block; // 벽돌의 수 반환
	}
}
