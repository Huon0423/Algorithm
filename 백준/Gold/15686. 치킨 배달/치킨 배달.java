import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

class Location {
	int x, y;

	Location(int x, int y) {
		this.x = x;
		this.y = y;
	}
}

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st; // 문자열을 자를 stk
	static int N, M; // 도시의 크기와 폐업시키지 않을 치킨 집의 개수
	static ArrayList<Location> store; // 가게 리스트
	static ArrayList<Location> home; // 집 리스트
	static boolean[] visited; // 가게들을 방문 체크할 배열
	static int totalDistance = Integer.MAX_VALUE; // 도시의 치킨 거리의 최소 합

	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken()); // 도시 크기
		M = Integer.parseInt(st.nextToken()); // 치킨 집 개수

		store = new ArrayList<Location>();
		home = new ArrayList<Location>();
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				int n = Integer.parseInt(st.nextToken()); // 숫자 받기
				if (n == 2) { // 가게라면
					store.add(new Location(i, j)); // 가게 리스트에 가게 추가
					continue; // 넘김
				}
				if (n == 1) { // 집이라면
					home.add(new Location(i, j)); // 집 리스트에 집 추가
				}
			}
		}

		visited = new boolean[store.size()]; // 가게의 크기만큼 초기화
		dfs(0, 0); // 가게의 시작 index와 처음 치킨집의 개수를 전달
		System.out.println(totalDistance); // 정답 출력 => 치킨 거리의 최소 합
	}

	static void dfs(int index, int count) { // 재귀하며 최소합을 이루는 가게를 찾는 함수
		if (count == M) { // 가게 수가 M개를 충족하면
			int tmpDistance = 0; // M개의 가게와 각 집들의 치킨 거리를 저장할 변수

			for (int h = 0; h < home.size(); h++) { // 집집마다 돌며
				int minDistance = Integer.MAX_VALUE; // 집과 치킨집 사이의 최소 거리
				for (int s = 0; s < store.size(); s++) { // 가게를 다 돌며
					if (visited[s]) { // 방문한 가게라면 => M에 포합된 가게라면
						// 가게와 집의 거리를 구한다.
						int distance = Math.abs(home.get(h).x - store.get(s).x)
								+ Math.abs(home.get(h).y - store.get(s).y);
						minDistance = Math.min(minDistance, distance); // 최소 거리 갱신
					}
				}
				tmpDistance += minDistance; // 이번 M개 치킨집 조합의 도시 치킨 거리를 구한다.
			}
			// 더 작은 조합의 합으로 도시 치킨 거리 갱신
			totalDistance = Math.min(totalDistance, tmpDistance);
			return; // 재귀 종료
		}

		// 아직 가게가 M개 미만이면
		for (int i = index; i < store.size(); i++) { // index부터(같은 가게 포함되지 않게) 가게를 돌며
			visited[i] = true; // 방문한 가게 체크
			dfs(i + 1, count + 1); // 나 외의 가게를 집어넣기
			visited[i] = false; // 가게 방문 취소
		}
	}
}
