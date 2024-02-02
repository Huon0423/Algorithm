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
		int N = Integer.parseInt(br.readLine()); // 주어진 수 N 입력
		Deque<Integer> cards = new ArrayDeque<Integer>();
		for(int i=0; i<N; i++) {
			cards.add(i+1);
		}
		for(int i=0; i<N-1; i++) {
			cards.pollFirst();
			cards.add(cards.pollFirst());
		}
		
		
		bw.append(Integer.toString(cards.pop())); // bw에 값 저장
		bw.flush(); // bw 출력
		br.close(); // 입력 종료
		bw.close(); // 출력 종료
	}

}
