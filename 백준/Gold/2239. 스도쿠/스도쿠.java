import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static int[][] sudoku; // 스도쿠 상태를 저장할 배열
	static int N = 9; // 스도쿠의 크기

	public static void main(String[] args) throws IOException {
		sudoku = new int[N][N]; // 9*9의 스도쿠 배열 생성

		for (int i = 0; i < N; i++) {
			String str = br.readLine(); // 행 받기
			for (int j = 0; j < N; j++) {
				sudoku[i][j] = str.charAt(j) - '0'; // 열 입력
			}
		}

		backTracking(); // 함수 호출
	}

	private static void backTracking() { // 백트래킹을 하며 유효한 위치 찾기
		int[] arr = findZeroIdx();
		int x = arr[0], y = arr[1]; // 공란인 스도쿠의 위치
//		for (int i = 0; i < N; i++) {
//			for (int j = 0; j < N; j++) {
//				if (sudoku[i][j] == 0) { // 공란이라면
//					x = i; // 행의 위치 갱신
//					y = j; // 열의 위치 갱신
//				}
//			}
//		}

		if (x == -1) { // 공란이 없으므로 종료
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					sb.append(sudoku[i][j]); // 완성한 스도쿠를 sb에 저장
				}
				sb.append("\n"); // 출력 양식 저장
			}
			System.out.print(sb); // 정답 출력
			System.exit(0);
			; // 재귀를 빠져나가기 위한 강제 종료
		}

		// 1부터 9까지의 숫자를 차례대로 공란에 넣어보기
		for (int i = 1; i <= 9; i++) {
			if (isValid(x, y, i)) { // 유효한 숫자라면
				sudoku[x][y] = i; // 스도쿠 채우기
				backTracking(); // 다음 공란 찾기
				sudoku[x][y] = 0; // 채운 스도쿠 지우기
			}
		}
	}
	
	 private static int[] findZeroIdx() {
	        for(int i=0; i<N; i++) {
	            for(int j=0; j<N; j++) {
	                if(sudoku[i][j] == 0) {
	                    return new int[]{i, j};
	                }
	            }
	        }
	        return new int[]{-1, -1};
	    }

	private static boolean isValid(int x, int y, int num) {
		for (int i = 0; i < N; i++) { // 0~8(N이 9이므로)까지 돌며
			if (sudoku[x][i] == num || sudoku[i][y] == num) {// 행과 열에 같은 숫자가 있다면
				return false; // false 반환
			}
		}

		int px = (x / 3) * 3; // 0, 3, 6만 나오도록 바꿈
		int py = (y / 3) * 3; // 3칸씩 검사해야하기 때문!

		for (int i = px; i < px + 3; i++) { // 행의 시작점부터 3칸
			for (int j = py; j < py + 3; j++) { // 열의 시작점부터 3칸
				if (sudoku[i][j] == num) { // 총 9칸에서 같은 숫자가 존재한다면
					return false; // false 반환
				}
			}
		}
		return true; // 겹치는 숫자가 없으므로 true 반환
	}
}
