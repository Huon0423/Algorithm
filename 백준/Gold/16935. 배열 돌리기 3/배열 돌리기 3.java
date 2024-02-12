import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br; // 입력을 위한 br
	static BufferedWriter bw; // 출력을 위한 bw
	static StringBuilder sb; // 출력을 저장할 sb
	static StringTokenizer stk; // 문자열을 자를 stk
	private static int[][] arr; // 숫자를 저장할 이차원 배열
	private static int N; // 배열의 행 수
	private static int M; // 배열의 열 수
	private static int r; // 명령의 수

	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in)); // 입력
		bw = new BufferedWriter(new OutputStreamWriter(System.out)); // 출력
		sb = new StringBuilder(); // sb 초기화

		stk = new StringTokenizer(br.readLine()); // 값 입력받기
		N = Integer.parseInt(stk.nextToken()); // 행 받기
		M = Integer.parseInt(stk.nextToken()); // 열 받기
		r = Integer.parseInt(stk.nextToken()); // 명령 수 받기

		// 배열 입력받기
		arr = new int[N][M]; // 배열을 N x M 크기로 초기화
		for (int i = 0; i < N; i++) {
			stk = new StringTokenizer(br.readLine()); // 행의 수 받아서
			for (int j = 0; j < M; j++) {
				arr[i][j] = Integer.parseInt(stk.nextToken()); // 각 열마다 넣기
			}
		}

		// 명령어에 따라 배열 돌리기
		stk = new StringTokenizer(br.readLine()); // r개의 명령 받기
		for (int i = 0; i < r; i++) { // r번만큼
			switch (stk.nextToken()) { // switch에 명령어 넣어주기
			case "1": // 상하반전으로 돌리기
				switchUpDown(); // 함수 호출
				break; // switch 나가기
			case "2": // 좌우반전으로 돌리기
				switchLeftRight(); // 함수 호출
				break; // switch 나가기
			case "3": // 오른쪽 90도로 돌리기
				arr = rotateRight(); // 함수 호출
				break; // switch 나가기
			case "4": // 왼쪽 90도로 돌리기
				arr = rotateLeft(); // 함수 호출
				break; // switch 나가기
			case "5": // 4덩이로 나눠서 시계방향으로 돌리기
				rotateClockWise(); // 함수 호출
				break; // switch 나가기
			case "6": // 4덩이로 나눠서 반시계방향으로 돌리기
				rotateCounterClockWise(); // 함수 호출
				break; // switch 나가기
			}
		}

		// 돌린 배열 출력 저장하기
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				sb.append(arr[i][j]).append(" "); // sb에 배열 저장
			}
			sb.append("\n"); // 양식 맞추기
		}

		bw.append(sb); // bw에 sb 추가
		bw.flush(); // bw 총 출력
		br.close(); // 입력 종료
		bw.close(); // 출력 종료
	}

	private static void switchUpDown() { // 상하반전 함수
		int height = N / 2; // 높이 절반

		// 반으로 나눠서 위 아래를 교환
		for (int i = 0; i < height; i++) { // 절반만큼만
			for (int j = 0; j < M; j++) {
				int num = arr[i][j]; // 값 교환을 위해 수 저장
				arr[i][j] = arr[N - 1 - i][j]; // 위 배열에 아랫값 넣기
				arr[N - 1 - i][j] = num; // 아래 배열에 윗값 넣기
			}
		}
	}

	private static void switchLeftRight() { // 좌우반전 함수
		int width = M / 2; // 넓이 절반

		// 반으로 나눠서 오른쪽 왼쪽 교환
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < width; j++) { // 절반만큼만
				int num = arr[i][j]; // 값 교환을 위해 수 저장
				arr[i][j] = arr[i][M - 1 - j]; // 왼쪽 배열에 오른쪽 값 넣기
				arr[i][M - 1 - j] = num; // 오른쪽 배열에 왼쪽 값 넣기
			}
		}
	}

	private static int[][] rotateRight() { // 오른쪽 90도 함수
		int[][] tmpArr = new int[M][N]; // 90도 돌린 값을 저장할 배열

		for (int i = 0; i < M; i++) { // 90도 돌림 == 행>열 전환
			int[] line = new int[N]; // tempArr의 행에 해당할 배열
			for (int j = 0; j < N; j++) {
				line[j] = arr[N - 1 - j][i]; // 오른쪽은 마지막 열이 첫번째 행 => N-1-j
			}
			tmpArr[i] = line; // 배열 값 갱신
		}
		int num = M; // N과 M을 바꿔야함 => 같은 수가 아니므로 index 에러 => 저장해둘 변수
		M = N; // M에 N값 갱신
		N = num; // N에 M값 갱신
		return tmpArr; // 새 배열 반환
	}

	private static int[][] rotateLeft() { // 왼쪽 90도 함수
		int[][] tmpArr = new int[M][N]; // 90도 돌린 값을 저장할 배열

		for (int i = 0; i < M; i++) { // 90도 돌림 == 행>열 전환
			int[] line = new int[N]; // tempArr의 행에 해당할 배열
			for (int j = 0; j < N; j++) {
				line[j] = arr[j][M - 1 - i]; // 왼쪽으로 돌리므로 0부터 시작
			}
			tmpArr[i] = line; // 배열 값 갱신
		}
		int num = M; // N과 M을 바꿔야함 => 같은 수가 아니므로 index 에러 => 저장해둘 변수
		M = N; // M에 N값 갱신
		N = num; // N에 M값 갱신
		return tmpArr; // 새 배열 반환
	}

	private static void rotateClockWise() { // 4덩이 시계방향 함수
		int height = N / 2; // 높이 절반
		int width = M / 2; // 넓이 절반
		int[][] one = new int[height][width]; // 첫번째 배열
		int[][] two = new int[height][width]; // 두번째 배열
		int[][] three = new int[height][width]; // 세번째 배열
		int[][] four = new int[height][width]; // 네번째 배열

		// 행->열 우선순위로 4배열 분할
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (i < height && j < width) { // 범위가 첫번째 그룹이라면
					one[i][j] = arr[i][j]; // 갑 분할해서 넣기
					continue; // 넘김
				}
				if (i < height && j >= width) { // 범위가 두번째 그룹이라면
					two[i][j - width] = arr[i][j]; // 갑 분할해서 넣기
					continue; // 넘김
				}
				if (i >= height && j < width) { // 범위가 세번째 그룹이라면
					three[i - height][j] = arr[i][j]; // 갑 분할해서 넣기
					continue; // 넘김
				}
				// 범위가 네번째 그룹이라면
				four[i - height][j - width] = arr[i][j]; // 갑 분할해서 넣기
			}
		}

		// 시계방향으로 돌리기
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (i < height && j < width) { // 첫번째 배열
					arr[i][j] = three[i][j]; // 세번째 배열 값 넣기
					continue; // 넘김
				}
				if (i < height && j >= width) { // 두번째 배열
					arr[i][j] = one[i][j - width]; // 첫번째 배열 값 넣기
					continue; // 넘김
				}
				if (i >= height && j < width) { // 세번째 배열
					arr[i][j] = four[i - height][j]; // 네번째 배열 값 넣기
					continue; // 넘김
				}
				// 네번째 배열
				arr[i][j] = two[i - height][j - width]; // 두번째 배열 값 넣기
			}
		}
	}

	private static void rotateCounterClockWise() { // 4덩이 반시계방향 함수
		int height = N / 2; // 높이 절반
		int width = M / 2; // 넓이 절반
		int[][] one = new int[height][width]; // 첫번째 배열
		int[][] two = new int[height][width]; // 두번째 배열
		int[][] three = new int[height][width]; // 세번째 배열
		int[][] four = new int[height][width]; // 네번째 배열

		// 행->열 우선순위로 4배열 분할
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (i < height && j < width) { // 범위가 첫번째 그룹이라면
					one[i][j] = arr[i][j]; // 갑 분할해서 넣기
					continue; // 넘김
				}
				if (i < height && j >= width) { // 범위가 두번째 그룹이라면
					two[i][j - width] = arr[i][j]; // 갑 분할해서 넣기
					continue; // 넘김
				}
				if (i >= height && j < width) { // 범위가 세번째 그룹이라면
					three[i - height][j] = arr[i][j]; // 갑 분할해서 넣기
					continue; // 넘김
				}
				// 범위가 네번째 그룹이라면
				four[i - height][j - width] = arr[i][j]; // 갑 분할해서 넣기
			}
		}

		// 반시계방향으로 돌리기
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (i < height && j < width) { // 첫번째 배열
					arr[i][j] = two[i][j]; // 두번째 배열 값 넣기
					continue; // 넘김
				}
				if (i < height && j >= width) { // 두번째 배열
					arr[i][j] = four[i][j - width]; // 네번째 배열 값 넣기
					continue; // 넘김
				}
				if (i >= height && j < width) { // 세번째 배열
					arr[i][j] = one[i - height][j]; // 첫번째 배열 값 넣기
					continue; // 넘김
				}
				// 네번째 배열
				arr[i][j] = three[i - height][j - width]; // 세번째 배열 값 넣기
			}
		}
	}
}