/*
 * 백트래킹-재귀를 이용해서 푼다.
 * 출력하기 전, 수열을 보관할 큐를 생성한다 => 배열은 길이가 정해져 있기 때문
 * 1부터 n+1까지 반복문을 돌며, i가 큐에 없다면 집어넣고 재귀, 있다면 continue
 * 큐의 크기가 m과 같다면 출력하고, 큐에서 해당 값을 제거한다.
 * 반복문 안에서 재귀를 부르기 때문에, 전부 다 불린 숫자는 해당 자리에서 다시 나올 수 없음
 * 큐라고 하지만 Dequeue 사용 => 스택처럼 후입선출
 */

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {
	public static int N; // 1부터 N까지의 숫자 => 범위
	public static int M; // 만족해야 하는 수열의 개수
	public static Deque<Integer> sequence; // 1~N개의 숫자 중 M개를 보관할 Dequeue
	public static StringBuilder sb; // 함수에서 쓰기 위한 StringBuilder
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // 입력
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)); // 출력
		String []input = br.readLine().split(" "); // 입력값 배열
		N = Integer.parseInt(input[0]); // 정수로 변환
		M = Integer.parseInt(input[1]); // 정수로 변환
		sequence = new ArrayDeque<Integer>(); // 배열 초기화
		sb = new StringBuilder(40320); // 최댓값이 8이므로 8!까지 수용 가능한 Builder
		
		BackTracking(); // 함수 호출
		bw.append(sb); // bw에 sb 추가
		bw.flush(); // bw에 남은 글자 모두 출력
		br.close(); // 입력 종료
		bw.close(); // 출력 종료
	}
	
	public static void BackTracking() throws IOException {
		if(sequence.size() == M) { // 큐의 크기가 M과 같다면
			for(int q : sequence){ // 0부터 M까지
				sb.append(q); // bw에 수열 추가
				sb.append(" ");
			}
			sb.append("\n");
			return; // 재귀 종료
		}
		for(int i=1; i<N+1; i++) {
			if (!sequence.contains(i)) { // 만약 큐에 i가 없다면
				sequence.addLast(i); // 큐 뒤에 추가
				BackTracking(); // 다시 재귀 => 다음 자리수 찾으러 Go!
				sequence.removeLast(); // 해당 자리수에 i가 있는 경우의 모두 탐색 => i 제거
			}
		}
	}
}
