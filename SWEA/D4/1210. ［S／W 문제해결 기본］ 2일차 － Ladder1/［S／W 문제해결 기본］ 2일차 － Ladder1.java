import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/*
 * column 0~99까지만 반복문으로 돌린다
 * row 1~99까지 돌면서 column 1개의 이어진 row [1][2] [2][2]~ 이런식으로 검사 
 * 만약 좌우에 1인 값이 있다면 column 변경 => 계속 비교해야 하므로, 재귀함수 사용
 * row가 99까지 도달했을 경우, column값이 도착지점과 일치하는지 비교
 * 만약 일치한다면, 저장해둔 시작값 x를 출력
*/

class Solution {
	static int maxHeight = 100; // 사다리의 행/열 길이
	static int arrived = 2; // 도착지점 == column
	static int[][] ladder; // 사다리를 저장할 배열

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // 입력
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)); // 출력
		StringBuilder sb = new StringBuilder(); // 출력 저장할 곳
		int T = 10; // testCase 횟수
		ladder = new int[maxHeight][maxHeight]; // 배열을 100*100으로 초기화
		int start = 0;

		// testCase만큼 반복
		for (int testCase = 1; testCase <= T; testCase++) {
			br.readLine(); // test_case 값을 받는다.
			sb.append("#").append(Integer.toString(testCase)).append(" "); // 출력 양식 저장

			for (int i = 0; i < maxHeight; i++) { // 사다리 입력 시작
				StringTokenizer st = new StringTokenizer(br.readLine()); // Tokenizer로 입력라인 읽기
				for (int j = 0; j < maxHeight; j++) {
					ladder[i][j] = Integer.parseInt(st.nextToken()); // nextToken을 정수로 받아서 저장
					if (ladder[i][j] == 2) { // 종착점을 발견한다면, start에 index 저장
						start = j;
					}
				}
			}
			sb.append(Integer.toString(checkLastColumn(start))); // 함수에 종착점을 넣고 시작점을 찾아서 bw에 추가
			sb.append("\n"); // 출력 양식 저장
		}
		bw.append(sb); // sb를 bw에 추가
		bw.flush(); // 전체 출력
		br.close(); // 입력 종료
		bw.close(); // 출력 종료
	}

	// 주어진 사다리의 column을 row를 증가시키며 확인
	static int checkLastColumn(int column) {
		for (int row = maxHeight - 1; row >= 0; row--) { // 두번째 줄부터 끝까지 반복
			if (column + 1 < maxHeight && ladder[row][column + 1] == 1) { // 오른쪽에 사다리가 있다면
				while (true) {
					column += 1; // 오른쪽으로 이동
					if (column + 1 >= maxHeight || ladder[row][column + 1] != 1) {
						break;
					}
				}
				continue;
			}
			if (column - 1 >= 0 && ladder[row][column - 1] == 1) { // 왼쪽에 사다리가 있다면
				while (true) {
					column -= 1; // 왼쪽으로 이동
					if (column - 1 < 0 || ladder[row][column - 1] != 1) {
						break;
					}
				}
				continue;
			}
		}
		return column;
	}

}
