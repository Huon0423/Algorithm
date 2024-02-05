import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer stk = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(stk.nextToken());

		// 다음날에 1부터 더해주기 위해 +1, N날까지 일한 돈은 N+1날에 얻을 수 있기에 +1 => +2
		int[] consulting = new int[N + 2];
		int[] day = new int[N + 2]; // N일째 나오는 일은 consulting[N~]이후로만 할 수 있기에
		int[] money = new int[N + 2]; // consulting과 맞춰준다.

		// 1부터 N까지 물건의 무게와 가치 받기
		for (int i = 1; i <= N; i++) { // 그러나 N+1번째 날엔 일하지 않으므로 N까지만 받기
			stk = new StringTokenizer(br.readLine());
			day[i] = Integer.parseInt(stk.nextToken());
			money[i] = Integer.parseInt(stk.nextToken());
		}

		int max = Integer.MIN_VALUE;
		// day 1부터 day N+1까지 월급 비교 => N날까지 일한 월급은 consulting[N+1]에 저장되므로
		for (int i = 1; i <= N + 1; i++) {
			// tomorrow의 consulting index 범위 때문에 Math.max를 실행 안 할 수도 있음
			if (max < consulting[i]) {
				max = consulting[i];
			}
			int tomorrow = i + day[i];
			if (tomorrow < N + 2) {
				consulting[tomorrow] = Math.max(consulting[tomorrow], max + money[i]);
			}
		}

		bw.append(Integer.toString(max)); // K무게의 최댓값 출력
		bw.flush();
		br.close();
		bw.close();
	}
}