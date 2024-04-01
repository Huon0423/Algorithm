import java.io.*;
import java.util.*;

public class Solution {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // 입력
	static StringBuilder sb = new StringBuilder(); // 출력을 저장할 sb
	static StringTokenizer st;
	static final int MOD = 1234567891; // 나눌 수
	static int N, R; // 주어진 자연수 N, R

	public static void main(String[] args) throws IOException {
		int T = Integer.parseInt(br.readLine()); // 테스트 케이스 숫자
		for (int testCase = 1; testCase <= T; testCase++) {
			sb.append("#").append(testCase).append(" "); // 출력 양식 저장

			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			R = Integer.parseInt(st.nextToken());

			long arr[] = new long[N + 1];
			arr[0] = 1;
			for (int i = 1; i <= N; i++) {
				arr[i] = (arr[i - 1] * i) % MOD;
			}

			long bottom = (arr[R] * arr[N - R]) % MOD;
			long reBottom = fermat(bottom, MOD - 2);

			sb.append((arr[N] * reBottom) % MOD).append("\n"); // 정답 저장
		}
		System.out.println(sb); // 출력
		br.close(); // 입력 종료
	}

	static long fermat(long N, int x) {
		if (x == 0) { // x가 0이 되면
			return 1; // 함수 종료
		}
		long tmp = fermat(N, x / 2);
		long ret = (tmp * tmp) % MOD;
		if (x % 2 == 0) {
			return ret;
		}
		return (ret * N) % MOD;
	}
}
