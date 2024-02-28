import java.io.*;
import java.util.*;

class Core { // 코어 위치를 저장할 객체
	int x, y; // 코어의 행과 열

	Core(int x, int y) { // 코어 객체 생성자
		this.x = x;
		this.y = y;
	}
}

class Solution {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // 입력
	static StringBuilder sb = new StringBuilder(); // 출력할 sb
	static StringTokenizer st; // 문자열 자를 st
	static int N, size, min; // 배열 크기 N,코어의 개수와 최솟값
	static int map[][]; // 코어와 전선을 저장할 배열
	static int dx[] = { -1, 1, 0, 0 }; // 방향벡터
	static int dy[] = { 0, 0, -1, 1 }; // 상하좌우
	static Core cores[]; // 코어와 전선 상태를 저장할 배열
	static boolean visited[]; // 방문 체크할 배열

	public static void main(String[] args) throws NumberFormatException, IOException {
		int T = Integer.parseInt(br.readLine()); // 테스트 케이스
		for (int testCase = 1; testCase <= T; testCase++) {
			sb.append("#").append(testCase).append(" "); // 출력양식 저장
			cores = new Core[12]; // 코어의 최댓값은 12
			visited = new boolean[12]; // 코어의 방문 체크할 배열 => 12로 초기화
			min = Integer.MAX_VALUE; // 최솟값 초기화
			size = 0; // 코어의 개수를 셀 변수

			N = Integer.parseInt(br.readLine()); // 배열 크기
			map = new int[N][N]; // 배열 N*N 초기화
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine()); // 입력값
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken()); // 배열에 넣기
				}
			}

			// 가장자리는 이미 연결 => 행과 열 1부터 N-1까지
			for (int i = 1; i < N - 1; i++) {
				for (int j = 1; j < N - 1; j++) {
					if (map[i][j] == 1) { // 코어를 찾으면
						cores[size++] = new Core(i, j); // 코어 추가
					}
				}
			}

			// 코어 개수만큼 돌며 => 최대한 많은 코어 연결 === size부터 0까지
			for (int i = size; i >= 0; i--) {
				combinate(0, 0, i);
				if (min < Integer.MAX_VALUE) {
					break;
				}
			}
			sb.append(min).append("\n"); // 최솟갑 저장
		}
		System.out.println(sb); // 출력
	}

	public static void combinate(int index, int count, int R) {
		if (count == R) { // Core를 R개만큼 뽑으면
			dfs(0, 0); // dfs로 확인
			return; // 재귀 종료
		}
		for (int i = index; i < size; i++) { //
			visited[i] = true;
			combinate(i + 1, count + 1, R);
			visited[i] = false;
		}
	}

	public static void dfs(int index, int count) { // 재귀 함수
		if (index == size) { // R만큼 뽑으면
			min = Math.min(min, count); // 최솟값 갱신
			return; // 재귀 종료
		}
		if (!visited[index]) { // 아직 방문하지 않은 코어라면
			dfs(index + 1, count); // 방문
			return; // 재귀 종료
		}

		// 방향벡터를 돌며
		for (int i = 0; i < 4; i++) {
			int x = cores[index].x; // 현재 코어의 행
			int y = cores[index].y; // 현재 코어의 열
			int tmp = 0; // 코어에 연결한 전선 수
			boolean canMake = false; // 전선 가능 여부

			while (true) {
				x += dx[i]; // 행 이동
				y += dy[i]; // 열 이동
				if (x < 0 || x >= N || y < 0 || y >= N) { // 범위 끝까지 이동한다면
					canMake = true; // 전선 연결 가능
					break; // while 나가기
				}
				if (map[x][y] != 0) {
					break;
				}
				map[x][y] = 2;
				tmp++;
			}
			if (canMake) { // 전선 연결이 가능하다면
				dfs(index + 1, count + tmp); // 다음 코어를 호출 => 전선 수를 넘김
			}
			while (true) {
				x -= dx[i]; // 초기 상태로 돌리기
				y -= dy[i]; // 초기 상태로 돌리기
				if (x == cores[index].x && y == cores[index].y) {
					break; // 처음 상태와 같아지면 break
				}
				map[x][y] = 0;
			}
		}
	}
}
