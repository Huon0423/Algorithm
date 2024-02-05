import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;
import java.util.LinkedList;

class Solution {
	static BufferedReader br; // 입력
	static BufferedWriter bw; // 출력
	static StringBuilder sb; // 총 입력할 문자 저장
	static StringTokenizer stk; // 문자열을 자를 tokenizer

	public static void main(String[] args) throws NumberFormatException, IOException {
		br = new BufferedReader(new InputStreamReader(System.in)); // 입력
		bw = new BufferedWriter(new OutputStreamWriter(System.out)); // 출력
		sb = new StringBuilder(); // sb 초기화

		for (int testCase = 1; testCase <= 10; testCase++) { // testCase 동안
			sb.append("#").append(testCase).append(" "); // 출력 양식 저장

			int originLenght = Integer.parseInt(br.readLine()); // 원본 암호문 길이 받기
			LinkedList<Integer> code = new LinkedList<Integer>(); // 암호문을 저장할 배열
			stk = new StringTokenizer(br.readLine());

			// 원본 암호문 저장
			for (int i = 0; i < originLenght; i++) { // 암호문의 길이만큼
				code.add(Integer.parseInt(stk.nextToken().trim())); // 공백으로 끊어 저장
			}

			int order = Integer.parseInt(br.readLine()); // 명령어의 개수
			stk = new StringTokenizer(br.readLine()); // 명령어 => I x의 위치 y개의 숫자 numss

			// 명령어대로 암호문 수정
			for (int i = 0; i < order; i++) { // 명령어 개수만큼
				stk.nextToken(); // I 넘김
				int x = Integer.parseInt(stk.nextToken()); // 위치 x
				int y = Integer.parseInt(stk.nextToken()); // 숫자 개수 y

				// y개 숫자 삽입
				for (int j = 0; j < y; j++) {
					code.add(x++, Integer.parseInt(stk.nextToken())); // x의 위치에 차례대로 삽입 => x 증가
				}
			}

			// 수정된 암호문의 처음 10개 숫자 sb에 저장
			for (int i = 0; i < 10; i++) {
				sb.append(code.get(i)).append(" "); // code의 i번째 숫자 저장
			}
			sb.append("\n"); // 출력 양식 저장
		}
		bw.append(sb); // bw에 min 저장
		bw.flush(); // bw 출력
		br.close(); // 입력 종료
		bw.close(); // 출력 종료
	}
}