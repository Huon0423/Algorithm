import java.util.Scanner;
import java.io.FileInputStream;

class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		int N, M, max, tempSum;
		int[] A, B;
		for (int test_case = 1; test_case <= T; test_case++) {
			max = 0;
			N = sc.nextInt(); M = sc.nextInt();
			A = new int[N]; B = new int[M];
			for (int i = 0; i < N; i++) {
				A[i] = sc.nextInt();
			}
			for (int i = 0; i < M; i++) {
				B[i] = sc.nextInt();
            }
			if (N > M) {
				int temp = N; N = M; M = temp;
				int[] tempArr = A; A = B; B = tempArr;
			}
			for (int i = 0; i <= Math.abs(M - N); i++) {
				tempSum = 0;
				for (int j = 0; j < N; j++) {
					tempSum += A[j] * B[i + j];
				}
				if (max < tempSum) {
					max = tempSum;
				}
			}
			System.out.printf("#%d %d\n", test_case, max);
		}
	}
}