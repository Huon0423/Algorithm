/*
 * 처음 N+1개의 집합은 부모가 자기자신인 서로소 집합 => 배열에 값 저장
 * 부모가 같다면 같은 집합 = 이때 자신의 부모를 바꾸면 합집합X => 자신의 최종 부모를 합칠 부모의 자식으로 삽입
 * 부모를 아무렇게나 연결하지 않기 위해 트리 구조 => 더 작은 쪽이 부모
 * 자기 자신을 가리키는 서로소 집합이 최종 부모 => 재귀를 통해 찾아서 반환
 */

import java.io.*;
import java.util.StringTokenizer;

class Solution {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringBuilder sb = new StringBuilder();
	static int[] set; // 각각의 집합을 이룰 숫자를 저장할 배열

	public static void main(String[] args) throws IOException {
		int T = Integer.parseInt(br.readLine()); // 테스트 케이스 수
		for (int testCase = 1; testCase <= T; testCase++) {
			sb.append("#").append(testCase).append(" "); // 출력 양식 저장
		
			StringTokenizer st = new StringTokenizer(br.readLine()); // 입력값
			int N = Integer.parseInt(st.nextToken()); // 집합의 개수 => N+1
			int M = Integer.parseInt(st.nextToken()); // 연산의 개수
			
			set = new int[N + 1]; // 1부터 시작하므로 N+1개로 초기화
			for (int i = 0; i <= N; i++) {
				set[i] = i; // 값 입력
			}

			while (M-- > 0) { // 연산의 개수 동안 돌며
				st = new StringTokenizer(br.readLine());
				int command = Integer.parseInt(st.nextToken()); // 연산 종류
				int a = Integer.parseInt(st.nextToken()); // 집합 a
				int b = Integer.parseInt(st.nextToken()); // 집합 b

				// 합집합 연산
				if (command == 0) {
					union(a, b); // 두 집합을 하나로 합침
					continue; // 넘김
				}
				
				// 포함 확인 연산
				if (command == 1) {
					if (find(a) == find(b)) { // 두 집합의 각 최종부모가 같다면
						sb.append("1"); // 같은 집합
						continue;
					}
					sb.append("0"); // 다른 집합
				}
			}
			sb.append("\n"); // 출력 양식 저장
		}
		bw.append(sb); // sb 저장
		bw.flush(); // 출력
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
	public static void union(int a, int b) {
		int parentA = find(a); // a의 최종 부모 집합
		int parentB = find(b); // b의 최종 부모 집합
		if (parentA > parentB) {
			set[parentA] = parentB; // 더 작은 쪽이 부모가 됨 => 꼬임 방지
			return;
		}
		set[parentB] = parentA;
	}
}
