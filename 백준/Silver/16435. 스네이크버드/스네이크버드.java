import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br; // 입력을 위한 br
	static BufferedWriter bw; // 출력을 위한 bw
	static StringBuilder sb; // 출력을 저장할 sb
	static StringTokenizer stk; // 문자열을 자를 stk

	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in)); // 입력
		bw = new BufferedWriter(new OutputStreamWriter(System.out)); // 출력
		sb = new StringBuilder(); // sb 초기화
		stk = new StringTokenizer(br.readLine()); // 두 변수를 입력
		int N = Integer.parseInt(stk.nextToken()); // 과일의 개수
		int snakeBird = Integer.parseInt(stk.nextToken()); // snakeBird의 길이
		Integer[] fruits = new Integer[N]; // 과일을 넣을 배열

		stk = new StringTokenizer(br.readLine()); // 과일값 입력
		for (int i = 0; i < N; i++) {
			fruits[i] = Integer.parseInt(stk.nextToken()); // 배열에 과일 저장
		}

		Arrays.sort(fruits); // 과일 배열을 오름차순 정렬
		for (int i = 0; i < N; i++) {
			if (fruits[i] <= snakeBird) { // 과일이 snakeBirde보다 작거나 같을때만
				snakeBird++; // 과일을 먹고 길이가 1 늘어남
			}
		}

		bw.append(Integer.toString(snakeBird)); // bw에 정답 저장
		bw.flush(); // bw 총 출력
		br.close(); // 입력 종료
		bw.close(); // 출력 종료
	}
}