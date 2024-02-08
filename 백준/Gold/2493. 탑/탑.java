// https://www.acmicpc.net/problem/2493

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br; // 입력을 위한 br
	static BufferedWriter bw; // 출력을 위한 bw
	static StringBuilder sb; // 출력을 저장할 sb
	static StringTokenizer stk; // 문자열을 자를 stk

	static class Tower { // 탑의 정보를 저장할 객체
		int index; // 순서
		int height; // 높이

		Tower(int index, int height) { // 생성자
			this.index = index; // index 입력
			this.height = height; // height 입력
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		br = new BufferedReader(new InputStreamReader(System.in)); // 입력
		bw = new BufferedWriter(new OutputStreamWriter(System.out)); // 출력
		sb = new StringBuilder(); // sb 초기화
		Deque<Tower> laser = new ArrayDeque<Tower>(); // tower를 저장할 데큐
		int N = Integer.parseInt(br.readLine()); // 탑의 개수 받기
		stk = new StringTokenizer(br.readLine()); // 탑의 높이 받기

		// Tower 받으면서 laser 체크
		for (int i = 1; i <= N; i++) {
			Tower t = new Tower(i, Integer.parseInt(stk.nextToken())); // 높이 받아서 Tower 생성
			
			while (true) {
				if (laser.isEmpty()) { // 데큐가 비어있다면,
					sb.append(0).append(" "); // 0 입력
					laser.addLast(t); // tower 추가
					break; // while 빠져나가기
				}
				
				if (laser.peekLast().height <= t.height) { // 가장 가까운 탑의 높이가 더 작으면

					laser.pollLast(); // 가장 가까운 탑 제거
					continue; // 넘김
				}
				sb.append(laser.peekLast().index).append(" "); // 나보다 큰 탑의 index 저장
				laser.addLast(t); // 현재 탑을 데큐에 추가
				break; // while 빠져나가기
			}
		}
		bw.append(sb); // bw에 min 저장
		bw.flush(); // bw 출력
		br.close(); // 입력 종료
		bw.close(); // 출력 종료
	}

}
