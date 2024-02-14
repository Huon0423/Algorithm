import java.io.*;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

class Solution {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // 입력
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)); // 출력
	static StringBuilder sb = new StringBuilder(); // 출력을 저장할 sb
	static int N; // 보드의 크기와 퀸의 개수
	static int count; // 퀸을 놓는 방법의 수
	static int[] queens; // 퀸의 위치를 저장할 배열
	static boolean[] visited; // 방문 체크할 배열

	public static void main(String[] args) throws NumberFormatException, IOException {
		int T = Integer.parseInt(br.readLine()); // N 입력 => 재귀엔 값이 달라지므로 static 선언X
		for (int testCase = 1; testCase <= T; testCase++) {
			sb.append("#").append(testCase).append(" "); // 출력 양식 저장
			N = Integer.parseInt(br.readLine()); // N 입력 => 재귀엔 값이 달라지므로 static 선언X
			count = 0; // 0으로 쵝화
			queens = new int[N]; // N으로 초기화
			visited = new boolean[N]; // N으로 초기화
			
			dfs(0); // 함수 실행
			sb.append(count).append("\n"); // bw에 정답 저장
		}
		bw.append(sb); // bw에 sb 저장
		bw.flush(); // bw 출력
		br.close(); // 입력 종료
		bw.close(); // 출력 종료

	}

	static void dfs(int depth) {
		if (depth == N) { // 만약 퀸을 N개 놓았다면
			count++; // 방법 증가
			return; // 재귀 종료
		}

		for (int i = 0; i < N; i++) {
			if (visited[i]) { // i가 이미 사용된 열이면
				continue; // 넘김
			}
			if (!canQueenLocate(depth, i)) { // depth에 i값 갱신 전 => i값 필수로 넣어줘야 함
				continue; // 넘김
			}
			queens[depth] = i; // depth번째 depth행엔(1차원이지만) i값 == i열에 queen
			visited[i] = true; // 방문 체크
			dfs(depth + 1); // 다음 행을 체크
			visited[i] = false; // 방문 취소
		}

	}

	// 퀸이 그 자리에 위치할 수 있는지 확인하는 함수
	static boolean canQueenLocate(int index, int value) {
		for (int i = 0; i < index; i++) {
			// visited로 열체크 => 대각선 체크만 하면 됨 => 같은 열과 같은 행(1차원 배열이라)은 존재할 수 없음
			if (index - i == value - queens[i] || index - i == queens[i] - value) {
				return false; // 대각선에 위치하면 false 반환
			}
		}
		return true; // 놓을 수 있으므로 true 반환
	}
}