import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

class Solution {
	static BufferedReader br; // 입력을 위한 br
	static BufferedWriter bw; // 출력을 위한 bw
	static StringBuilder sb; // 출력을 저장할 sb
	static int N; // 정점의 총수

	public static void main(String[] args) throws Exception {
		br = new BufferedReader(new InputStreamReader(System.in)); // 입력
		bw = new BufferedWriter(new OutputStreamWriter(System.out)); // 출력
		sb = new StringBuilder(); // sb 초기화
		String input = ""; // input 값을 임시로 저장할 변수

		// input 값이 유효하게 들어올 때까지
		for (int testCase = 1; (input = br.readLine()) != null && input.length() > 0; testCase++) {
			sb.append("#").append(testCase).append(" "); // 출력 양식 저장
			N = Integer.parseInt(input); // N 입력받기
			int answer = 1; // 정답 체크할 변수
			for (int node = 0; node < N; node++) { // 총 노드 수만큼 돌며
				String[] info = br.readLine().split(" "); // 노드 정보 받기 => 정점번호, 연산자, 자식 노드 2개
				// 단말노드가 아닌데 정점의 값이 숫자라면, 단말노드인데 정점의 값이 숫자라면 => 계산 불가
				char vertex = info[1].charAt(0); // 연산자 체크
				if ((info.length >= 3 && vertex >= '0') || (info.length < 3 && vertex < '0')) {
					for (int pass = node + 1; pass < N; pass++) { // 다음 순번부터 N까지
						br.readLine(); // 입력 넘김 => 이미 틀린 트리라 연산 무의미
					}
					answer = 0; // 오답으로 바꿈
					break; // 입력을 다 받았으므로, node 빠져나가기 => 다음 testCase
				}
			}
			sb.append(answer).append("\n"); // 정답 저장
		}

		bw.append(sb); // bw에 sb 저장
		bw.flush(); // bw 출력
		br.close(); // 입력 종료
		bw.close(); // 출력 종료
	}
}