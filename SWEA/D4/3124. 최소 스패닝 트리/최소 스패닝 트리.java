import java.io.*;
import java.util.*;

class Solution {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // 입력
	static StringBuilder sb = new StringBuilder(); // 출력을 저장할 sb
	static int V, E; // 정점과 간선
	static int[] set; // find-union 알고리즘을 사용하기 위한 배열

	public static void main(String[] args) throws NumberFormatException, IOException {
		int T = Integer.parseInt(br.readLine()); // testCase의 수
		for (int testCase = 1; testCase <= T; testCase++) {

			StringTokenizer st = new StringTokenizer(br.readLine());
			V = Integer.parseInt(st.nextToken()); // 정점의 개수
			E = Integer.parseInt(st.nextToken()); // 간선의 개수

			set = new int[V + 1]; // 1부터 사용 => V+1 초기화
			for (int i = 1; i <= V; i++) { // 1부터 V까지
				set[i] = i; // 값 넣기
			}

			// 가중치로 우선순위를 만든 큐
			PriorityQueue<int[]> q = new PriorityQueue<>((o1, o2) -> o1[2] - o2[2]);
			for (int i = 0; i < E; i++) { // 간선의 개수만큼 돌며
				st = new StringTokenizer(br.readLine()); // 입력값
				// q에 연결된 정점 a, b와 간선의 가중치 c로 이루어진 배열을 추가
				q.offer(new int[] { Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()),
						Integer.parseInt(st.nextToken()) });
			}

			int n = 0;
			long result = 0;
			while (n != V - 1) {
				int[] graph = q.poll();
				if (!union(graph[0], graph[1]))
					continue;
				result += graph[2];
				n++;
			}
			sb.append("#").append(testCase).append(" ").append(result).append("\n");
		}
		System.out.print(sb); // 정답 출력
	}

	// 재귀를 통해 n의 최종 부모 찾기 => set[n]이 부모
	public static int find(int n) {
		if (n == set[n]) { // 자기 자신이 부모라면
			return set[n]; // 최종 부모 반환
		}
		// find(set[n); // 재귀만 부르면 부모를 찾을 때 오래 걸림 => 부모 정리 필요
		return set[n] = find(set[n]); // 3의 부모인 2의 부모인 1 => 3의 부모인 1로 최적화
	}

	// 최종 부모의 값을 자기 자신이 아닌 합칠 다른 부모로 바꾸는 함수
	public static boolean union(int a, int b) {
		int parentA = find(a); // a의 최종 부모 집합
		int parentB = find(b); // b의 최종 부모 집합

		if (parentA == parentB) { // 부모가 같다면
			return false; // 순환하므로 false 반환
		}

		int parentMin = Math.min(parentA, parentB); // 둘 중 더 작은 쪽을
		set[parentA] = parentMin; // 부모 노드로
		set[parentB] = parentMin; // 부모 노드로

		return true; // true 반환
	}
}
