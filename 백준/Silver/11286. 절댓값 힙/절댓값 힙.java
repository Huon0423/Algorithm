import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br; // 입력을 위한 br
	static BufferedWriter bw; // 출력을 위한 bw
	static StringBuilder sb; // 출력을 저장할 sb

	public static void main(String[] args) throws NumberFormatException, IOException {
		br = new BufferedReader(new InputStreamReader(System.in)); // 입력
		bw = new BufferedWriter(new OutputStreamWriter(System.out)); // 출력
		sb = new StringBuilder(); // sb 초기화
		int N = Integer.parseInt(br.readLine()); // N 입력받기

		// 우선순위큐 사용 => 절댓값으로 정렬하되, 같다면 작은 쪽으로 오름차순 정렬
		PriorityQueue<Integer> queue = new PriorityQueue<>((o1, o2) -> {
			int num1 = Math.abs(o1); // o1의 절댓값 저장
			int num2 = Math.abs(o2); // o2의 절댓값 저장

			if (num1 == num2) {
				return o1 - o2; // 절댓값이 같다면 작은 쪽 바환
			}
			return num1 - num2; // 절댓값이 더 작은 족 반환
		});

		for (int i = 0; i < N; i++) { // N번 동안
			int num = Integer.parseInt(br.readLine()); // 연산 정보 정수 x 받기
			if (num == 0) { // 절댓값이 가장 작은 값 출력
				if (queue.isEmpty()) { // 큐가 비었다면,
					sb.append(0).append("\n"); // 0 출력
					continue; // 넘김
				}
				sb.append(queue.poll()).append("\n"); // 비지 않았다면 가장 작은 값 추가
				continue; // 넘김
			}
			queue.add(num); // 큐에 num 추가
		}
		bw.append(sb); // bw에 sb 추가
		bw.flush(); // bw 총 출력
		br.close(); // 입력 종료
		bw.close(); // 출력 종료
	}
}