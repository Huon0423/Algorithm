import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // 입력
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)); // 출력
	static StringBuilder sb = new StringBuilder(); // 출력 문자 저장
	static int L, C; // 암호의 길이와 사용될 문자의 길이
	static String[] arr; // 사용될 문자를 저장할 배열
	static boolean[] visited; // 방문체크할 배열

	public static void main(String[] args) throws IOException {
		StringTokenizer st = new StringTokenizer(br.readLine()); // 입력값 받기
		L = Integer.parseInt(st.nextToken()); // 암호의 길이
		C = Integer.parseInt(st.nextToken()); // 사용될 문자의 길이

		arr = br.readLine().split(" "); // 공백을 구분하여 저장
		Arrays.sort(arr); // 오름차순으로 알파벳 정렬
		visited = new boolean[C]; // arr 방문 체크 => 같은 크기로 초기화

		dfs(0, 0); // 재귀 함수 소환
		bw.append(sb); // 출력 저장
		bw.flush(); // 출력
	}

	public static void dfs(int index, int count) { // 시작 index와 암호의 현재 개수
		if (count == L) { // 암호 개수에 도달하면
			String code = ""; // 암호를 저장할 문자열
			for (int i = 0; i < C; i++) { // 사용될 문자들을 돌면서
				if (visited[i]) { // 추가함 문자면
					code += arr[i]; // 암호에 집어넣기
				}
			}
			if (checkCode(code)) { // 현재 암호가 조건에 충족한다면
				sb.append(code).append("\n"); // 정답 저장
			}
			return; // 재귀 종료
		}
		for (int i = index; i < C; i++) { // 나(index)보다 큰 수만 넣으면서
			visited[i] = true; // 방문 처리
			dfs(i + 1, count + 1); // 현재 문자보다 큰 다음 문자 넣기
			visited[i] = false; // 방문 취소
		}
	}

	// 암호의 유효성을 검사하는 함수
	public static boolean checkCode(String code) {
		int consonant = 0; // 자음 수
		int vowel = 0; // 모음 수
		char[] codeArr = code.toCharArray(); // code를 char[]로 바꾼 배열
		for (char c : codeArr) {
			// s가 모음이라면
			if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
				consonant++; // 모음 수 증가
				continue; // 넘김
			}
			vowel++; // 자음 수 증가
		}
		if (consonant < 1 || vowel < 2) { // 최소 한 개의 모음과 최소 두 개의 자음 충족X
			return false; // false 반환
		}
		return true; // 조건 충족 => true 반환
	}
}
