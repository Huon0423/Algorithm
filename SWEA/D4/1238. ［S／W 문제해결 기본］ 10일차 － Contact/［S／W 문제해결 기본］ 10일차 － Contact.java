import java.io.*;
import java.util.*;

class Solution {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // 입력
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)); // 출력
	static StringBuilder sb = new StringBuilder(); // 출력 문자 저장
	static int[][] graph; // 최대 크기로 만든 연락 저장할 배열
	static boolean[] visited;

	public static void main(String[] args) throws IOException {
		for (int testCase = 1; testCase <= 10; testCase++) {
			sb.append("#").append(testCase).append(" "); // 출력 양식 저장
			graph = new int[101][101]; // 배열 초기화
			visited = new boolean[101]; // 배열 초기화

			StringTokenizer st = new StringTokenizer(br.readLine()); // 입력값 받기
			int dataLength = Integer.parseInt(st.nextToken()); // 데이터의 길이
			int start = Integer.parseInt(st.nextToken()); // 시작점

			// 연락 그래프에 입력값 넣기 => 2개씩 끊어넣으므로 최대크기의 절반까지만 돌기
			st = new StringTokenizer(br.readLine()); // 입력값 받기
			for (int i = 0; i < dataLength / 2; i++) {
				int from = Integer.parseInt(st.nextToken()); // 연락하는자
				int to = Integer.parseInt(st.nextToken()); // 연락받는자
				graph[from][to] = 1; // 인접행렬
			}

			Deque<Integer> q = new ArrayDeque<>(); // 연락할 사람을 넣을 큐
			List<Integer> maxCounts = new ArrayList<>(); // 연락받은 사람중 큰 숫자만 넣을 리스트
			q.add(start); // q에 시작 값 넣기
			visited[start] = true; // 시작점 방문 처리
			
			while (!q.isEmpty()) { // q가 비기 전까지
				int size = q.size(); // 동시에 연락 => 연락의 깊이를 알기 위함
				int count = 0; // 연락받은 사람 중 가장 큰 사람

				for (int i = 0; i < size; i++) { // 저장된 큐를 돌며
					int row = q.poll(); // q에서 연락할 사람 뽑기
					for (int j = 1; j < 101; j++) {
						// 연락할 수 있고, 방문한 적 없다면
						if (graph[row][j] == 1 && !visited[j]) {
							q.add(j); // 연락받은 사람 추가
							count = Math.max(count, j);
							visited[j] = true;
						}
					}
				}
				maxCounts.add(count); // 한꺼번에 연락받은 사람들 중에서 가장 큰 사람만 저장
			}
			sb.append(maxCounts.get(maxCounts.size() - 2)).append("\n"); // 정답 출력
		}
		bw.append(sb);
		bw.flush();
	}
}
