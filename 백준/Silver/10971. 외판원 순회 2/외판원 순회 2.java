import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // 입력
	static StringTokenizer st; // 문자열 자를 st
	static int minCost; // 최소 비용
	static int N; // 도시의 수
	static int[][] cost; // 비용 배열
	static boolean[] visited; // 방문 체크할 배열

	public static void main(String[] args) throws NumberFormatException, IOException {
		N = Integer.parseInt(br.readLine()); // 입력 받기
		cost = new int[N][N]; // N*N으로 초기화
		visited = new boolean[N]; // 도시 개수만큼 초기화
		minCost = Integer.MAX_VALUE; // 최솟값 => 최대값으로 초기화

		// 비용 배열 입력받기
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				cost[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		// N개의 도시를 돌며
		for (int i = 0; i < N; i++) {
			visited[i] = true; // 돌아다닌 도시는 방문 체크
			dfs(i, i, 0, 0); // 재귀 함수 호출
		}

		System.out.println(minCost); // 최솟값 출력
	}

	// 이동할 곳과 현재 위치, 깊이와(N개) 비용의 합을 전달
	private static void dfs(int from, int now, int depth, int sum) {
		if (depth == N - 1) { // N개의 도시 => 0~N-1개의 도시
			if (cost[now][from] != 0) { // 비용이 양수라면
				sum += cost[now][from]; // 비용 추가
				minCost = Math.min(minCost, sum); // 최솟값 갱신
			}
			return;
		}
		for (int i = 0; i < N; i++) { // N번을 돌며
			// 비용이 양수이고, 방문하지 않은 도시라면
			if (!visited[i] && cost[now][i] > 0) {
				visited[i] = true; // 방문 처리
				dfs(from, i, depth + 1, sum + cost[now][i]); // 방문 처리 후 재귀 소환
				visited[i] = false; // 방문 취소
			}
		}
	}
}
