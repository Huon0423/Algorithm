import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br; // 입력을 위한 br
	static BufferedWriter bw; // 출력을 위한 bw
	static StringBuilder sb; // 출력을 저장할 sb
	static StringTokenizer stk; // 문자열을 자를 stk
	static int[][] rotation;
	static int N; // 배열의 행 수
	static int M; // 배열의 열 수
	static int R; // 회전 수
	static int min; // 행과 열 중 더 작은 수

	static int[] dx = { 0, 1, 0, -1 }; // 우하좌상 순서의 방향 벡터
	static int[] dy = { 1, 0, -1, 0 }; // => 반시계로 회전할 때 사용

	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in)); // 입력
		bw = new BufferedWriter(new OutputStreamWriter(System.out)); // 출력
		stk = new StringTokenizer(br.readLine()); // 문자열을 자를 st
		sb = new StringBuilder(); // sb 초기화
		N = Integer.parseInt(stk.nextToken()); // N 입력 받기
		M = Integer.parseInt(stk.nextToken()); // M 입력 받기
		R = Integer.parseInt(stk.nextToken()); // R 입력 받기
		rotation = new int[N][M]; // 입력 배열을 초기화

		for (int i = 0; i < N; i++) {
			stk = new StringTokenizer(br.readLine()); // 문자열을 자를 st
			for (int j = 0; j < M; j++) {
				rotation[i][j] = Integer.parseInt(stk.nextToken()); // 배열 받기
			}
		}

		min = Math.min(N, M); // 행과 열 중 더 작은 값으로 저장
		for (int i = 0; i < R; i++) { // R번만큼
			rotate(); // rotate하기
		}
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				sb.append(rotation[i][j]).append(" "); // 배열 출력을 위해 sb 저장
			}
			sb.append("\n"); // 출력 양식 저장
		}

		bw.append(sb); // M무게의 최댓값 출력
		bw.flush(); // bw 총 출력
		br.close(); // 입력 종료
		bw.close(); // 출력 종료
	}

	public static void rotate() {
		for (int t = 0; t < min / 2; t++) { // 회전할 그룹의 수만큼
			int x = t; // 초기 index
			int y = t; // 테두리씩 도므로 초기값은 x == y여야 함

			int lastValue = rotation[x][y]; // 마지막 값 미리 저장

			int index = 0; // 방향 벡터 크기만큼 0부터 돌기
			while (index < 4) { // 방량 벡터를 돌면서,
				int nx = x + dx[index]; // 행 index 이동
				int ny = y + dy[index]; // 열 index 이동

				// 현재 방향으로 벽이 안 나올 때까지
				if (nx < N - t && ny < M - t && nx >= t && ny >= t) {
					rotation[x][y] = rotation[nx][ny]; // 값 변경
					x = nx; // x 값 바굼
					y = ny; // y값 바꿈
					continue; // 넘김
				}
				index++; // 반시계 방향대로 값을 바꾸다 벽을 만남 => 방향 바꿈
			}
			rotation[t + 1][t] = lastValue; // 마지막 값 넣어주기
		}
	}
}