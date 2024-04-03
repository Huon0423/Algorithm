import java.io.*;
import java.util.*;

public class Solution {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // 입력
	static StringBuilder sb = new StringBuilder(); // 출력을 저장할 sb
	static StringTokenizer st;
	static int N, M, Tall, Short; // 주어진 자연수 N, M과 큰 학생 수와 작은 학생 수
	static int[][] map; // 인접행렬

	public static void main(String[] args) throws IOException {
		int T = Integer.parseInt(br.readLine()); // 테스트 케이스 숫자
		for (int testCase = 1; testCase <= T; testCase++) {
			sb.append("#").append(testCase).append(" "); // 출력 양식 저장
			int answer = 0; // 정답 초기화

			N = Integer.parseInt(br.readLine()); // 학생 수
			M = Integer.parseInt(br.readLine()); // 비교 횟수
			map = new int[N + 1][N + 1]; // 인접행렬 초기화

			for (int i = 0; i < M; i++) { // 비교 횟수만큼 돌며
				st = new StringTokenizer(br.readLine());
				int from = Integer.parseInt(st.nextToken()); // 작은 친구
				int to = Integer.parseInt(st.nextToken()); // 큰 친구
				map[from][to] = 1; // 인접행렬에 값 넣기
			}

			for (int i = 1; i <= N; i++) { // 학생들을 쭉 둘러보며
				// 돌 때마다 초기화해줘야 함
				Tall = 0;
				Short = 0;
				findTaller(i, new boolean[N+1]);
				findShorter(i, new boolean[N+1]);
				// i보다 큰애+작은애의 합이 전체 학생수-1
				if (Tall + Short == N - 1) {
					answer += 1; // 자신의 번호르 알 수 있는 학생 수 증가
				}
			}
			sb.append(answer).append("\n"); // 정답 저장
		}
		System.out.print(sb); // 출력
		br.close(); // 입력 종료
	}

	static void findTaller(int student, boolean[] visited) {
		visited[student] = true;
		for (int t = 1; t <= N; t++) {
			// 방문하지 않았고, 나보다 큰 애가 존재한다면
			if (!visited[t] && map[student][t] == 1) {
				findTaller(t, visited);
				Tall++;
			}
		}
	}

	static void findShorter(int student, boolean[] visited) {
		visited[student] = true;
		for (int s = 1; s <= N; s++) {
			// 방문하지 않았고, 나보다 작은 애가 존재한다면
			if (!visited[s] && map[s][student] == 1) {
				findShorter(s,visited);
				Short++;
			}
		}
	}

}
