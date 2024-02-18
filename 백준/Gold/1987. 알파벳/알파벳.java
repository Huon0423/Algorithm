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
	static int R; // 세로 R칸
	static int C; // 가로 C칸
	static String[][] board; // 앒파벳을 받을 배열
	static boolean[][] visited; // 방문 체크 배열
	static int[] dx = { -1, 1, 0, 0 }; // 방향 벡터
	static int[] dy = { 0, 0, 1, -1 }; // 상하좌우
	static int maxLength = 0;

	public static void main(String[] args) throws IOException {
		stk = new StringTokenizer(br.readLine()); // 행과 열 받기
		R = Integer.parseInt(stk.nextToken()); // 크기 받기
		C = Integer.parseInt(stk.nextToken()); // 크기 받기
		visited = new boolean[R][C]; // 방문배열 초기화

		// 알파벳 받기
		board = new String[R][C]; // 배열 초기화
		for (int i = 0; i < R; ++i) {
			board[i] = br.readLine().split(""); // 공백없이 잘라서 넣기 => char 말고 String
		}

		dfs(0, 0, board[0][0], 1); // 함수 호출
		bw.write(Integer.toString(maxLength)); // sb 저장
		bw.flush(); // 총 출력
		br.close(); // 입력 종료
		bw.close(); // 출력 종료
	}

	// 방문할 알파벳의 좌표와 알파벳을 추가할 str, str에 추가된 알파벳의 개수를 매개변수로 받는 함수
	public static void dfs(int x, int y, String str, int strLength) {
		maxLength = Math.max(maxLength, strLength); // 재귀를 돌 때마다 최댓값 체크

		// 방향 벡터를 돌며
		for (int v = 0; v < 4; v++) {
			int nx = x + dx[v]; // 이동할 좌표
			int ny = y + dy[v]; // 이동할 좌표

			// 만약 이동할 곳이 범위 밖이거나 이미 방문한 곳이라면
			if (nx < 0 || nx >= R || ny < 0 || ny >= C || visited[nx][ny]) {
				continue; // 넘김
			}
			// 만약 이제까지 포함하지 않은 알파벳이라면
			if (!str.contains(String.valueOf(board[nx][ny]))) {
				visited[nx][ny] = true; // 방문 처리
				dfs(nx, ny, str + board[nx][ny], strLength + 1); // 이 알파벳을 추가한 상태로 재귀 시작
				visited[nx][ny] = false; // 방문 취소
			}
		}

	}
}