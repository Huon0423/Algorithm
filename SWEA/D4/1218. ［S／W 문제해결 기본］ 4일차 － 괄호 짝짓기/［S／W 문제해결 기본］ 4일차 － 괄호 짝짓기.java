/*
 * 음,, 아스키코드를 사용하긴 했지만 이게 그렇게 효과적이었을까...?
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
			Deque<Integer> dq = new ArrayDeque<Integer>(); // 괄호를 넣을 dq

			// 괄호 비교
			for (int c : bracket) {
				if (c == 40 || c == 60 || c == 91 || c == 123) { // 여는 괄호라면
					dq.addFirst(c); // 추가
					continue; // 넘김
				}
				if (dq.isEmpty()) { // 닫는 괄호가 들어오는데 큐가 비어있다면
					dq.add(0); // Empty 상태를 벗어나고
					break; // 비교 for문 나가기
				}
				if (Math.abs(dq.peek() - c) > 2) { // 가장 위에 있는 괄호랑 맞지 않으면
					break; // 비교 for문 나가기
				}
				dq.poll(); // 맞는 괄호이므로 여는 괄호 빼기
			}
			if (dq.isEmpty()) { // 비교가 끝났을 때, 남아있는 괄호가 없다면
				sb.append(1).append("\n"); // 성공 추가
				continue; // testCase 넘김
			}
			sb.append(0).append("\n");  // 실패 추가

		}
		bw.append(sb); // bw에 sb 추가
		bw.flush(); // bw 출력
		br.close(); // 입력 종료
		bw.close(); // 출력 종료

	}

}
