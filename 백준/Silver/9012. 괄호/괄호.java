import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // 입력
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)); // 출력
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for (int testCase = 1; testCase <= T; testCase++) {
			char[] bracket = br.readLine().toCharArray();
			Deque<Integer> dq = new ArrayDeque<Integer>();

			for (int c : bracket) {
				if (c == 40) {
					dq.addFirst(c);
					continue;
				}
				if(dq.isEmpty()) {
					dq.add(1);
					break;
				}
				if (Math.abs(dq.peek() - c) > 2) {
					break;
				}
				dq.poll();
			}
			if (dq.isEmpty()) {
				sb.append("YES").append("\n");
				continue;
			}
			sb.append("NO").append("\n");
		}
		bw.append(sb); // bw에 sb 추가
		bw.flush(); // bw 출력
		br.close(); // 입력 종료
		bw.close(); // 출력 종료

	}

}
