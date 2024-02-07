import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br; // 입력을 위한 br
	static BufferedWriter bw; // 출력을 위한 bw
	static StringTokenizer stk; // 문자열을 자를 stk

	public static void main(String[] args) throws Exception {
		br = new BufferedReader(new InputStreamReader(System.in)); // 입력
		bw = new BufferedWriter(new OutputStreamWriter(System.out)); // 출력
		int N = Integer.parseInt(br.readLine()); // 검은 색종이 수
		int[][] whiteBoard = new int[100][100]; // 흰색 도화지 => 크기 == 100 * 100
		int field = 0; // 검은 색종이의 영역 넓이

		// 검은 색종이를 한 개씩 줄여가며
		while (N-- > 0) {
			stk = new StringTokenizer(br.readLine()); // 색종이 위치 읽기
			int r = Integer.parseInt(stk.nextToken()); // 색종이의 행
			int c = Integer.parseInt(stk.nextToken()); // 색종이의 열
			
			// 검은 색종이의 넓이만큼 => 받은 위치부터 10씩
			for (int i = r; i < r + 10; i++) {
				for (int j = c; j < c + 10; j++) {
					// 하얀색=0, 검은색=1
					if (++whiteBoard[i][j] == 1) // 겹치는 부분 제외 => 2 이상은 안 셈
						field++; // 영역 증가
				}
			}
		}
		bw.append(Integer.toString(field)); // bw에 값 저장
		bw.flush(); // bw 출력
		br.close(); // 입력 종료
		bw.close(); // 출력 종료
	}
}