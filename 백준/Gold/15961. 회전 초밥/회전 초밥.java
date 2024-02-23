/*
 * K범위가 중요! => 슬라이딩 윈도우 풀이 기법
 * 슬라이딩 윈도우의 시간 복잡도 === O(N)
 * N의 최댓값 === 3백만 => 1억 미만이라 괜찮다!
 * 순환을 생각하지 않고 N-K까지 돌렸다가 엄청 틀렸다..
 */

import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // 입력
	static StringBuilder sb = new StringBuilder(); // 출력을 저장할 sb
	static int N, D, K, C; // 입력값 저장
	static int[] sushi; // 초밥을 저장할 배열
	static int[] type; // 초밥의 종류와 개수를 저장할 배열
	static int max = 1; // 먹은 초밥의 가짓수를 저장할 변수 => 쿠폰 카운트 미리 저장
	static int i; // for 문 용

	public static void main(String[] args) throws IOException {
		StringTokenizer st = new StringTokenizer(br.readLine()); // 입력값
		N = Integer.parseInt(st.nextToken()); // 접시의 개수
		D = Integer.parseInt(st.nextToken()); // 초밥의 가짓수
		K = Integer.parseInt(st.nextToken()); // 연속해서 먹는 점시의 수
		C = Integer.parseInt(st.nextToken()); // 쿠폰 번호

		// 회전초밥 순서대로 받기
		sushi = new int[N];
		for (i = 0; i < N; i++) {
			sushi[i] = Integer.parseInt(br.readLine()); // 초밥 받기
		}

		// 0부터 K개의 초밥의 종류를 세서 새로운 초밥이 나올 때마다 count+1
		type = new int[D + 1]; // 1부터 세는게 더 편함
		type[C]++; // 쿠폰으로 먹은 초밥 종류 개수 증가
		for (i = 0; i < K; i++) {
			if (type[sushi[i]] == 0) { // 처음 먹는 초밥이라면
				max++; // 가짓수 증가
			}
			type[sushi[i]]++; // 먹은 초밥 종류 개수 +1
		}

		// K번부터 끝까지 K개를 유지하며 count개수 세기
		int count = max; // 슬라이딩 윈도우를 하며 저장할 가짓수
		for (i = 1; i <= N; i++) { // 순환하므로 슬라이딩 윈도우를 1부터 마지막까지 다 돌려야 함

			// 뒤의 초밥 먹기
			if (type[sushi[(i + K - 1) % N]] == 0) { // 첫번째 index+K-1번째 => 순환하므로 %n
				count++; // 먹은 가짓수 +1
			}
			type[sushi[(i + K - 1) % N]]++; // 먹은 종류 개수 +1

			// 앞의 초밥 토하기(?)
			type[sushi[i - 1]]--; // 제외한 종류 개수 -1
			if (type[sushi[i - 1]] == 0) { // 첫번째로 먹은 초밥을 제외하고 0이 되면
				count--; // 먹은 가짓수 -1
			}
			if (max < count) {
				max = count;
			}
		}
		System.out.println(max); // 정답 출력
	}
}
