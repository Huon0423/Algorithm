/*
 * 보통 dp로 푸는 방식을 활용
 * 이전 색은 나와 다른 색 => 다른 색의 dp[i-1]의 합
 * 색깔별로 dp 배열 가지기
 */

import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // 입력
	static StringTokenizer st; // 문자열 자를 st
	static int N; // 집의 개수
	static int[][] dp; // 사용할 dp

	public static void main(String[] args) throws Exception {
		N = Integer.parseInt(br.readLine()); // 입력 받기
		dp = new int[N + 1][3]; // 0~N까지 채워야 하므로 => N+1

        for (int i = 1; i <= N; i++) { // i-1 >= 0 => i=1로 시작
            st = new StringTokenizer(br.readLine()); // 입력받아서
            int R = Integer.parseInt(st.nextToken()); // 빨간색 칠하는 비용
            int G = Integer.parseInt(st.nextToken()); // 초록색 칠하는 비용
            int B = Integer.parseInt(st.nextToken()); // 파란색 칠하는 비용

            dp[i][0] = Math.min(dp[i - 1][1], dp[i - 1][2]) + R; // 이전 집의 초록+파랑+이번 빨강 비용
            dp[i][1] = Math.min(dp[i - 1][0], dp[i - 1][2]) + G; // 이전 집의 빨강+파랑+이번 초록 비용
            dp[i][2] = Math.min(dp[i - 1][0], dp[i - 1][1]) + B; // 이전 집의 빨강+초록+이번 파랑 비용
        }
        System.out.println(Math.min(dp[N][0], Math.min(dp[N][1], dp[N][2]))); // 각 색의 N번째 요소 출력
	}
}
