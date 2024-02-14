/*
 * N은 언제나 2의 제곱수로 주어지므로, 항상 4개로 쪼갤 수 있음
 * 네 개의 배열로 나눠서 0 또는 1로 이루어져 있는지 검토
 * 만약 섞여 있다면 재귀 => 다시 네 개의 배열로 나눔
 * 재귀를 돌 때마다 여는 괄호 넣기 => return에서 닫는 괄호 넣기
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
	static StringBuilder sb = new StringBuilder(); // 출력을 저장할 sb
	static int[][] video; // 흑백 영상의 0과 1을 저장할 배열
	static int N; // 배열의 크기

	public static void main(String[] args) throws IOException {
		N = Integer.parseInt(br.readLine()); // N 입력받기
		video = new int[N][N]; // video를 N*N 크기로 초기화

		// video 배열 값 받기
		for (int i = 0; i < N; i++) {
			String[] line = br.readLine().split("");
			for (int j = 0; j < N; j++) {
				video[i][j] = Integer.parseInt(line[j]); // 배열에 값 저장
			}
		}

		makeQuadTree(N, 0, 0);

		bw.append(sb); // bw에 sb 추가
		bw.flush(); // bw 총 출력
		br.close(); // 입력 종료
		bw.close(); // 출력 종료
	}

	// depth는 log2 N의 값까지, row와 col로 현재 배열위치 파악
	static void makeQuadTree(int depth, int row, int col) {
		boolean check = true;
		int num = video[row][col]; // 배열의 맨 처음 값
		roop: for (int i = row; i < row + depth; i++) {
			for (int j = col; j < col + depth; j++) {
				if (num != video[i][j]) { // 다른 값이 섞여있다면
					check = false;
					break roop;
				}
			}
		}
		if (check) {
			sb.append(num);
			return;
		}
		sb.append("(");
		makeQuadTree(depth / 2, row, col); // 왼쪽 위
		makeQuadTree(depth / 2, row, col + depth / 2); // 오른쪽 위
		makeQuadTree(depth / 2, row + depth / 2, col); // 왼쪽 아래
		makeQuadTree(depth / 2, row + depth / 2, col + depth / 2); // 오른쪽 아래
		sb.append(")");
	}
}
