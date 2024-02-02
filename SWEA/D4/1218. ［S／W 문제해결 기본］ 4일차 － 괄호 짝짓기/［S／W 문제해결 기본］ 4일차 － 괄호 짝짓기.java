/*
 * 문자열을 char 배열로 받고 char배열을 for문으로 돌면서 들어오는 c값을 체크한다.
 * 만약 c가 닫는 괄호이며 peek과 맞는 괄호라면 peek을  pop
 * 아니라면 push한다.
 * 맞지 않는 괄호가 하나라도 있다면, 이후 비교가 무의미
 */

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Deque;

class Solution {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // 입력
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)); // 출력
		StringBuilder sb = new StringBuilder(); //
		int T = 10; // testCase의 개수
		for (int testCase = 1; testCase <= T; testCase++) { // testCase 동안
			int N = Integer.parseInt(br.readLine()); // 문자열의 길이 받기
			char[] bracket = br.readLine().toCharArray(); // 문자열 받기
			sb.append("#").append(testCase).append(" "); // 출력 양식 저장

			if (N % 2 == 1) {// 홀수라면 무조건 틀림
				sb.append(0).append("\n"); // 출력 양식 저장
				continue;
			}
			Deque<Character> dq = new ArrayDeque<Character>(); // 괄호를 넣을 dq

			// 괄호 비교
			for (char c : bracket) {
				if ((c == ')' && dq.peek() == '(') || (c == ']' && dq.peek() == '[') || (c == '}' && dq.peek() == '{')
						|| (c == '>' && dq.peek() == '<')) {
					dq.pollFirst();
				} else {
					dq.addFirst(c);
				}
			}
			if(dq.isEmpty()) {
				sb.append(1).append("\n");
				continue;
			}
			sb.append(0).append("\n");
		}
		bw.append(sb); // bw에 sb 추가
		bw.flush(); // bw 출력
		br.close(); // 입력 종료
		bw.close(); // 출력 종료
	}
}