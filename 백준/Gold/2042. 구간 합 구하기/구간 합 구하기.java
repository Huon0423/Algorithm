import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringBuilder sb = new StringBuilder(210000);
	static StringTokenizer stk;

	static final int maxN = 1000000;
	static long[] arr = new long[maxN + 1];
	// node 번호와 배열의 길이는 별개 => 번호는 임의로 1부터 시작 => maxN*4번째는 사용하지 않으므로 +1 안해도 됨
	static long[] segmentTree = new long[maxN * 4];

	public static void main(String[] args) throws IOException {
		stk = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(stk.nextToken());
		int M = Integer.parseInt(stk.nextToken());
		int K = Integer.parseInt(stk.nextToken());

		// arr 입력받기
		for (int i = 1; i <= N; i++) {
			arr[i] = Long.parseLong(br.readLine()); // long 형변환
		}

		// segmentTree build
		build(1, 1, N);

		// query 처리
		int Q = M + K; // query 총 개수
		while (Q-- > 0) {
			stk = new StringTokenizer(br.readLine());
			int queryType = Integer.parseInt(stk.nextToken());

			// 수정할 경우
			if (queryType == 1) {
				int uIndex = Integer.parseInt(stk.nextToken()); // 바꿀 인덱스
				long x = Long.parseLong(stk.nextToken()); // 바꿀 값 => long 주의
				update(1, 1, N, uIndex, x);
				continue;
			}
			// 구간합 경우
			int qLeft = Integer.parseInt(stk.nextToken());
			int qRight = Integer.parseInt(stk.nextToken());
			sb.append(query(1, 1, N, qLeft, qRight)).append("\n"); // 구간합을 sb에 저장
		}
		bw.append(sb);
		bw.flush();
		br.close();
		bw.close();
	}

	// node 번호와 지금 node가 보고 있는 구간을 매개변수로 받는 함수
	static void build(int node, int left, int right) {
		if (left == right) { // 구간의 양쪽 끝이 같은 경우 == 리프노드
			segmentTree[node] = arr[left]; // 배열의 값 저장
			return; // 재귀 반환
		}
		int mid = (left + right) / 2; // 구간을 절반으로 나눈 값
		build(node * 2, left, mid); // 왼쪽 자식 노드
		build(node * 2 + 1, mid + 1, right); // 오른쪽 자식 노드
		// 부모 노드의 값은 두 자식노드의 값을 더한 값
		segmentTree[node] = segmentTree[node * 2] + segmentTree[node * 2 + 1];
		return; // 재귀 반환
	}

	// node 번호와 지금 node가 보고 있는 구간, query의 왼쪽 끝과 오른쪽 끝
	static long query(int node, int left, int right, int qLeft, int qRight) {
		// 현재 구간이 query 구간의 왼쪽 끝보다 작거나 오른쪽 끝보다 클때 => node 값 반영 안됨
		if (right < qLeft || qRight < left) {
			return 0;
		}
		// 현재 구간이 query 구간 안에 모두 포함된다면 => node 값 반영
		if (qLeft <= left && right <= qRight) {
			return segmentTree[node];
		}
		// 현재 구간이 query 구간 사이에 걸친 경우
		int mid = (left + right) / 2;
		long leftResult = query(node * 2, left, mid, qLeft, qRight);
		long rightResult = query(node * 2 + 1, mid + 1, right, qLeft, qRight);
		return leftResult + rightResult; // 양 값을 더해서 반영
	}

	// top-down 방식이므로 node 번호와 지금 node가 보고 있는 구간, 바꿀 인덱스와 값
	static void update(int node, int left, int right, int uIndex, long x) {
		// 변경할 리프 노드가 나올 때까지 포함된 구간을 좁혀나가며 재귀
		// 자식 노드들이 호출되었다는건 구간 내에 리프 노드가 존재 => 변경된 값을 다시 합해서 갱신

		// 바꿀 인덱스가 현재 구간에 포함되지 않는 경우
		if (uIndex < left || uIndex > right) {
			return; // 더 내려가도 소용 없음
		}

		// 양쪽 끝이 바꿀 인덱스일 경우 == 리프노드이며 변경해야 할 노드 도달
		if (left == uIndex && uIndex == right) {
			segmentTree[node] = x; // 값 변경
			return; // 재귀 끝
		}
		// 리프 노드는 아니지만 구간 안에 바꿀 인덱스가 존재할 경우
		int mid = (left + right) / 2;
		update(node * 2, left, mid, uIndex, x);
		update(node * 2 + 1, mid + 1, right, uIndex, x);
		// 변경된 자식 노드의 값을 부모 노드에 반영
		segmentTree[node] = segmentTree[node * 2] + segmentTree[node * 2 + 1];
		return;
	}
}