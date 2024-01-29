import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	static String s1 = "\"재귀함수가 뭔가요?\"\n"; // 반복1
	static String s2 = "\"잘 들어보게. 옛날옛날 한 산 꼭대기에 이세상 모든 지식을 통달한 선인이 있었어.\n"; // 반복2
	static String s3 = "마을 사람들은 모두 그 선인에게 수많은 질문을 했고, 모두 지혜롭게 대답해 주었지.\n"; // 만복3
	static String s4 = "그의 답은 대부분 옳았다고 하네. 그런데 어느 날, 그 선인에게 한 선비가 찾아와서 물었어.\"\n"; // 반복4
	static String s5 = "\"재귀함수는 자기 자신을 호출하는 함수라네\"\n"; // 반복이 끝나고 나오는 문장
	static String s6 = "라고 답변하였지.\n"; // 반복을 닫는 문장
	static StringBuilder sb = new StringBuilder(); // 문자를 넣을 StringBuilder

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // 입력
		// BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		// // 출력

		int N = Integer.parseInt(br.readLine()); // 재귀 횟수를 저장할 변수

		sb.append("어느 한 컴퓨터공학과 학생이 유명한 교수님을 찾아가 물었다.\n"); // 반복이 없는 문장 => 재귀x
		recurse(N, 0); // 재귀 함수 호출

		System.out.println(sb); // sb 출력
		br.close();
	}

	static public void recurse(int N, int count) {
		StringBuilder preSb = new StringBuilder(); // 이전 문자를 넣을 StringBuilder => _

		for (int i = 0; i < count * 4; ++i) { // count의 깊이만큼
			preSb.append("_"); // 언더바 추가
		}

		sb.append(preSb + s1); // 시작 질문

		if (count >= N) { // 마지막 호출일 경우,
			sb.append(preSb + s5); // sb_로 언더바를 넣고 s1을 넣는다.
			sb.append(preSb + s6); // sb_로 언더바를 넣고 s5을 넣는다.
			return; // 종료
		}

		sb.append(preSb + s2); // 반복 문장 삽입
		sb.append(preSb + s3); // 반복 문장 삽입
		sb.append(preSb + s4); // 반복 문장 삽입
		recurse(N, count + 1); // 다음 재귀 호출
		sb.append(preSb + s6); // 마지막 문장 삽입
		return; // 종료
	}
}
