import java.io.*;
import java.util.*;

class Point {
	int x, y;
	int time; // 복구하는 데 든 시간

	Point(int x, int y, int time) {
		this.x = x;
		this.y = y;
		this.time = time;
	}
}

public class Solution {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	static int N; // 지도의 크기
	static int min; // 최솟값을 저장할 변수
	static int[][] map; // 지도 정보를 저장할 배열
	static boolean[][] isVisited; // 방문 체크할 배열
	static int[] dx = { 0, 0, -1, 1 }; // 방향벡터
	static int[] dy = { -1, 1, 0, 0 }; // 상하좌우

	public static void main(String[] args) throws IOException {
		int T = Integer.parseInt(br.readLine()); // testCase
		for (int testCase = 1; testCase <= T; testCase++) {
			sb.append("#").append(testCase).append(" "); // 출력 문구 저장
			min = Integer.MAX_VALUE; // 최솟값 초기화

			N = Integer.parseInt(br.readLine()); // 지도 크기 받기
			map = new int[N][N]; // N * N 크기로 초기화
			isVisited = new boolean[N][N]; // 방문 체크 배열 초기화
			for (int i = 0; i < N; i++) {
				String s = br.readLine();
				for (int j = 0; j < N; j++) {
					map[i][j] = s.charAt(j) - '0'; // 지도 정보 넣기
				}
			}

			bfs(0, 0);
			sb.append(min).append("\n"); // 정답 저장
		}
		System.out.print(sb); // 정답 출력
		br.close(); // 입력 종료
	}

	static void bfs(int x, int y) {
		// 복구 시간이 빠른 순서대로 우선순위 큐
		PriorityQueue<Point> q = new PriorityQueue<>(Comparator.comparingInt((nd) -> nd.time));

		q.add(new Point(x, y, 0)); // 처음 포인트 추가
		isVisited[x][y] = true; // 처음 위치 방문 처리

		while (!q.isEmpty()) { // 큐가 빌 때까지
			Point p = q.poll(); // 현재 위치

			int cX = p.x; // 현재 행
			int cY = p.y; // 현재 열
			int cTime = p.time; // 현재 위치까지의 복구 타임

			if (cX == N - 1 && cY == N - 1) { // 도착지에 오면
				min = Math.min(min, cTime); // 최솟값 갱신
			}

			for (int v = 0; v < 4; v++) { // 뱡향 벡터를 돌며
				int nx = cX + dx[v]; // 이동할 행
				int ny = cY + dy[v]; // 이동할 열

				// 범위 내에 있으며 방문 전인 포인트라면
				if (nx >= 0 && nx < N && ny >= 0 && ny < N && !isVisited[nx][ny]) {
					int totalTime = cTime + map[nx][ny]; // 추가 복구 시간과 현재까지의 복구 시간의 합
					q.add(new Point(nx, ny, totalTime)); // 이동할 좌표와 총 시간을 큐에 넣기
					isVisited[nx][ny] = true; // 방문 처리
				}

			}

		}

	}
}
