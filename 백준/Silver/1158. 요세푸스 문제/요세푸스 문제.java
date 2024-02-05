import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // 입력
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)); // 출력
		StringTokenizer stk = new StringTokenizer(br.readLine()); // N, K에 값 넣을 StringTokenizer
		int N = Integer.parseInt(stk.nextToken()); // N 입력
		int K = Integer.parseInt(stk.nextToken()); // K 입력
		StringBuilder sb = new StringBuilder(); // 출력 저장할 StringBuilder
		sb.append("<"); // 출력 양식 저장

		LinkedList<Integer> yosefus = new LinkedList<Integer>(); // 수를 저장할 리스트
		for (int i = 1; i <= N; i++) { // 1부터 N까지
			yosefus.add(i); // yosefus 배열에 값 넣기
		}

		int current = K - 1; // 현재 위치 => index는 -1 해줘야 함
		while (yosefus.size() >= 2) { // 리스트에 값이 2개 남을 때까지
			sb.append(yosefus.get(current)).append(", "); // 현재 위치 값 sb에 저장
			yosefus.remove(current); // 현재 위치 값 제거 => size가 1까지
			current = (current + K - 1) % yosefus.size(); // => current 갱신
		}

		sb.append(yosefus.get(current)).append(">"); // 리스트 마지막 값 sb에 저장
		bw.append(sb); // bw에 min 저장
		bw.flush(); // bw 출력
		br.close(); // 입력 종료
		bw.close(); // 출력 종료

	}

}
