import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

class Solution {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // 입력
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)); // 출력
		StringBuilder sb = new StringBuilder(); // 출력 저장용 sb
		String testCase = ""; // 받을 테스트 케이스 번호

		// testCase가 들어올 때까지
		while (((testCase = br.readLine()) != null) && (testCase.length() > 0)) { // testCase 동안
			ArrayDeque<Integer> dq = new ArrayDeque<Integer>(); // 괄호를 넣을 dq
			StringTokenizer stk = new StringTokenizer(br.readLine()); // dq에 넣을 문자 받기
			for (int i = 0; i < 8; i++) { // 8개의 문자
				dq.add(Integer.parseInt(stk.nextToken())); // 값 입력
			}
			sb.append("#").append(Integer.parseInt(testCase)).append(" "); // 출력 양식 저장

			// 암호 만들기 시작
			int cycle = 1; // 빼줄 숫자 1~5 증가
			while (true) { // 암호가 완성될 때까지 돌며
				int num = dq.peek(); // 첫 번째 문자
				
				 // 암호 변환이 가능하면
				if (num - cycle > 0) {
					dq.add(dq.poll() - cycle); // 맨앞의 값에 cycle을 빼고 뒤에 추가
					cycle = cycle % 5 + 1; // cycle을 1~5 범위 내에서 +1
					continue;
				}

				// 암호 완성 조건 충족
				dq.poll(); // 맨 알 값을 빼고
				dq.add(0); // 맨 뒤에 0을 추가
				for (int pw : dq) { // dq를 돌면서
					sb.append(pw).append(" "); // 비밀번호 저장
				}
				sb.append("\n"); // 출력 양식 저장
				break; // 암호 만들기 roop 벗어나기
			}
		}
		bw.append(sb); // bw에 sb 추가
		bw.flush(); // bw 출력
		br.close(); // 입력 종료
		bw.close(); // 출력 종료
	}
}