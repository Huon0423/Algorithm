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
		StringBuilder sb = new StringBuilder();
		int T = 10;
		for (int testCase = 1; testCase <= T; testCase++) {
			int N = Integer.parseInt(br.readLine()); // 문자열의 길이 받기
			char[] bracket = br.readLine().toCharArray();
			Deque<Integer> dq = new ArrayDeque<Integer>();
			sb.append("#").append(testCase).append(" "); // 출력 양식 저장

			for (int c : bracket) {
				if (c == 40 || c == 60 || c == 91 || c == 123) {
					dq.addFirst(c);
					continue;
				}
				if (Math.abs(dq.peek() - c) > 2) {
					break;
				}
				dq.poll();
			}
			if (dq.isEmpty()) {
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
