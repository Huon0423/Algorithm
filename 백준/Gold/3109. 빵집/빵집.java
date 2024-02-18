import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer stk; // 문자열을 자를 stk
	static int R, C; // 빵집 근처를 받을 배열의 크기
	static int count; // 파이프의 개수
	static char[][] map; // 빵집 사이 건물을 받을 배열
	static boolean[][] visited; // 방문 체크할 배열
	static int[] dr = { -1, 0, 1 }; // 열은 이동 못하고 행은 대각선만 이동가능 => 행의 방향벡터

	public static void main(String[] args) throws IOException {
		stk = new StringTokenizer(br.readLine()); // 입력값 받기
		R = Integer.parseInt(stk.nextToken()); // 행의 크기
		C = Integer.parseInt(stk.nextToken()); // 열의 크기
		map = new char[R][C]; // 배열을 R*C 크기로 초기화

		for (int i = 0; i < R; i++) {
			map[i] = br.readLine().toCharArray(); // 배열 받기
		}

		// 행 하나씩 돌며 재귀함수 호출 => 행 처음부터 시작하기 때문!
		for (int i = 0; i < R; i++) {
			dfs(0, i);
		}

		bw.write(Integer.toString(count)); // count 저장
		bw.flush(); // 총 출력
		br.close(); // 입력 종료
		bw.close(); // 출력 종료
	}

	// 재귀를 돌며 파이프 설치
	static boolean dfs(int x, int y) { // 현재 행과 열 받기
		// 방향 벡터를 돌며
		for (int v = 0; v < 3; v++) {
			int nx = y + dr[v]; // 행 이동
			int ny = x + 1; // 열 이동

			// 이동할 곳이 범위 밖이거나 건물이라면
			if (nx < 0 || nx > R - 1 || ny < 0 || ny > C - 1 || map[nx][ny] == 'X') {
				continue; // 넘김
			}
			// 이동할 곳이 빈 곳이라면
			if (map[nx][ny] == '.') {
				if (ny == C - 1) { // 이동할 곳이 도달점 앞이면
					count++; // 파이프 설치 후
					return true; // true 반환
				}
				map[nx][ny] = '-'; // 파이프 설치
				
				if (dfs(ny, nx)) { // 재귀를 부르고 true 반환
					return true;
				}
			}

		}
		return false; // false 반환으로 모든 재귀 종료
	}
}