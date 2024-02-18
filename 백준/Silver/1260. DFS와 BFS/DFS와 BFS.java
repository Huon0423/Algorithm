import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringBuilder sb = new StringBuilder(); // 출력을 저장할 sb
	static StringTokenizer stk; // 문자열을 자를 stk
	static int N, M, V; // 입력값
	static int count; // 재귀 함수의 이동 횟수
	static int edgeList[][]; // 간선을 저장할 배열
	static boolean visited[]; // 방문 체크할 배열

	public static void main(String[] args) throws IOException, NumberFormatException {
		stk = new StringTokenizer(br.readLine()); // 입력값 받기
		N = Integer.parseInt(stk.nextToken()); // 정점의 개수
		M = Integer.parseInt(stk.nextToken()); // 간선의 개수
		V = Integer.parseInt(stk.nextToken()); // 탐색을 시작할 정점의 번호

		edgeList = new int[1001][1001]; // 정점은 최대 1000까지 => 1부터 시작
		visited = new boolean[1001]; // 방문 체크할 정점은 최대 1000까지 => 1부터 시작

		for (int i = 0; i < M; i++) {
			stk = new StringTokenizer(br.readLine()); // 입력값 받기
			int x = Integer.parseInt(stk.nextToken()); // 행 받기
			int y = Integer.parseInt(stk.nextToken()); // 열 받기

			edgeList[x][y] = edgeList[y][x] = 1; // 간선간의 연결 => 이어진 두 정점 모두 값 변화
		}

		dfs(V); // 탐색을 시작할 정점부터 재귀 호출
		sb.append("\n"); // 출력 양식 저장
		bw.append(sb); // sb 저장

		sb = new StringBuilder(); // sb 초기화
		visited = new boolean[1001]; // 방문 배열 초기화 => DFS로 값이 바뀌었기 때문!
		bfs(V);

		bw.append(sb); // sb 저장
		bw.flush(); // bw 총 출력
		br.close(); // 입력 종료
		bw.close(); // 출력 종료
	}

	static void bfs(int vertex) {
		Deque<Integer> queue = new ArrayDeque<>(); // 정점을 저장할 데큐
		queue.offer(vertex); // 시작 정점을 큐에 추가
		visited[vertex] = true; // 시작 정점 방문 체크
		sb.append(vertex).append(" "); // 방문한 정점 sb에 추가

		while (!queue.isEmpty()) { // 데큐가 비기 전까지
			vertex = queue.poll(); // 큐에서 값 빼기

			for (int i = 1; i <= N; i++) { // 정점만큼 돌며
				// 연결된 정점이고, 아직 방문하지 않은 곳이라면
				if (edgeList[vertex][i] == 1 && visited[i] == false) {
					queue.offer(i); // 큐에 이동할 정점 추가하고
					visited[i] = true; // 추가했으므로 방문 체크
					sb.append(i).append(" "); // 방문한 정점 sb에 추가
				}
			}
		}
	}

	static void dfs(int vertex) {
		visited[vertex] = true; // 방문한 정점 체크
		sb.append(vertex).append(" "); // 방문한 정점 sb에 추가

		if (count == N) { // 정점의 개수만큼 이동하면
			return; // 재귀 종료
		}
		
		for (int i = 1; i <= N; i++) { // 정점만큼 돌며
			// 연결된 정점이고, 아직 방문하지 않은 곳이라면
			if (edgeList[vertex][i] == 1 && visited[i] == false) {
				count++; // 이동횟수 증가
				dfs(i); // 정점 이동
			}
		}
	}
}