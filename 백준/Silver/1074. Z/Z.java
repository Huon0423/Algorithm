/*
 * 이전에 쿼드트리를 풀듯이 했다가 메모리 초과가 났다..
 * 방문해야할 곳이 위치한 4분면만 이동하도록 재귀 함수 수정 => 성공
 * 굳이 arr 배열을 만들지 않고 이동횟수만 visitNum 해도 됨!
 */

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // 입력
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)); // 출력; // 출력을 위한 bw
	static StringTokenizer stk; // 문자열을 자를 stk
	static int visitNum; // 방문 횟수

	public static void main(String[] args) throws NumberFormatException, IOException {
		stk = new StringTokenizer(br.readLine()); // 정수 N, R, C 입력받기
		int N = Integer.parseInt(stk.nextToken()); // N 저장
		int R = Integer.parseInt(stk.nextToken()); // R 저장
		int C = Integer.parseInt(stk.nextToken()); // C 저장

		int length = (int) Math.pow(2, N); // 2의 N 제곱수 => 사각형의 한 변의 길이
		visitArr(length, R, C); // 함수 호출

		bw.write(Integer.toString(visitNum)); // 정답 입력
		bw.flush(); // bw 총 출력
		br.close(); // 입력 종료
		bw.close(); // 출력 종료
	}

	// length는 최대 길이=>2로 나눠짐, row와 col로 4분면 나누기
	static void visitArr(int length, int R, int C) throws IOException {
		if (length == 1) // 가장 작은 곳까지 도달하면
			return; // 재귀 종료

		// 정가운데를 0,0으로 잡고
		// 찾을 곳이 2사분면이라면
		if (R < length / 2 && C < length / 2) { // 2사분면은 원래 배열 탐색 방향이므로 증가할 count 제로
			visitArr(length / 2, R, C); // 사분면으로 이동해서 재귀
		}
		// 찾을 곳이 1사분면이라면
		else if (R < length / 2 && C >= length / 2) {
			visitNum += length * length / 4; // 앞서 이동한 것이라고 친 2사분면만큼 더해준다
			visitArr(length / 2, R, C - length / 2); // 사분면으로 이동해서 재귀
		}
		// 찾을 곳이 3분면이라면
		else if (R >= length / 2 && C < length / 2) {
			visitNum += (length * length / 4) * 2; // 2, 1사분면만큼 더해준다
			visitArr(length / 2, R - length / 2, C); // 사분면으로 이동해서 재귀
		}
		// 찾을 곳이 4사분면이라면
		else {
			visitNum += (length * length / 4) * 3; // 2, 1, 3사분면만큼 더해준다.
			visitArr(length / 2, R - length / 2, C - length / 2); // 사분면으로 이동해서 재귀
		}
	}
}