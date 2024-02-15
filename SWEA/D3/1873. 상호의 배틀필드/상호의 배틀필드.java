import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

class Solution {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // 입력
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)); // 출력
	static StringBuilder sb = new StringBuilder(); // 출력을 저장할 sb
	static StringTokenizer stk; // 문자열을 자를 stk
	static char[][] map; // 게임 맵
	static int H, W; // 게임 맵의 크기
	static int[] dx = { -1, 1, 0, 0 }; // 네 방향 벡터
	static int[] dy = { 0, 0, -1, 1 }; // 상하좌우

	public static void main(String[] args) throws NumberFormatException, IOException {
		int T = Integer.parseInt(br.readLine()); // testCase 수

		for (int testCase = 1; testCase <= T; testCase++) { // testCase만큼 돌며
			sb.append("#").append(testCase).append(" "); // 출력 양식 저장
			StringTokenizer st = new StringTokenizer(br.readLine()); // 게임 맵 크기 받기
			H = Integer.parseInt(st.nextToken()); // 게임 맵의 높이
			W = Integer.parseInt(st.nextToken()); // 게임 맵의 너비

			// 게임 맵 구성 받기
			map = new char[H][W]; // H*W 크기의 char 형이 담길 게임 맵 배열
			for (int i = 0; i < H; i++) {
				char[] arr = br.readLine().toCharArray(); // 게임 맵의 행 받기
				for (int j = 0; j < W; j++) {
					map[i][j] = arr[j]; // 각 열에 문자 넣어주기
				}
			}

			int x = 0; // 전차의 행 위치
			int y = 0; // 전차의 열 위치
			for (int i = 0; i < H; i++) {
				for (int j = 0; j < W; j++) {
					// 어느 방향을 보든 전차를 찾는다면 => 전차는 1개뿐
					if (map[i][j] == '<' || map[i][j] == '>' || map[i][j] == '^' || map[i][j] == 'v') {
						x = i; // 행 위치 설정
						y = j; // 열 위치 설정
						break; // for 문 벗어나기
					}
				}
			}

			int inputNum = Integer.parseInt(br.readLine()); // 입력의 개수
			char[] commands = br.readLine().toCharArray(); // 명령어 배열

			int nStatus = 0; // 다음 값
			int direction = 0; // 전차의 현재 상태
			int nx = 0; // 전차의 다음 행 위치
			int ny = 0; // 전차의 다음 열 위치
			if (map[x][y] == '^') {
				direction = 0; // 위를 보는 전차
			} else if (map[x][y] == 'v') {
				direction = 1; // 아래를 보는 전차
			} else if (map[x][y] == '<') {
				direction = 2; // 왼쪽을 보는 전차
			} else if (map[x][y] == '>') {
				direction = 3; // 오른쪽을 보는 전차
			} else {
				direction = -1;
			}

			for (int i = 0; i < inputNum; i++) { // 명령어 개수만큼 돌며
				char command = commands[i]; // 명령어 하나씩 받기

				switch (command) {
				case 'U': { // 위쪽을 바라보는 전차
					direction = 0; // 전차의 상태 업데이트
					map[x][y] = '^'; // 현재 상태를 위를 보는 전차로 바꿔줌
					nx = x + dx[0]; // 위로 이동
					ny = y + dy[0]; // 위로 이동

					// 위로 이동할 수 있고, 그곳에 평지가 있다면
					if (checkRange(nx, ny) && map[nx][ny] == '.') {
						map[nx][ny] = '^'; // 평지를 위를 보고 있는 전차로 바꾸고
						map[x][y] = '.'; // 원래 위치를 평지로 바꿈 => 이동했음
						x = nx; // 현재 위치를 바꿔줌
						y = ny; // 현재 위치를 바꿔줌
					}
					break;
				}
				case 'D': { // 아래쪽을 바라보는 전차
					direction = 1; // 전차의 상태 업데이트
					map[x][y] = 'v'; // 현재 상태를 아래를 보는 전차로 바꿔줌
					nx = x + dx[1]; // 아래로 이동
					ny = y + dy[1]; // 아래로 이동

					// 아래쪽으로 이동할 수 있고, 그곳에 평지가 있다면
					if (checkRange(nx, ny) && map[nx][ny] == '.') {
						map[nx][ny] = 'v'; // 평지를 전차로 바꾸고
						map[x][y] = '.'; // 원래 위치를 평지로 전환
						x = nx; // 위치 갱신
						y = ny; // 위치 갱신
					}
					break;
				}
				case 'L': { // 왼쪽을 바라보는 전차
					direction = 2; // 전차의 상태 업데이트
					map[x][y] = '<'; // 현재 상태를 왼쪽을 보는 전차로 바꿔줌
					nx = x + dx[2]; // 왼쪽으로 이동
					ny = y + dy[2]; // 왼쪽으로 이동

					// 왼쪽으로 이동할 수 있고, 그곳에 평지가 있다면
					if (checkRange(nx, ny) && map[nx][ny] == '.') {
						map[nx][ny] = '<'; // 평지를 전차로 바꾸고
						map[x][y] = '.'; // 원래 위치를 평지로 전환
						x = nx; // 위치 갱신
						y = ny; // 위치 갱신
					}
					break;
				}
				case 'R': { // 오른쪽을 바라보는 전차
					direction = 3; // 전차의 상태 업데이트
					map[x][y] = '>'; // 현재 상태를 오른쪽을 보는 전차로 바꿔줌
					nx = x + dx[3]; // 오른쪽으로 이동
					ny = y + dy[3]; // 오른쪽으로 이동

					// 오른쪽로 이동할 수 있고, 그곳에 평지가 있다면
					if (checkRange(nx, ny) && map[nx][ny] == '.') {
						map[nx][ny] = '>'; // 평지를 전차로 바꾸고
						map[x][y] = '.'; // 원래 위치를 평지로 전환
						x = nx; // 위치 갱신
						y = ny; // 위치 갱신
					}
					break;
				}
				case 'S': { // 포탄 발사
					int sx = x; // 포탄이 부딪치는 행
					int sy = y; // 포탄이 부딪치는 열

					// 포탄이 부딪치는 곳이 범위 안에 존재할 때까지
					while (checkRange(sx, sy)) {
						sx += dx[direction]; // 전차가 보는 방향으로 계속 이동
						sy += dy[direction]; // 전차가 보는 방향을 계속 이동
						// 이동한 곳이 범위 안이라면
						if (checkRange(sx, sy)) {
							nStatus = map[sx][sy]; // 다음 이동할 곳 지정

							if (nStatus == '*') { // 벽돌이라면
								map[sx][sy] = '.'; // 평지로 바꿈
								break; // 나가기
							}
							if (nStatus == '#') { // 강철이라면
								break; // 나가기
							}
							if (nStatus == '.' || nStatus == '-') { // 평지나 물이라면
								continue; // 넘김
							}
						}
						break; // 범위를 벗어났으므로 나가기
					}
				}
				}
			}

			// 현재 맵의 상태 표시
			for (int i = 0; i < H; i++) {
				for (int j = 0; j < W; j++) {
					sb.append(map[i][j]); // 맵의 상태를 sb에 저장
				}
				sb.append("\n"); // 출력 양식
			}
		}
		bw.append(sb); // bw에 sb 입력
		bw.flush(); // bw 총 출력
		br.close(); // 입력 종료
		bw.close(); // 출력 종료
	}

	// 배열의 범위 내에 존재하는지 확인하는 함수
	static boolean checkRange(int x, int y) {
		// 범위 내에 존재한다면
		if (x >= 0 && x < H && y >= 0 && y < map[x].length) {
			return true; // true 반환
		}
		return false; // 아니면 false 반환
	}
}